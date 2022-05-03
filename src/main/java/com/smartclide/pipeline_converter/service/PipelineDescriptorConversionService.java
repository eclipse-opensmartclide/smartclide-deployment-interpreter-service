package com.smartclide.pipeline_converter.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;
import com.smartclide.pipeline_converter.input.jenkins.JenkinsfileReader;
import com.smartclide.pipeline_converter.output.GitlabCIOutputConverter;

@Service
public class PipelineDescriptorConversionService {

	@Autowired
	JenkinsfileReader reader;
	@Autowired
	GitlabCIOutputConverter converter;
	
	public Resource convert(InputStream inputStream) throws JsonProcessingException {
		Pipeline gitlabPipeline = converter.convert(reader.read(inputStream));
		
		
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory()
        		.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
        		.enable(YAMLGenerator.Feature.INDENT_ARRAYS_WITH_INDICATOR)
        		);
        mapper.disable(JsonWriteFeature.QUOTE_FIELD_NAMES.mappedFeature());
        mapper.setSerializationInclusion(Include.NON_NULL)
        	.setSerializationInclusion(Include.NON_EMPTY)
        	.setSerializationInclusion(Include.NON_DEFAULT)
        	;

        String converted = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gitlabPipeline);
        
        return new ByteArrayResource(converted.getBytes());
	}

}
