package com.smartclide.pipeline_converter.input.jenkins.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class Retry {
	String maxRetries;
	When when;
}
