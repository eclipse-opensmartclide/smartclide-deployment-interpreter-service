package com.smartclide.pipeline_converter.input.gitlab.model;

public class MultiProjectTrigger implements Trigger{
	String project;
	String branch;
	String strategy;
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
}
