package com.smartclide.pipeline_converter.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smartclide.pipeline_converter.input.gitlab.model.Filter;
import com.smartclide.pipeline_converter.input.gitlab.model.Job;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.Node;

public class GitlabCIOutputConverter {
	
	private static Logger log = LoggerFactory.getLogger(GitlabCIOutputConverter.class);

	public Pipeline convert(Node pipelineRoot) {
		Pipeline pipeline = new Pipeline();
		pipelineRoot.getContent().forEach(s -> {
			if(!s.equals("agent any") && s.startsWith("agent")) {
				pipeline.get_default().getTags().add(s.substring("agent ".length()));
			}else {
				log.info("Discarded content: "+ s);
			}
			//TODO verify if there can be more/different content at this level
		});
		
		pipelineRoot.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "agent": processAgentNode(pipeline.get_default(), node);break;
			
			case "environment": pipeline.setVariables(processEnvironmentNode(node));break;

			case "stages": {
				processStagesNode(node).forEach(job -> pipeline.addJob(job.getName(), job));
				break;
			}
			
			case "post": {
				pipeline.addJob("post", processStageNode(Optional.of(".post"), node));
				break;
			}
			
			case "options": processOptionsNode(pipeline.get_default(), node);break;
			
			default: log.info("Discarded content: "+ node);
			}
		});
		
		pipeline.getJobs().values().stream().map(Job::getStage).forEach(pipeline.getStages()::add);
		
		return pipeline;
	}

	private List<Job> processStagesNode(Node stagesNode) {
		List<Job> jobs = new ArrayList<Job>();
		stagesNode.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "stage": {
				jobs.addAll(processStageNode(Optional.empty(),node));
				break;
			}
			default: log.info("Discarded content: "+ node);
			}			
		});
		return jobs;
	}

	private List<Job> processStageNode(Optional<String> currentStage, Node stageNode) {
		List<Job> jobs = new ArrayList<Job>();
		
		Job job = new Job();
		job.setName(stageNode.getName());
		if(currentStage.isPresent()) {
			job.setStage(currentStage.get());
			job.addExtends(currentStage.get().substring(1));
		}else {
			job.setStage(job.getName());
		}
		jobs.add(job);
		
		stageNode.getContent().forEach(s -> {
			if(!s.equals("agent any") && s.startsWith("agent")) {
				job.getTags().add(s.substring("agent ".length()));
			}else {
				log.info("Discarded content: "+ s);
			}
			//TODO verify if there can be more/different content at this level
		});
		stageNode.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "agent": processAgentNode(job, node);break;
			
			case "environment": job.setVariables(processEnvironmentNode(node));break;

			case "parallel": {
				//job becomes a hidden reusable configuration block and
				//parallel jobs get grouped under a stage with the name of the
				//original job
				String stage = job.getName();
				job.setName("."+job.getName());
				job.setStage(null);
				jobs.addAll(processParallelNode(Optional.of(stage), job, node));
				break;
			}
			
			case "steps": {
				job.setScript(processStepsNode(node));
				break;
			}
			
			case "post": {
				node.setName(node.getType());
				jobs.addAll(processStageNode(Optional.of(".post"), node));
				break;
			}

//			case "matrix": processMatrixNode(job, node);break;
//			
			case "options": processOptionsNode(job, node);break;
			
			case "when": processWhenNode(job, node);break;
			
			default: log.info("Discarded content: "+ node);
			}
		});
		return jobs;
	}

	private List<String> processStepsNode(Node stepsNode) {
		stepsNode.getChildren().forEach(node -> {
			log.info("Discarded content: "+ node);
		});
		return stepsNode.getContent();
	}

	private void processWhenNode(Job job, Node whenNode) {
		whenNode.getContent().forEach(s -> {
			Filter only = Optional.ofNullable(job.getOnly()).orElse(new Filter());
			if(s.startsWith("branch")||s.startsWith("tag")) {
				Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']$",Pattern.MULTILINE).matcher(s);
				m.find();
				only.addRef(m.group(1));
			}else if(s.startsWith("buildingTag")) {
				only.addRef("tags");
			}else if(s.startsWith("changeRequest")) {
				only.addRef("merge_requests");
			}else {
				log.info("Discarded content: "+ s);
			}
			job.setOnly(only);
			//TODO attempt to handle other content at this level
		});
		whenNode.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "not": processWhenNotNode(job, node);
			default: log.info("Discarded content: "+ node);
			}
		});
	}
	private void processWhenNotNode(Job job, Node whenNode) {
		whenNode.getContent().forEach(s -> {
			Filter except = Optional.ofNullable(job.getExcept()).orElse(new Filter());
			if(s.startsWith("branch")||s.startsWith("tag")) {
				Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']$",Pattern.MULTILINE).matcher(s);
				m.find();
				except.addRef(m.group(1));
			}else if(s.startsWith("buildingTag")) {
				except.addRef("tags");
			}else if(s.startsWith("changeRequest")) {
				except.addRef("merge_requests");
			}else {
				log.info("Discarded content: "+ s);
			}
			job.setExcept(except);
			//TODO attempt to handle other content at this level
		});
	}

	private void processOptionsNode(Job job, Node optionsNode) {
		optionsNode.getContent().forEach(s -> {
			if(s.startsWith("timeout")) {
				Matcher m = Pattern.compile("timeout\\s*\\(\\s*time:\\s*(\\d+)\\s*,\\s*unit:\\s*'(\\w+)'\\s*\\)").matcher(s);
				m.find();
				job.setTimeout(m.group(1)+" "+m.group(2).toLowerCase());
			}else {
				log.info("Discarded content: "+ s);
			}
			//TODO attempt to handle other content at this level
		});
	}

	private List<Job> processParallelNode(Optional<String> stage, Job job, Node parallelNode) {
		List<Job> jobs = new ArrayList<Job>();
		parallelNode.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "stage": {
				jobs.addAll(processStageNode(stage,node));
				break;
			}
			default: log.info("Discarded content: "+ node);
			}			
		});
		return jobs;
	}

	private Map<String, String> processEnvironmentNode(Node environmentNode) {
		Map<String, String> env = new HashMap<String, String>();
		environmentNode.getContent().forEach(s -> {
			String[] parts = s.split("\\s*=\\s*");
			env.put(parts[0], parts[1]);
		});
		return env;
	}

	private void processAgentNode(Job job, Node agentNode) {
		agentNode.getContent().forEach(s -> {
			String[] parts = s.split(" ");
			switch(parts[0]) {
			case "label": job.getTags().add(parts[1]);break;
			case "docker": job.getImage().setName(parts[1]);break;
			default: log.info("Discarded content: "+s);
			}
		});
		agentNode.getChildren().forEach(node ->{
			switch(node.getType()) {
			case "node": processAgentNode(job, node);
			case "docker": processAgentDockerNode(job, node);
			default: log.info("Discarded content: "+ node);
			}
		});
	}

	private void processAgentDockerNode(Job job, Node dockerNode) {
		dockerNode.getContent().forEach(s -> {
			String[] parts = getContentParts(s);
			switch(parts[0]) {
			case "label": job.getTags().add(parts[1]);break;
			case "image": job.getImage().setName(parts[1]);break;
			default: log.info("Discarded content: "+s);
			}
		});
	}
	
	private String[] getContentParts(String value) {
		String[] parts = new String[2];
		parts[0] = value.substring(0,value.indexOf(" "));
		parts[1] = value.substring(value.indexOf(" ")+1);
		return parts;
	}
}
