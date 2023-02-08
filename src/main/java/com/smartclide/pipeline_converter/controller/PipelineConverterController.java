package com.smartclide.pipeline_converter.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartclide.pipeline_converter.service.PipelineDescriptorConversionService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/pipeline")
public class PipelineConverterController {
		
	private final PipelineDescriptorConversionService conversionService;
		
	@PostMapping(value="/gitlab",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	@Operation(summary = "Create file GitLab from source Jenkins")	
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "File parsing to gitlab Ok",content = {
	                @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = Resource.class)) }),
	        @ApiResponse(responseCode = "400", description = "Format Jenkins file is incorrect", content = @Content)
	})
    public ResponseEntity<?> parseFileToGitLab(
    		@RequestParam(value = "file", required = true) MultipartFile file){				
		try {
			Resource converted = conversionService.convertFileToGitLab(file);
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType("application/octet-stream"))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFilename() + "\"")
					.body(converted);
		} catch (Exception e) {
			log.error("Error processing: ",e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
		
	@PostMapping(value="/jenkins", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)	
	@Operation(summary = "Create file Jenkins from source GitLab")	
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "File parsing to jenkins Ok",content = {
	                @Content(mediaType = "application/octet-stream", schema = @Schema(implementation = Resource.class)) }),
	        @ApiResponse(responseCode = "400", description = "Format GitLab file is incorrect", content = @Content)
	})
	public ResponseEntity<?> parseFileToJenkins(
			@RequestParam(value = "file", required = true) MultipartFile file){		
			try {
				Resource converted = conversionService.convertFileToJenkins(file);
				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType("application/octet-stream"))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getOriginalFilename() + "\"")
						.body(converted);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("Error processing: ",e);
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
}
