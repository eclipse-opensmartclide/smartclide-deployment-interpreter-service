package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(artifacts, job);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseJobDependency other = (BaseJobDependency) obj;
		return Objects.equals(artifacts, other.artifacts) && Objects.equals(job, other.job);
	}

}
