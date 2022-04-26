package com.smartclide.pipeline_converter.input.gitlab.model;

public class JobProjectDependency {
	String project;
	String ref;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
}
