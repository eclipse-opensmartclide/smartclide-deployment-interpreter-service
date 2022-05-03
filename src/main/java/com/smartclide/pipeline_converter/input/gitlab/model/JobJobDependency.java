package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

public class JobJobDependency extends BaseJobDependency {
	Boolean optional;
	
	public JobJobDependency(String jobName) {
		super();
		setJob(jobName);
	}

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(optional);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobJobDependency other = (JobJobDependency) obj;
		return Objects.equals(optional, other.optional);
	}
}
