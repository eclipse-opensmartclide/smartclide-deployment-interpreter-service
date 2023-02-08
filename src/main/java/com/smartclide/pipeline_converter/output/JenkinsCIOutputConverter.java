package com.smartclide.pipeline_converter.output;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smartclide.pipeline_converter.input.gitlab.model.*;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.common.Util;
import com.smartclide.pipeline_converter.input.jenkins.model.*;
import com.smartclide.pipeline_converter.input.jenkins.model.Retry;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JenkinsCIOutputConverter {
	
	public com.smartclide.pipeline_converter.input.jenkins.model.Pipeline convert(Pipeline gitlabPipeline)
			throws JsonProcessingException {
		var jenkinsPipeline = new com.smartclide.pipeline_converter.input.jenkins.model.Pipeline();
		if (gitlabPipeline != null && (gitlabPipeline.getJobs() != null && !gitlabPipeline.getJobs().isEmpty())) {
			jenkinsPipeline.setAgent(parseAgent(gitlabPipeline));
			jenkinsPipeline.setEnvironment(gitlabPipeline.getVariables());
			jenkinsPipeline.setOptions(parseOptions(gitlabPipeline));
			jenkinsPipeline.setStages(parseStages(gitlabPipeline));
			jenkinsPipeline.setPost(parsePost(gitlabPipeline));
		}
		return jenkinsPipeline;
	}

	private List<Stage> parseStages(Pipeline pipeline) {
		var groupedStages = new LinkedHashMap<String, List<Stage>>();
		List<Stage> stages = new ArrayList<>();
		groupedByStage(pipeline, groupedStages);
		buildStages(groupedStages, stages);
		return stages;
	}

	private void buildStages(LinkedHashMap<String, List<Stage>> groupedStages, List<Stage> stages) {
		groupedStages.forEach((stage, substages) -> {
			if(substages.size() > 1) {
				Stage parent = Stage.builder().name(stage).parallel(substages).build();
				stages.add(parent);
			} else {
				stages.addAll(substages);
			}
		});
	}

	private void groupedByStage(Pipeline pipeline, LinkedHashMap<String, List<Stage>> groupedStages) {
		pipeline.getJobs().forEach((key, job) -> {
			Stage stage = parseStage(key, job);
			groupedStages.merge(job.getStage(), Arrays.asList(stage), (current, newVal) -> {
				return Stream.of(current, newVal)
						.flatMap(x -> x.stream())
						.collect(Collectors.toList());
			});
		});
	}

	private Stage parseStage(String key, Job job) {
		return Stage.builder()
				.name(key)
				.agent(parseAgentJob(job))
				.environment(job.getVariables())
				.steps(parseSteps(job))
				.when(parseWhen(job))
				.post(parsePostJob(job))
				.build();
	}

	private List<String> parseSteps(Job job) {
		final List<String> steps = new ArrayList<>();
		steps.addAll(job.getBeforeScript());
		steps.addAll(job.getScript());
		return steps;
	}

	private Agent parseAgent(Pipeline pipeline) {
		Agent agent = new Agent();
		if (pipeline.getImage() != null) {
			final Docker docker = parseDocker(pipeline.getImage());
			agent.setDocker(docker);
		}
		return agent;
	}

	private Agent parseAgentJob(Job job) {
		Agent agent = new Agent();
		if (job.getImage() != null) {
			Docker docker = parseDocker(job.getImage());
			agent.setDocker(docker);
			agent.setAgentType(Agent.AgentType.other);
		}
		//TODO: pendiente evaluar cuando es una lista de docker images
		if(job.getServices() != null && !job.getServices().isEmpty()) {
			List<Docker> service = parseServices(job.getServices());
			agent.setDocker(service.get(0));
			agent.setAgentType(Agent.AgentType.other);
		}
		if ((job.getServices() == null || job.getServices().isEmpty()) && job.getImage()== null
				&& job.getTags() != null && !job.getTags().isEmpty()) {
			agent.setLabel(job.getTags());
			agent.setAgentType(Agent.AgentType.other);
		}
		if(agent.getDocker()== null && job.getServices() == null && agent.getAgentType()==null
				&& (agent.getLabel() == null || agent.getLabel().isEmpty())) {
			return null;
		}
		return agent;
	}

	private Docker parseDocker(DockerImage image) {
		return Docker.builder()
				.image(image.getName())
				.args(image.getEntryPoint())
				.build();
	}

	private List<Docker> parseServices(List<DockerImage> images) {
		List<Docker> dockerImages = new ArrayList<>();
		images.forEach(docImages -> {
			Docker docker = new Docker();
			docker.setImage(docImages.getName());
			docker.setArgs(docImages.getEntryPoint());
			dockerImages.add(docker);
		});
		return dockerImages;
	}

	private Post parsePostJob(Job job) {
		List<String> concatenated = new ArrayList<>();
		Post post = new Post();
		buildContentPost(job, concatenated, post);
		if((post.getAlways()==null || post.getAlways().isEmpty()) && (
				post.getSuccess()==null || post.getSuccess().isEmpty())) {
			return null;
		}
		return post;
	}

	private void buildContentPost(Job job, List<String> concatenated, Post post) {
		if(job.getAfterScript() != null && !job.getAfterScript().isEmpty()) {
			concatenated.addAll(job.getAfterScript());
		}
		if(job.getArtifacts() != null && job.getArtifacts().getPaths() != null
				&& !job.getArtifacts().getPaths().isEmpty()) {
			List<String> artifacts = new ArrayList<>();
			String artifact = Util.ARTIFACT.concat(job.getArtifacts().getPaths().get(0));
			artifacts.add(artifact);
			concatenated.addAll(artifacts);
		}
		post.setAlways(concatenated);
	}

	private Post parsePost(Pipeline pipeline) {
		Post post = new Post();
		if(pipeline.get_default() != null ){
			List<String> afterScript = pipeline.get_default().getAfterScript();
			if(afterScript!= null && !afterScript.isEmpty()){
				post.setAlways(afterScript);
			}
		}
		if(post.getAlways()==null) {
			return null;
		}
		return post;
	}

	private Options parseOptions(Pipeline pipeline) {
		if (pipeline.get_default() != null) {
			final com.smartclide.pipeline_converter.input.jenkins.model.Retry retry = parseRetry(pipeline.get_default());
			final String timeout = pipeline.get_default().getTimeout();

			if (retry == null && timeout == null) {
				return null;
			}
			return Options.builder()
					.timeout(timeout)
					.retry(retry)
					.build();
		}
		return null;
	}

	private com.smartclide.pipeline_converter.input.jenkins.model.Retry parseRetry(Job job) {
		if (job.getRetry() != null) {
			return Retry.builder()
					.maxRetries(job.getRetry().getMaxRetries())
					.build();
		}
		return null;
	}

	public When parseWhen(Job job) {
		When when = new When();
		buildWhen(job, when);
		if(when.getBranch()==null && when.getEnvironment()== null
				&& when.getExpression()== null && when.getNotAnyOf() == null
				&& when.getAllOf()== null) {
			return null;
		}
		return when;
	}

	private void buildWhen(Job job, When when) {
		if (job.getOnly() != null) {
			when.setBranch(job.getOnly().getRefs());
			when.setEnvironment(job.getOnly().getVariables());
		}
		if(job.getRules() != null && !job.getRules().isEmpty()) {
			List<String> expr = new ArrayList<>();
			List<String> allOf = new ArrayList<>();
			List<String> notAnyOf = new ArrayList<>();
			buildContentWhen(job, expr, allOf, notAnyOf);
			when.setExpression(expr);
			when.setAllOf(allOf);
			when.setNotAnyOf(notAnyOf);
		}
	}

	private void buildContentWhen(Job job, List<String> expr, List<String> allOf, List<String> notAnyOf) {
		job.getRules().forEach(rule -> {
			createExpression(expr, rule);
			createAllOf(allOf, rule);
			createNotAnyOf(notAnyOf, rule);
		});
	}

	private void createExpression(List<String> expr, Rule rule) {
		if(rule.get_if() != null && !rule.get_if().contains("$")){
			expr.add(rule.get_if());
		}
	}

	private void createAllOf(List<String> allOf, Rule rule) {
		if(rule.get_if() != null && rule.get_if().contains("&&")
				&& rule.get_if().contains("$")){

			final String[] allOfs = Arrays.stream(rule.get_if().split("&&"))
					.map(String::trim)
					.toArray(String[]::new);

			final List<String> listAllOf = Stream.of(allOfs)
					.map(alOf -> alOf.substring(alOf.indexOf("$")+1))
					.collect(Collectors.toList());

			listAllOf.forEach(allOfFound -> allOf.add(allOfFound));
		}
	}

	private void createNotAnyOf(List<String> listNotAnyOf, Rule rule) {
		if(rule.get_if() != null && rule.get_if().contains("$") && rule.get_if().contains(Util.BRANCH)){
			if(rule.getWhen() != null && rule.getWhen().equals(RunConditions.never)){
				List<String> listBranch = deleteDollar(rule);
				listBranch.forEach(branch -> listNotAnyOf.add(branch));
			}
		}else if (rule.get_if() != null && rule.get_if().contains("$")){
			if(rule.getWhen() != null && rule.getWhen().equals(RunConditions.never)){
				List<String> listEnv = deleteDollar(rule);
				listEnv.forEach(env -> listNotAnyOf.add(env));
			}
		}
	}

	private List<String> deleteDollar(Rule rule) {
		final List<String> branch = Stream.of(rule.get_if())
				.map(nAniOf -> nAniOf.substring(nAniOf.indexOf("$")+1))
				.collect(Collectors.toList());
		return branch;
	}
}
