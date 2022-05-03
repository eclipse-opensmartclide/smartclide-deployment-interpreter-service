package com.smartclide.pipeline_converter.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.smartclide.pipeline_converter.service.PipelineDescriptorConversionService;

@RestController
public class PipelineConverterController {
//	private static final Logger logger = LoggerFactory.getLogger(PipelineConverterController.class);
	
	@Autowired
	PipelineDescriptorConversionService conversionService;
	
	@PostMapping("/convertFile")
    public ResponseEntity<Resource> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			Resource converted = conversionService.convert(file.getInputStream());

			return ResponseEntity.ok()
			        .contentType(MediaType.parseMediaType("application/octet-stream"))
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + converted.getFilename() + "\"")
			        .body(converted);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was a problem while converting: ", e);
		}
	}
}
