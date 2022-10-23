package com.smartclide.pipeline_converter.controller;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import com.smartclide.pipeline_converter.service.PipelineDescriptorConversionService;
import com.smartclide.pipeline_converter.util.FilesUtil;

@ExtendWith(MockitoExtension.class)
public class PipelineConverterControllerTest {
	  
	private MockMvc mvc;
	
	private PipelineConverterController controller;
		
	@Mock
	private PipelineDescriptorConversionService service;
	
	@InjectMocks
	private PipelineDescriptorConversionService service1;
	
	private static final String PATH_FOLDER = "/tmp/files/";
	private static final String FILE_NAME_GITLAB = "test.yaml";
	private static final String FILE_NAME_JENKINS = "jenkinsfile_1";
	
	
	@BeforeEach
	public void setUp() throws Exception {
		this.controller = new PipelineConverterController(service);
		mvc = MockMvcBuilders.standaloneSetup(controller).setCustomArgumentResolvers().build();
	}
	
	@BeforeAll
	public static void setUpClass() throws Exception {
		FilesUtil.createTempRepository(PATH_FOLDER, FILE_NAME_GITLAB);
		FilesUtil.createTempRepository(PATH_FOLDER, FILE_NAME_JENKINS);
	}
	
	@AfterAll
	public static void tearDown() throws IOException {
	    FilesUtil.deleteTempRepositoryFileSystem();
	}
	
	@Test
	public void parseFileToGitLabTest_Ok() throws Exception {
		Resource resource = new UrlResource("file:///tmp/files/jenkinsfile_1");
	    assertNotNull(resource);		
	    
	    byte[] fileContent = "content-jenkins".getBytes(StandardCharsets.UTF_8);
	    MockPart filePart = new MockPart("file", "orig", fileContent);	    
	    assertNotNull(filePart);
	    
	    when(service.convertFileToGitLab(any())).thenReturn(resource);
	    
	    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
	    		.multipart("/api/v1/pipeline/gitlab")
	    		.part(filePart);
	    	    	   
	    mvc.perform(builder).andExpect(status().isOk());
	    
	    verify(service, times(1)).convertFileToGitLab(any());
	    verifyNoMoreInteractions(service);
	}
		
	
	@Test
	public void parseFileToGitLab_BAD_REQUEST() throws Exception {			    
	    byte[] fileContent = "content-jenkins".getBytes(StandardCharsets.UTF_8);
	    MockPart filePart = new MockPart("file", "orig", fileContent);	    
	    assertNotNull(filePart);
	    
	    when(service.convertFileToGitLab(any())).thenThrow(NullPointerException.class);
	    
	    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
	    		.multipart("/api/v1/pipeline/gitlab")
	    		.part(filePart);
	    	    	   
	    mvc.perform(builder).andExpect(status().isBadRequest());
	    
	    verify(service, times(1)).convertFileToGitLab(any());
	    verifyNoMoreInteractions(service);
	}
	
	@Test
	public void parseFileToJenkinsTest_Ok() throws Exception {	
		Resource resource = new UrlResource("file:///tmp/files/test.yaml");
	    assertNotNull(resource);
	    
	    byte[] fileContent = "content-gitlab".getBytes(StandardCharsets.UTF_8);
	    MockPart filePart = new MockPart("file", "orig", fileContent);	    
	    assertNotNull(filePart);
	    
	    when(service.convertFileToJenkins(any())).thenReturn(resource);
	    
	    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
	    		.multipart("/api/v1/pipeline/jenkins")
	    		.part(filePart);
	    	    	   
	    mvc.perform(builder).andExpect(status().isOk());
	    
	    verify(service, times(1)).convertFileToJenkins(any());
	    verifyNoMoreInteractions(service);
	}
	
	@Test
	public void parseFileToJenkins_BAD_REQUEST() throws Exception {			    		
	    byte[] fileContent = "content-gitlab".getBytes(StandardCharsets.UTF_8);
	    MockPart filePart = new MockPart("file", "orig", fileContent);	    
	    assertNotNull(filePart);
	    
	    when(service.convertFileToJenkins(any())).thenThrow(NullPointerException.class);
	    
	    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
	    		.multipart("/api/v1/pipeline/jenkins")
	    		.part(filePart);
	    	    	   
	    mvc.perform(builder).andExpect(status().isBadRequest());
	    
	    verify(service, times(1)).convertFileToJenkins(any());
	    verifyNoMoreInteractions(service);
	}
}
