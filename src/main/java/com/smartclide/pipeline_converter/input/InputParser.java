package com.smartclide.pipeline_converter.input;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.smartclide.pipeline_converter.input.gitlab.model.DockerImage;
import com.smartclide.pipeline_converter.input.gitlab.model.Job;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.model.Agent;
import com.smartclide.pipeline_converter.input.jenkins.model.Docker;
import com.smartclide.pipeline_converter.input.jenkins.model.Environment;
import com.smartclide.pipeline_converter.input.jenkins.model.Options;
import com.smartclide.pipeline_converter.input.jenkins.model.Post;
import com.smartclide.pipeline_converter.input.jenkins.model.Retry;
import com.smartclide.pipeline_converter.input.jenkins.model.Stage;
import com.smartclide.pipeline_converter.input.jenkins.model.Step;
import com.smartclide.pipeline_converter.input.jenkins.model.Success;
import com.smartclide.pipeline_converter.input.jenkins.model.When;

public class InputParser {
	public static final String SUCCESS = "success";

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory().enable(YAMLGenerator.Feature.MINIMIZE_QUOTES));
		ObjectMapper mapper2 = new ObjectMapper();
		mapper2.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			Pipeline cfg = mapper.readValue(new File("target/classes/test3.yaml"), Pipeline.class);
			System.out.println(mapper2.writeValueAsString(cfg));
//            cfg.getJobs().values().forEach(v -> {System.out.println(v.getClass());});
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.setSerializationInclusion(Include.NON_EMPTY);

//			System.out.println(mapper.writeValueAsString(cfg));

			System.out.println("################################################################################");
			System.out.println(mapper2.writeValueAsString(convert(cfg)));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static com.smartclide.pipeline_converter.input.jenkins.model.Pipeline convert(Pipeline gitlabPipeline)
			throws JsonProcessingException {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.setSerializationInclusion(Include.NON_EMPTY);
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		var jenkinsPipeline = new com.smartclide.pipeline_converter.input.jenkins.model.Pipeline();
		if (gitlabPipeline != null && (gitlabPipeline.getJobs() != null && !gitlabPipeline.getJobs().isEmpty())) {
			jenkinsPipeline.setAgent(parseAgent(gitlabPipeline));
			jenkinsPipeline.setEnvironment(gitlabPipeline.getVariables());
			jenkinsPipeline.setStages(parseStages(gitlabPipeline));
			// jenkinsPipeline.setPost(parsePost(gitlabPipeline.getAfterScript()));
			jenkinsPipeline.setOptions(parseOptions(gitlabPipeline));
		}

		return jenkinsPipeline;
	}

	public static List<Stage> parseStages(Pipeline pipeline) {
		final var groupedStages = new LinkedHashMap<String, List<Stage>>();
		List<Stage> stages = new ArrayList<>();
		pipeline.getJobs().values().forEach(job -> {
			final Stage stage = parseStage(job);
			groupedStages.merge(job.getStage(), List.of(stage), (current, newVal) -> {current.addAll(newVal); return current;});
		});
		
		groupedStages.forEach((stage,substages) -> {
			if(substages.size() > 1) {
				Stage parent = Stage.builder().name(stage).parallel(substages).build();
				stages.add(parent);
			} else {
				stages.addAll(substages);
			}
		});
		
		return stages;
	}

	/*
	 * public static List<Stage> parseStagesSecuencial(Pipeline pipeline) { final
	 * List<Stage> stages = new ArrayList<>(); List<Job> jobsValues = new
	 * ArrayList<Job>(pipeline.getJobs().values()); Map<String, List<Job>> agr =
	 * jobsValues.stream().collect(Collectors.groupingBy(Job::getStage));
	 * agr.forEach((key, jobs) -> { //final Stage stage = parseStage(key, jobs);
	 * //stages.add(stage); }); //List<Map.Entry<String, Job>> singleList =
	 * pipeline.getJobs().entrySet() // .stream() // .collect(Collectors.toList());
	 * return stages; }
	 */

	public static Stage parseStage(Job job) {
		return Stage.builder()
				.name(job.getName())
				.agent(parseAgentJob(job))
				.environment(job.getVariables())
				.when(parseWhen(job))
				.steps(parseSteps(job))
				.post(parsePostJob(job))
				.build();
	}

	public static List<String> parseSteps(Job job) {
		final List<String> steps = new ArrayList<>();
		steps.addAll(job.getBeforeScript());
		steps.addAll(job.getScript());
		return steps;
	}

	public static Agent parseAgent(Pipeline pipeline) {
		var agentBuilder = Agent.builder();
		
		if (pipeline.getImage() != null) {
			final Docker docker = parseDocker(pipeline.getImage());
			agentBuilder.docker(docker);
		}
		return agentBuilder.build();
	}

	public static Agent parseServiceJob(Job job) {
		if (job.getServices() != null && !job.getServices().isEmpty()) {
			final Docker docker = parseDocker(job.getServices().get(0));
			return Agent.builder().docker(docker).build();
		}
		return null;
	}

	public static Agent parseAgentJob(Job job) {
		Agent agent = new Agent();
		Docker docker = null;
		if (job.getImage() != null) {
			docker = parseDocker(job.getImage());
		} else if (job.getServices() != null && !job.getServices().isEmpty()) {
			docker = parseDocker(job.getServices().get(0));
		} else {
			return null;
		}
		agent.setDocker(docker);
		return agent;
	}

	public static Docker parseDocker(DockerImage image) {
		return Docker.builder().image(image.getName()).args(image.getEntryPoint()).build();
	}

	public static Post parsePostJob(Job job) {
		if(job.getAfterScript() != null && !job.getAfterScript().isEmpty()) {
			Post post = new Post();
			post.setScript(job.getAfterScript());
			return post;
		}
		
		return null;
	}

//	public static Success parseSuccess(Job job) {
//		if (job.getName() != null && job.getName().contains(SUCCESS)) {
//			return Success.builder().scripts(job.getScript()).build();
//		}
//		return null;
//	}
//
//	public static Environment parseEnvironmentJob(Job job) {
//		if (job.getVariables() != null && !job.getVariables().isEmpty()) {
//			return Environment.builder().variables(job.getVariables()).build();
//		}
//		return null;
//	}
//
//	public static Environment parseEnvironment(Pipeline pipeline) {
//		if (pipeline.getVariables() != null && !pipeline.getVariables().isEmpty()) {
//			return Environment.builder().variables(pipeline.getVariables()).build();
//		}
//		return null;
//	}

	public static Options parseOptions(Pipeline pipeline) {
		if (pipeline.get_default() != null) {
			final Retry retry = parseRetry(pipeline.get_default());
			final String timeout = pipeline.get_default().getTimeout();
			if (retry == null && timeout == null) {
				return null;
			}
			return Options.builder().timeout(timeout).retry(retry).build();
		}
		return null;
	}

	public static Retry parseRetry(Job job) {
		if (job.getRetry() != null) {
			return Retry.builder().maxRetries(job.getRetry().getMaxRetries())
					// .when(parseWhen(job.getRetry().getWhen()))
					.build();
		}
		return null;
	}

	public static When parseWhen(Job job) {
		if (job.getOnly() != null) {
			return When.builder().branch(job.getOnly().getRefs()).environmentName(job.getOnly().getVariables()).build();
		}
		return null;
	}

}
