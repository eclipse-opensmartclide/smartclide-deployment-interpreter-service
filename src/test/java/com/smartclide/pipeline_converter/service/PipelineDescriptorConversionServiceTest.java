package com.smartclide.pipeline_converter.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;

import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.JenkinsfileReader;
import com.smartclide.pipeline_converter.input.jenkins.Node;
import com.smartclide.pipeline_converter.output.GitlabCIOutputConverter;
import com.smartclide.pipeline_converter.output.JenkinsCIOutputConverter;
import com.smartclide.pipeline_converter.util.MockGitLab;
import com.smartclide.pipeline_converter.util.MockJenkins;

@ExtendWith(MockitoExtension.class)
public class PipelineDescriptorConversionServiceTest {
	
	@Mock
	private JenkinsfileReader reader;
	
	@Mock
	private GitlabCIOutputConverter converterGitLab;
	
	@Mock
	private JenkinsCIOutputConverter converterJenkins;
	
	private PipelineDescriptorConversionService service;
	
	public static final int DEFAULT_BUFFER_SIZE = 8192;
	
	@BeforeEach
	public void setUp() throws Exception {		
		this.service = new PipelineDescriptorConversionService(reader, converterGitLab, converterJenkins);			
	}
	
	@Test
	public void convertFileToGitLabTest_Ok() throws Exception{	
		File file = ResourceUtils.getFile("classpath:jenkinsfile_1");
		String content = Files.readString(Paths.get(file.getPath()));
				
		MockMultipartFile jenkinsFile = new MockMultipartFile("test", "jenkinsfile_1", 
												MediaType.MULTIPART_FORM_DATA_VALUE, content.getBytes());
		
		Node node = MockJenkins.createNode();				
		Pipeline pipeline = MockGitLab.createPipelineGitLab();
		
		when(reader.read(any(InputStream.class))).thenReturn(node);
		when(converterGitLab.convert(node)).thenReturn(pipeline);	
		
		Resource actual = service.convertFileToGitLab(jenkinsFile);		
		assertNotNull(actual);
		
		verify(reader).read(any(InputStream.class));		
		verify(converterGitLab).convert(node);
		verifyNoMoreInteractions(reader);
		verifyNoMoreInteractions(converterJenkins);
		
	}
	
	@Test
	public void convertFileToGitLabTest_Error() throws Exception{	
		File file = ResourceUtils.getFile("classpath:jenkinsfile_1");
		String content = Files.readString(Paths.get(file.getPath()));
				
		MockMultipartFile jenkinsFile = new MockMultipartFile("test", "jenkinsfile_1", 
												MediaType.MULTIPART_FORM_DATA_VALUE, content.getBytes());
		
		when(reader.read(any(InputStream.class))).thenReturn(null);
		Resource actual = null;
		try {
			actual = service.convertFileToGitLab(jenkinsFile);
		} catch (Exception e) {
			// ignore
		}		
		assertNull(actual);
		
		verify(reader).read(any(InputStream.class));				
		verifyNoMoreInteractions(reader);				
	}
	
	@Test
	public void convertFileToJenkinsTest_Ok() throws Exception{	
		File file = ResourceUtils.getFile("classpath:test.yaml");
		String content = Files.readString(Paths.get(file.getPath()));
				
		MockMultipartFile jenkinsFile = new MockMultipartFile("test", "test.yaml", 
												MediaType.MULTIPART_FORM_DATA_VALUE, content.getBytes());
			    
	    com.smartclide.pipeline_converter.input.jenkins.model.Pipeline jenkins = MockJenkins.createJenkinsMock();
	    	    
	    when(converterJenkins.convert(any())).thenReturn(jenkins);	    
	    Resource actual = service.convertFileToJenkins(jenkinsFile);	   	    	    
	    assertNotNull(actual);
	    
	    verify(converterJenkins).convert(any());		
		verifyNoMoreInteractions(converterJenkins);
	}
	
	@Test
	public void convertFileToJenkinsTest_Error() throws Exception{	
		File file = ResourceUtils.getFile("classpath:test.yaml");
		String content = Files.readString(Paths.get(file.getPath()));
				
		MockMultipartFile jenkinsFile = new MockMultipartFile("test", "test.yaml", 
												MediaType.MULTIPART_FORM_DATA_VALUE, content.getBytes());
			    	    	    	   
	    when(converterJenkins.convert(any())).thenReturn(null);	    
	    Resource actual = null;
		try {
			actual = service.convertFileToJenkins(jenkinsFile);
		} catch (Exception e) {
			// ignore
			
		}	   	    	    
	    assertNull(actual);
	    
	    verify(converterJenkins).convert(any());		
		verifyNoMoreInteractions(converterJenkins);
	}			
}
