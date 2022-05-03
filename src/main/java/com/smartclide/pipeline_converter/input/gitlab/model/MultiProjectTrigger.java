package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(branch, project, strategy);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultiProjectTrigger other = (MultiProjectTrigger) obj;
		return Objects.equals(branch, other.branch) && Objects.equals(project, other.project)
				&& Objects.equals(strategy, other.strategy);
	}
}
