package com.smartclide.pipeline_converter.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {
	
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("pipeline converter")
                .pathsToMatch("/**")	                
                .build();
    }	  

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(apiInfo());
    }

	 private Info apiInfo() {
        return new Info()
                .title("Pipeline converter API")
                .description("API for converter pipeline gitlab to jenkins and vice versa")
                .version("1.0");
    } 	
}
