package com.smartclide.pipeline_converter.input.jenkins;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.output.GitlabCIOutputConverter;

public class JenkinsfileReader {

	private static String SECTION_OPENING="^\\s*(\\w+[^\\{]*)\\{\\s*$";
	private static String SECTION_CLOSING="^\\s*}\\s*$";
	private static String SECTION_TYPE_AND_NAME="^\\s*(\\w+)\\s*(\\(\\'?([^\\)\\']*)\\'?\\))?\\s*\\{$";
	
	public Node read(File file) throws FileNotFoundException {
	    Scanner sc = new Scanner(file);
	    Node root = null;
	    Node current = null;
	    
	    try(sc){
		    while (sc.hasNextLine()) {
		    	String line = sc.nextLine().strip();
		    	if(line.matches(SECTION_OPENING)) {
		    		current = createNode(line, current);
		    	}else if(line.matches(SECTION_CLOSING)) {
		    		if(current.getParent().isEmpty()) {
		    			root = current;
		    		}
		    		current = current.getParent().orElse(null);
		    	}else {
		    		if(current != null) {
		    			current.getContent().add(line.stripLeading());
		    		}
		    	}
		    }
	    }
	    return root;
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
