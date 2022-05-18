package com.smartclide.pipeline_converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.smartclide.pipeline_converter.service.PipelineDescriptorConversionService;

@RestController
public class PipelineConverterController {
	
	@Autowired
	PipelineDescriptorConversionService conversionService;
	
	@CrossOrigin("*")
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
