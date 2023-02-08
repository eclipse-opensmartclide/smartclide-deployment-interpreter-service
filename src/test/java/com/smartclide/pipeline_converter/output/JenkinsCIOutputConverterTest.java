package com.smartclide.pipeline_converter.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.model.Agent.AgentType;
import com.smartclide.pipeline_converter.util.MockGitLab;

@ExtendWith(MockitoExtension.class)
public class JenkinsCIOutputConverterTest {
	
	@InjectMocks
	JenkinsCIOutputConverter jenkinsCIOutputConverter;

	@Test
	public void convertTest() throws Exception {
		Pipeline pipeline = MockGitLab.createPipelineGitLab();
		
		com.smartclide.pipeline_converter.input.jenkins.model.Pipeline jenkins = jenkinsCIOutputConverter.convert(pipeline);		
				
		assertNotNull(jenkins);
		assertEquals(AgentType.any, jenkins.getAgent().getAgentType());
		
		//stage test
		assertEquals("test", jenkins.getStages().get(0).getName());
		assertEquals(AgentType.other, jenkins.getStages().get(0).getAgent().getAgentType());
		assertEquals("postgres:alpine", jenkins.getStages().get(0).getAgent().getDocker().getImage());
		assertEquals("custom_db", jenkins.getStages().get(0).getEnvironment().get("POSTGRES_DB"));
		assertEquals("custom_user", jenkins.getStages().get(0).getEnvironment().get("POSTGRES_USER"));
		assertEquals("custom_pass", jenkins.getStages().get(0).getEnvironment().get("POSTGRES_PASSWORD"));
		assertEquals("export DATABASE_URL=postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@postgres:5432/$POSTGRES_DB", 
				jenkins.getStages().get(0).getSteps().get(0));
		assertEquals("apt-get update -qy\", \"apt-get install -y python-dev python-pip", 
				jenkins.getStages().get(0).getSteps().get(1));
		assertEquals("pip install -r requirements.txt\", \"python manage.py test", 
				jenkins.getStages().get(0).getSteps().get(2));
		
		//stage deploy is parallel(contains stages staging and production)
		assertEquals("deploy", jenkins.getStages().get(1).getName());		
		assertNotNull(jenkins.getStages().get(1).getParallel());
		
		//stage staging
		assertEquals("staging", jenkins.getStages().get(1).getParallel().get(0).getName());
		
		assertEquals("apt-get update -qy", 
				jenkins.getStages().get(1).getParallel().get(0).getSteps().get(0));
		assertEquals("apt-get install -y ruby-dev", 
				jenkins.getStages().get(1).getParallel().get(0).getSteps().get(1));
		assertEquals("gem install dpl", 
				jenkins.getStages().get(1).getParallel().get(0).getSteps().get(2));
		assertEquals("dpl --provider=heroku --app=$HEROKU_STAGING_APP --api-key=$HEROKU_STAGING_API_KEY --skip-cleanup", 
				jenkins.getStages().get(1).getParallel().get(0).getSteps().get(3));
		
		//stage production
		assertEquals("production", jenkins.getStages().get(1).getParallel().get(1).getName());
		
		assertEquals("apt-get update -qy", 
				jenkins.getStages().get(1).getParallel().get(1).getSteps().get(0));
		assertEquals("apt-get install -y ruby-dev", 
				jenkins.getStages().get(1).getParallel().get(1).getSteps().get(1));
		assertEquals("gem install dpl", 
				jenkins.getStages().get(1).getParallel().get(1).getSteps().get(2));
		assertEquals("dpl --provider=heroku --app=$HEROKU_PRODUCTION_APP --api-key=$HEROKU_PRODUCTION_API_KEY --skip-cleanup", 
				jenkins.getStages().get(1).getParallel().get(1).getSteps().get(3));
	}
}
