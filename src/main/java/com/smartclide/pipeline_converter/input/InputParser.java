package com.smartclide.pipeline_converter.input;

import java.io.File;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.smartclide.pipeline_converter.input.gitlab.model.Pipeline;

public class InputParser {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory().enable(YAMLGenerator.Feature.MINIMIZE_QUOTES));
        try {
            Pipeline cfg = mapper.readValue(new File("target/classes/test.yaml"), Pipeline.class);
            System.out.println(ReflectionToStringBuilder.toString(cfg,ToStringStyle.MULTI_LINE_STYLE));
//            cfg.getJobs().values().forEach(v -> {System.out.println(v.getClass());});
            mapper.setSerializationInclusion(Include.NON_NULL);
            mapper.setSerializationInclusion(Include.NON_EMPTY);

            System.out.println(mapper.writeValueAsString(cfg));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}