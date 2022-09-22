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
public class Pipeline {
	private Agent agent;
	private Map<String, String> environment;
	private List<Stage> stages;
	private Post post;
	private Options options;

}
