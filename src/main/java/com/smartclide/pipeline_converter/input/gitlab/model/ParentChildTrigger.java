package com.smartclide.pipeline_converter.input.gitlab.model;

public class ParentChildTrigger implements Trigger {
	IncludeItems include;
	String strategy;
	public IncludeItems getInclude() {
		return include;
	}
	public void setInclude(IncludeItems include) {
		this.include = include;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	
}
