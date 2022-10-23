package com.smartclide.pipeline_converter.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.Node;
import com.smartclide.pipeline_converter.util.MockJenkins;

@ExtendWith(MockitoExtension.class)
public class GitlabCIOutputConverterTest {
	
	@InjectMocks
	GitlabCIOutputConverter gitlabCIOutputConverter;
	
	@Test
	public void convertTest() {
		
		Node nodeJenkins = MockJenkins.createNode();	
		Pipeline gitLab = gitlabCIOutputConverter.convert(nodeJenkins);
		
		assertNotNull(gitLab);
		assertEquals("readMavenPom().getVersion(),", gitLab.getVariables().get("POM_VERSION"));
		assertEquals("readMavenPom().getVersion().replace(\"-SNAPSHOT\", \"\"),", gitLab.getVariables().get("BUILD_RELEASE_VERSION"));
		assertEquals("readMavenPom().getVersion().endsWith(\"-SNAPSHOT\"), ", gitLab.getVariables().get("IS_SNAPSHOT"));
		assertEquals("sh(script: 'git describe --tags --always', returnStdout: true).trim()", gitLab.getVariables().get("GIT_TAG_COMMIT"));
		
		Set<String> stagesExpected = getStagesExpected();		  
		assertEquals(stagesExpected, gitLab.getStages());
		
		assertEquals("stage_one", gitLab.getJobs().get("stage_one").getName());
		assertEquals("stage_one", gitLab.getJobs().get("stage_one").getStage());
		assertEquals("tags_extra = \"value_1\"", gitLab.getJobs().get("stage_one").getScript().get(0));
		assertEquals("echo \"tags_extra: ${tags_extra}\"", gitLab.getJobs().get("stage_one").getScript().get(1));
		
		assertEquals("stage_two", gitLab.getJobs().get("stage_two").getName());
		assertEquals("stage_two", gitLab.getJobs().get("stage_two").getStage());
		assertEquals("echo \"tags_extra: ${tags_extra}\"", gitLab.getJobs().get("stage_two").getScript().get(0));		
		
		assertEquals("stage_three", gitLab.getJobs().get("stage_three").getName());
		assertEquals("stage_three", gitLab.getJobs().get("stage_three").getStage());
		assertEquals("echo \"tags_extra: ${tags_extra}\"", gitLab.getJobs().get("stage_three").getScript().get(0));
		assertEquals("tags_extra != 'bla'", gitLab.getJobs().get("stage_three").getRules().get(0).get_if());		
		
	}
	
	private Set<String> getStagesExpected(){
		Set<String> stages = new HashSet<>();
		stages.add("stage_one");
		stages.add("stage_two");
		stages.add("stage_three");
		return stages;
	}		

}
