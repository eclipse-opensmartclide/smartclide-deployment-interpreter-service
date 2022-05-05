package com.smartclide.pipeline_converter.input.jenkins;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.output.GitlabCIOutputConverter;

@Component
public class JenkinsfileReader {

	private static final String ONE_LINE_NODE = "^\\s*(\\w+[^\\{]*?)\\{(.*?)\\}$";
	private static String SECTION_OPENING="^\\s*(\\w+[^\\{]*)\\{\\s*$";
	private static String SECTION_CLOSING="^\\s*}\\s*$";
	private static String SECTION_TYPE_AND_NAME="^\\s*(\\w+)\\s*(\\(\\'?(.*?)\\'?\\))?\\s*\\{$";
	
	public Node read(File file) throws FileNotFoundException {
	    return read(new FileInputStream(file));
	}
	
	public Node read(InputStream is) {
		Scanner sc = new Scanner(is);
	    Node root = null;
	    Node current = null;
	    
	    try(sc){
		    while (sc.hasNextLine()) {
		    	String line = sc.nextLine().strip();
		    	if(line.isBlank()||
		    			line.startsWith("#")||
		    			line.startsWith("//")||
		    			line.startsWith("/*")||
		    			line.startsWith("*")) {
		    		continue;
		    	}
		    	current = processLine(current, line);
		    	if(current!=null && current.getParent().isEmpty()) {
		    		root = current;
		    	}
		    	
		    }
	    }
	    return root;
	}

	private Node processLine(Node current, String line) {
		String tester = line.replaceAll("\\$\\{.*?\\}", "VAR");
		if(tester.matches(ONE_LINE_NODE)) {
			String[] lines = line.split("(?<=\\{)|(?=\\})");
			for(int i=0;i<lines.length;i++) {
				current = processLine(current, lines[i]);
			}
		}
		else if(tester.matches(SECTION_OPENING)) {
			current = createNode(line, current);
		}else if(tester.matches(SECTION_CLOSING)) {
			current = current.getParent().orElse(null);
		}else {
			if(current != null) {
				current.getContent().add(line);
			}
		}
		return current;
	}
	
	private Node createNode(String line, Node current) {
		Matcher m = Pattern.compile(SECTION_TYPE_AND_NAME).matcher(line);
		m.find();
		String type = m.group(1);
		String title = "";
		if(m.groupCount() > 1) {
			title = m.group(3);
		}
		Node newNode = new Node(type,title);
		newNode.setParent(current);
		if(current != null) {
			current.getChildren().add(newNode);
		}
		return newNode;
	}

	public static void main(String...strings) throws Exception {
//		System.out.println("#!/usr/bin/env groovy".matches(SECTION_OPENING));
//		System.out.println("pipeline {".matches(SECTION_OPENING));
//		System.out.println("        stage('stage one') {".matches(SECTION_OPENING));
//		System.out.println("        } ".matches(SECTION_CLOSING));
//		System.out.println(new JenkinsfileParser().parseInput(new File("target/classes/jenkinsfile_1")));
		Node jenkinsPipeline = new JenkinsfileReader().read(new File("target/classes/jenkinsfile_4"));
		System.out.println(jenkinsPipeline);
		
		Pipeline gitlabPipeline = new GitlabCIOutputConverter().convert(jenkinsPipeline);
		
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory()
//        		.enable(YAMLGenerator.Feature.CANONICAL_OUTPUT)
        		.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
        		.enable(YAMLGenerator.Feature.INDENT_ARRAYS_WITH_INDICATOR)
        		);
        try {
//            Pipeline cfg = mapper.readValue(new File("target/classes/test.yaml"), Pipeline.class);
//            System.out.println(ReflectionToStringBuilder.toString(cfg,ToStringStyle.MULTI_LINE_STYLE));
////            cfg.getJobs().values().forEach(v -> {System.out.println(v.getClass());});
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.setSerializationInclusion(Include.NON_EMPTY);

            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gitlabPipeline));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		
	}
	
}
