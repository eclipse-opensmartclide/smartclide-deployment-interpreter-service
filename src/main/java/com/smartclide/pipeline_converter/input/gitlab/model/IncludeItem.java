package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

public class IncludeItem {
	String local;
	
	String template;
	
	String artifact;
	String job;
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public String getArtifact() {
		return artifact;
	}
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public int hashCode() {
		return Objects.hash(artifact, job, local, template);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncludeItem other = (IncludeItem) obj;
		return Objects.equals(artifact, other.artifact) && Objects.equals(job, other.job)
				&& Objects.equals(local, other.local) && Objects.equals(template, other.template);
	}

}
