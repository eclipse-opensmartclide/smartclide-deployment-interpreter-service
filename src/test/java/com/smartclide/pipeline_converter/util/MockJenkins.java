package com.smartclide.pipeline_converter.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartclide.pipeline_converter.input.jenkins.Node;
import com.smartclide.pipeline_converter.input.jenkins.model.Agent;
import com.smartclide.pipeline_converter.input.jenkins.model.Docker;
import com.smartclide.pipeline_converter.input.jenkins.model.Options;
import com.smartclide.pipeline_converter.input.jenkins.model.Retry;
import com.smartclide.pipeline_converter.input.jenkins.model.Agent.AgentType;

public class MockJenkins {

	public static com.smartclide.pipeline_converter.input.jenkins.model.Pipeline createJenkinsMock(){
		com.smartclide.pipeline_converter.input.jenkins.model.Pipeline jenkins = new com.smartclide.pipeline_converter.input.jenkins.model.Pipeline();
		jenkins.setAgent(getAgent());
		jenkins.setEnvironment(getEnvironment());
		jenkins.setOptions(getOptions());
		jenkins.setPost(null);
		jenkins.setStages(null);
		return jenkins;
	}
	
	private static Agent getAgent() {
		Agent agent = new Agent();
		agent.setAgentType(AgentType.any);
		agent.setDocker(getDocker());
		agent.setLabel(List.of("label"));
		return agent;
	}
	
	private static Docker getDocker() {
		Docker docker = new Docker();
		docker.setArgs(List.of("args"));
		docker.setImage("maven");
		return docker;
	}
	
	private static Map<String, String> getEnvironment() {
		Map<String, String> env = new HashMap<>();
		env.put("POSTGRES_DB", "custom_db");
		env.put("POSTGRES_USER", "custom_user");
		return env;
	}
	
	private static Options getOptions() {
		Options options = new Options();
		options.setRetry(getRetry());
		options.setTimeout("1 hours");
		return options;
	}
	
	private static Retry getRetry() {
		Retry retry = new Retry();
		retry.setMaxRetries("3");
		return retry;
	}
	
	public static Node createNode() {
		Node node = new Node("pipeline", null);
		node.setChildren(createListNode());
		node.setContent(List.of("agent any"));		
		node.setType("pipeline");
		return node;
	}
	
	private static List<Node> createListNode() {
		List<Node> nodes = new ArrayList<>();
		
		// create environmet node
		Node environmentNode = new Node("environment", null);				
		List<String> content = new ArrayList<>();
		content.add("POM_VERSION = readMavenPom().getVersion(),");
		content.add("BUILD_RELEASE_VERSION = readMavenPom().getVersion().replace(\"-SNAPSHOT\", \"\"),");
		content.add("IS_SNAPSHOT = readMavenPom().getVersion().endsWith(\"-SNAPSHOT\"), ");
		content.add("GIT_TAG_COMMIT = sh(script: 'git describe --tags --always', returnStdout: true).trim()");		
		environmentNode.setContent(content);
		
		// create stages node
		Node stagesNode = new Node("stages", null);		
		List<Node> stages = new ArrayList<>();
		
		Node stageOneNode = new Node("stage", null);
		stageOneNode.setName("stage one");
		stageOneNode.setChildren(createListNodeStageOne());
		
		Node stageTwoNode = new Node("stage", null);
		stageTwoNode.setName("stage two");
		stageTwoNode.setChildren(createListNodeStageTwo());
		
		Node stageThreeNode = new Node("stage", null);
		stageThreeNode.setName("stage three");
		stageThreeNode.setChildren(createListNodeStageThree());
		
		stages.add(stageOneNode);
		stages.add(stageTwoNode);
		stages.add(stageThreeNode);
		
		stagesNode.setChildren(stages);
		
		nodes.add(environmentNode);
		nodes.add(stagesNode);
						
		return nodes;
	}
	
	private static List<Node> createListNodeStageOne() {		
		Node stepsNode = new Node("steps", null);
		stepsNode.setContent(List.of("echo \"tags_extra: ${tags_extra}\""));		
		
		Node scriptNode = new Node("script", null);
		scriptNode.setContent(List.of("tags_extra = \"value_1\""));	
		
		stepsNode.setChildren(List.of(scriptNode));
				
		return List.of(stepsNode);
	}
	
	private static List<Node> createListNodeStageTwo() {		
		Node stepsNode = new Node("steps", null);
		stepsNode.setContent(List.of("echo \"tags_extra: ${tags_extra}\""));					
		return List.of(stepsNode);
	}

	private static List<Node> createListNodeStageThree() {
		List<Node> nodes = new ArrayList<>();
		Node whenNode = new Node("when", null);				
		Node expressionNode = new Node("expression", null);
		expressionNode.setContent(List.of("tags_extra != 'bla'"));
		whenNode.setChildren(List.of(expressionNode));
		
		Node stepsNode = new Node("steps", null);
		stepsNode.setContent(List.of("echo \"tags_extra: ${tags_extra}\""));		

		nodes.add(stepsNode);
		nodes.add(whenNode);
		
		return nodes;
	}
			
}
