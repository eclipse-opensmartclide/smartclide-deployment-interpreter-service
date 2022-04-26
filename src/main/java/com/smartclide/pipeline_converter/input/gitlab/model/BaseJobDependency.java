package com.smartclide.pipeline_converter.input.gitlab.model;

public class BaseJobDependency {
	String job;
	Boolean artifacts;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Boolean getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(Boolean artifacts) {
		this.artifacts = artifacts;
	}

}
