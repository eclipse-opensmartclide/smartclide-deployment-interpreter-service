package com.smartclide.pipeline_converter.input;

import java.io.File;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;

public class InputParser {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().enable(YAMLGenerator.Feature.MINIMIZE_QUOTES));
        ObjectMapper mapper2 = new ObjectMapper();
        mapper2.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            Pipeline cfg = mapper.readValue(new File("target/classes/test.yaml"), Pipeline.class);
            System.out.println(mapper2.writeValueAsString(cfg));
//            cfg.getJobs().values().forEach(v -> {System.out.println(v.getClass());});
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.setSerializationInclusion(Include.NON_EMPTY);

            System.out.println(mapper.writeValueAsString(cfg));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static com.smartclide.pipeline_converter.input.jenkins.model.Pipeline convert(Pipeline gitlabPipeline){
    	var jenkinsPipeline = new com.smartclide.pipeline_converter.input.jenkins.model.Pipeline();
    	
    	return jenkinsPipeline;
    }
}