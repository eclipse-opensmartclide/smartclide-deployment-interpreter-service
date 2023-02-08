package com.smartclide.pipeline_converter.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.smartclide.pipeline_converter.input.gitlab.model.DockerImage;
import com.smartclide.pipeline_converter.input.gitlab.model.Filter;
import com.smartclide.pipeline_converter.input.gitlab.model.Job;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;

public class MockGitLab {
	
	public static Pipeline createPipelineGitLab() {
		Pipeline pipeline = new Pipeline();		
		pipeline.setStages(createStages());
		pipeline.addJob("test", createJobTest());
		pipeline.addJob("staging", createJobStaging());	
		pipeline.addJob("production", createJobProduction());	
		return pipeline;
	}
	
	private static List<String> createStages(){
		List<String> stages = new ArrayList<>();
		stages.add("test");		
		stages.add("deploy");		
		return stages;
	}		
	
	private static Job createJobTest() {
		Job job = new Job();
		job.setName("test");
		job.setStage("test");
		job.setServices(crearteDockerImagesTest());
		job.setVariables(createVariablesJobTest());
		job.setScript(createScriptJobTest());
		return job;
	}
	
	private static List<DockerImage> crearteDockerImagesTest(){
		List<DockerImage> dockerImages = new ArrayList<>();		
		DockerImage dockerImage = new DockerImage();		
		dockerImage.setName("postgres:alpine");
		dockerImages.add(dockerImage);		
		return dockerImages;
	}
	
	private static Map<String, String> createVariablesJobTest() {
		Map<String, String> variables = new LinkedHashMap<>();
		variables.put("POSTGRES_DB", "custom_db");
		variables.put("POSTGRES_USER", "custom_user");
		variables.put("POSTGRES_PASSWORD", "custom_pass");		
		return variables;
	}
	
	private static List<String> createScriptJobTest(){
		List<String> script = new ArrayList<>();
		script.add("export DATABASE_URL=postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@postgres:5432/$POSTGRES_DB");		
		script.add("apt-get update -qy\", \"apt-get install -y python-dev python-pip");
		script.add("pip install -r requirements.txt\", \"python manage.py test");
		return script;
	}
		
	private static Job createJobStaging() {
		Job job = new Job();
		job.setName("staging");
		job.setStage("deploy");				
		job.setScript(createScriptStaging());
		job.setOnly(createFilterStaging());
		return job;
	}
	
	private static Filter createFilterStaging() {
		Filter filter = new Filter();
		filter.setRefs(List.of("master"));
		return filter;
	}
	private static List<String> createScriptStaging(){
		List<String> script = new ArrayList<>();
		script.add("apt-get update -qy");		
		script.add("apt-get install -y ruby-dev");
		script.add("gem install dpl");
		script.add("dpl --provider=heroku --app=$HEROKU_STAGING_APP --api-key=$HEROKU_STAGING_API_KEY --skip-cleanup");
		return script;
	}
	
	private static Job createJobProduction() {
		Job job = new Job();
		job.setName("production");
		job.setStage("deploy");				
		job.setScript(createScriptProduction());
		job.setOnly(createFilterProduction());
		return job;
	}
	
	public static Filter createFilterProduction() {		
		List<String> variables = new ArrayList<>();
		variables.add("$RELEASE == \"staging\"");		
		variables.add("$STAGING");				
		Filter filter = new Filter();
		filter.setVariables(variables);;
		return filter;
	}
	private static List<String> createScriptProduction(){
		List<String> script = new ArrayList<>();
		script.add("apt-get update -qy");		
		script.add("apt-get install -y ruby-dev");
		script.add("gem install dpl");
		script.add("dpl --provider=heroku --app=$HEROKU_PRODUCTION_APP --api-key=$HEROKU_PRODUCTION_API_KEY --skip-cleanup");
		return script;
	}
	
}
