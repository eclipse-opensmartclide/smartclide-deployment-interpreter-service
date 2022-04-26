package com.smartclide.pipeline_converter.input.gitlab.model;

public class JobJobDependency extends BaseJobDependency {
	Boolean optional;

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
}
