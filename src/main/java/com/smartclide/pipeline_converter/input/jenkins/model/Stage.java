package com.smartclide.pipeline_converter.input.jenkins.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
	private String name;
	private Agent agent;
	private Map<String, String> environment;
	private When when;
	private List<String> steps;
	private Post post;
	private List<Stage> stages;
	private List<Stage> parallel;
//	matrix not yet supported
}
