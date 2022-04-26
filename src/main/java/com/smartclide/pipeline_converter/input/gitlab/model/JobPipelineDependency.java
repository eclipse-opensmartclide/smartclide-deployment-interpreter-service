package com.smartclide.pipeline_converter.input.gitlab.model;

public class JobPipelineDependency extends BaseJobDependency{
	String pipeline;

	public String getPipeline() {
		return pipeline;
	}

	public void setPipeline(String pipeline) {
		this.pipeline = pipeline;
	}
}
