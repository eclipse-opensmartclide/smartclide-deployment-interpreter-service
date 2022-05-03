package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

public class JobPipelineDependency extends BaseJobDependency{
	String pipeline;

	public String getPipeline() {
		return pipeline;
	}

	public void setPipeline(String pipeline) {
		this.pipeline = pipeline;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pipeline);
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
		JobPipelineDependency other = (JobPipelineDependency) obj;
		return Objects.equals(pipeline, other.pipeline);
	}
}
