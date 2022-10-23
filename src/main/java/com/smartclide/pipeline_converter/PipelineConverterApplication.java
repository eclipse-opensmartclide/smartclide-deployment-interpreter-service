package com.smartclide.pipeline_converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.smartclide.pipeline_converter")
@ComponentScan({"com.smartclide.pipeline_converter", "com.smartclide", "com.smartclide.pipeline_converter.config"})
public class PipelineConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PipelineConverterApplication.class);
	}

}
