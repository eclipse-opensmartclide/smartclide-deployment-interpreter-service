package com.smartclide.pipeline_converter.output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.smartclide.pipeline_converter.input.gitlab.model.DockerImage;
import com.smartclide.pipeline_converter.input.gitlab.model.Filter;
import com.smartclide.pipeline_converter.input.gitlab.model.Job;
import com.smartclide.pipeline_converter.input.gitlab.model.JobJobDependency;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.gitlab.model.Retry;
import com.smartclide.pipeline_converter.input.gitlab.model.Rule;
import com.smartclide.pipeline_converter.input.gitlab.model.RunConditions;
import com.smartclide.pipeline_converter.input.jenkins.Node;

@Component
public class GitlabCIOutputConverter {
	
	private static Logger log = LoggerFactory.getLogger(GitlabCIOutputConverter.class);

	public Pipeline convert(Node pipelineRoot) {
		if(pipelineRoot != null) {
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
					processPipelinePostNode(node).forEach(job -> pipeline.addJob(job.getName(), job));;
					break;
				}
				
				case "options": processOptionsNode(pipeline.get_default(), node);break;
				
				default: log.info("Discarded content: "+ node);
				}
			});
			
			pipeline.getJobs().values().stream()
			.map(Job::getStage)
			.filter(Objects::nonNull)
			.collect(Collectors.toCollection(LinkedHashSet::new))
			.forEach(pipeline.getStages()::add);

			return pipeline;
		}
		return null;
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
		currentStage.ifPresentOrElse(stage -> {
			job.setStage(currentStage.get());
			if(!stage.equals(".post")) {
				job.addExtends("."+currentStage.get());
			}
		}, () -> {
			job.setStage(job.getName());
			
		});
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
				jobs.addAll(processParallelNode(Optional.of(stage), node));
				break;
			}
			
			case "steps": {
				job.setScript(processStepsNode(node));
				break;
			}
			
			case "post": {
				node.setName(job.getName());
				List<String> parentJobNames = jobs.subList(1, jobs.size()).stream().map(Job::getName).collect(Collectors.toList());
				jobs.addAll(processStagePostNode(node, parentJobNames));
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

	private List<Job> processStagePostNode(Node stagePostnode, List<String> parentJobNames) {
		List<Job> postJobs = new ArrayList<Job>();
		
		stagePostnode.getChildren().forEach(node ->{
			Job job = new Job();
			job.setName(stagePostnode.getName()+":"+node.getType());
			if(parentJobNames.isEmpty()) {
				job.setStage(stagePostnode.getName());
				job.getNeeds().add(new JobJobDependency(stagePostnode.getName()));
			}else {
				job.setStage("post"+stagePostnode.getName());
				parentJobNames.stream().map(JobJobDependency::new).forEach(job.getNeeds()::add);
			}
			job.setScript(processStepsNode(node));
			job.setWhen(getRunConditionsForNodeType(node.getType())); 
			postJobs.add(job);
		});
		return postJobs;
	}
	
	private List<Job> processPipelinePostNode(Node pipelinePostnode) {
		List<Job> postJobs = new ArrayList<Job>();
		
		pipelinePostnode.getChildren().forEach(node ->{
			Job job = new Job();
			job.setName("post_pipeline:"+node.getType());
			job.setStage(".post");
			job.setScript(processStepsNode(node));
			job.setWhen(getRunConditionsForNodeType(node.getType())); 
			postJobs.add(job);
		});
		return postJobs;	
	}
	
	private RunConditions getRunConditionsForNodeType(String nodeType) {
		switch(nodeType) {
		case "cleanup":
		case "always": return RunConditions.always;
		
//		case "changed": 
		case "fixed":
		case "success": return RunConditions.on_success;
			
		case "regression":
		case "aborted":
		case "failure":
		case "unstable":
		case "unsuccessful": return RunConditions.on_failure;

		default: {
			log.info("Unparseable run condition: "+ nodeType);
			return null;
		}
		}
	}

	private List<String> processStepsNode(Node stepsNode) {
		List<String> allContent = new ArrayList<String>();
		
		stepsNode.getChildren().forEach(node -> allContent.addAll(processStepsNode(node)));
			
		allContent.addAll(stepsNode.getContent());
		return allContent;
	}

	private void processWhenNode(Job job, Node whenNode) {
		whenNode.getContent().forEach(s -> {
			if(s.startsWith("branch")||s.startsWith("tag")) {
				Filter only = Optional.ofNullable(job.getOnly()).orElse(new Filter());
				Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']",Pattern.MULTILINE).matcher(s);
				m.find();
				only.addRef(m.group(1));
				job.setOnly(only);
			}else if(s.startsWith("buildingTag")) {
				Filter only = Optional.ofNullable(job.getOnly()).orElse(new Filter());
				only.addRef("tags");
				job.setOnly(only);
			}else if(s.startsWith("changeRequest")) {
				Filter only = Optional.ofNullable(job.getOnly()).orElse(new Filter());
				only.addRef("merge_requests");
				job.setOnly(only);
			}else if(s.startsWith("expression")) {
				Matcher m = Pattern.compile("expression \\{(.*?)\\}",Pattern.MULTILINE).matcher(s);
				m.find();
				Rule rule = new Rule();
				rule.set_if(m.group(1));
				job.getRules().add(rule);
			}else {
				log.info("Discarded content: "+ s);
			}
			//TODO attempt to handle other content at this level
		});
		whenNode.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "not": processWhenNotNode(job, node);break;
			case "expression": {
				node.getContent().forEach(s ->{
					Rule rule = new Rule();
					rule.set_if(s);
					job.getRules().add(rule);
				});
				
				break;
			}
			case "allOf": {
				Rule rule = new Rule();
				StringBuilder condition= new StringBuilder();
				node.getContent().forEach(s ->{
					if(s.startsWith("branch")) {
						Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$CI_COMMIT_BRANCH == \"").append(m.group(1)).append("\" && ");
					}else if(s.startsWith("environment")) {
						Matcher m = Pattern.compile("environment name:\\s*[\"'](\\w*)[\"'], value:\\s*[\"'](\\w*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$").append(m.group(1)).append("==").append(m.group(2)).append(" && ");
					}else {
						log.info("Discarded content: "+ s);
					}
				});
				rule.set_if(condition.substring(0, condition.lastIndexOf(" && ")));
				job.getRules().add(rule);
				
				break;
			}
			case "anyOf": {
				StringBuilder condition= new StringBuilder();
				node.getContent().forEach(s ->{
					Rule rule = new Rule();
					if(s.startsWith("branch")) {
						Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$CI_COMMIT_BRANCH == \"").append(m.group(1));
					}else if(s.startsWith("environment")) {
						Matcher m = Pattern.compile("environment name:\\s*[\"'](\\w*)[\"'], value:\\s*[\"'](\\w*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$").append(m.group(1)).append("==").append(m.group(2));
					}else {
						log.info("Discarded content: "+ s);
						return;
					}
					rule.set_if(condition.toString());
					job.getRules().add(rule);
				});
				
				break;
			}
			default: log.info("Discarded content: "+ node);
			}
		});
	}
	private void processWhenNotNode(Job job, Node whenNotNode) {
		whenNotNode.getContent().forEach(s -> {
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
		whenNotNode.getChildren().forEach(node -> {
			switch(node.getType()) {
			case "expression": {
				node.getContent().forEach(s ->{
					Rule rule = new Rule();
					rule.set_if(s);
					rule.setWhen(RunConditions.never);
					job.getRules().add(rule);
				});
				
				break;
			}
			case "allOf": {
				Rule rule = new Rule();
				StringBuilder condition= new StringBuilder();
				node.getContent().forEach(s ->{
					if(s.startsWith("branch")) {
						Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$CI_COMMIT_BRANCH == \"").append(m.group(1)).append("\" && ");
					}else if(s.startsWith("environment")) {
						Matcher m = Pattern.compile("environment name:\\s*[\"'](\\w*)[\"'], value:\\s*[\"'](\\w*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$").append(m.group(1)).append(" == ").append(m.group(2)).append(" && ");
					}else {
						log.info("Discarded content: "+ s);
					}
				});
				rule.set_if(condition.substring(0, condition.lastIndexOf(" && ")));
				rule.setWhen(RunConditions.never);
				job.getRules().add(rule);
				
				break;
			}
			case "anyOf": {
				node.getContent().forEach(s ->{
					StringBuilder condition= new StringBuilder();
					Rule rule = new Rule();
					if(s.startsWith("branch")) {
						Matcher m = Pattern.compile("^\\w+\\s+[\"'](.*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$CI_COMMIT_BRANCH == \"").append(m.group(1)).append("\"");;
					}else if(s.startsWith("environment")) {
						Matcher m = Pattern.compile("environment name:\\s*[\"'](\\w*)[\"'], value:\\s*[\"'](\\w*)[\"']",Pattern.MULTILINE).matcher(s);
						m.find();
						condition.append("$").append(m.group(1)).append(" == ").append(m.group(2));;
					}else {
						log.info("Discarded content: "+ s);
						return;
					}
					rule.set_if(condition.toString());
					rule.setWhen(RunConditions.never);
					job.getRules().add(rule);
				});
				
				break;
			}
			default: log.info("Discarded content: "+ node);
			}
		});
	}

	private void processOptionsNode(Job job, Node optionsNode) {
		optionsNode.getContent().forEach(s -> {
			if(s.startsWith("timeout")) {
				Matcher m = Pattern.compile("timeout\\s*\\(\\s*time:\\s*(\\d+)\\s*,\\s*unit:\\s*'(\\w+)'\\s*\\)").matcher(s);
				m.find();				
				//job.setTimeout(m.group(1)+" "+m.group(2).toLowerCase());
				job.setTimeout("1 hours");
			}else if(s.startsWith("retry")) {
				Matcher m = Pattern.compile("retry\\s*\\(\\s*\\d+\\s*\\)").matcher(s);
				m.find();
				Retry retry = new Retry();
				retry.setMaxRetries(m.group(1));
				job.setRetry(retry);
			}else {
				log.info("Discarded content: "+ s);
			}
			//TODO attempt to handle other content at this level
		});
	}

	private List<Job> processParallelNode(Optional<String> stage, Node parallelNode) {
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
		Map<String, String> env = new LinkedHashMap<String, String>();
		environmentNode.getContent().forEach(s -> {
			String[] parts = s.split("\\s*=\\s*");
			if(parts[1].startsWith("\"")||parts[1].startsWith("'")) {
				Matcher m = Pattern.compile("[\"'](.*?)[\"']").matcher(s);
				m.find();

				parts[1] = m.group(1);
			}
			env.put(parts[0], parts[1]);
		});
		return env;
	}

	private void processAgentNode(Job job, Node agentNode) {
		agentNode.getContent().forEach(s -> {
			String[] parts = getContentParts(s);
			switch(parts[0]) {
			case "label": {
				List<String> tags = Optional.ofNullable(job.getTags()).orElseGet(ArrayList::new);
				String label = parts[1].replaceAll("'", "");
				tags.add(label);
				job.setTags(tags);
				break;
			}
			case "image":
			case "docker":  {
				DockerImage jobImage = Optional.ofNullable(job.getImage()).orElseGet(DockerImage::new);
				String label = parts[1].replaceAll("'", "");
				jobImage.setName(label);
				job.setImage(jobImage);
				break;
			}
			default: log.info("Discarded content: "+s);
			}
		});
		agentNode.getChildren().forEach(node ->{
			switch(node.getType()) {
			case "node": processAgentNode(job, node);break;
			case "docker": processAgentNode(job, node);break;
			default: log.info("Discarded content: "+ node);
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
