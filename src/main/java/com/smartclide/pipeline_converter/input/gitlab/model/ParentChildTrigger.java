package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(include, strategy);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParentChildTrigger other = (ParentChildTrigger) obj;
		return Objects.equals(include, other.include) && Objects.equals(strategy, other.strategy);
	}
	
}
