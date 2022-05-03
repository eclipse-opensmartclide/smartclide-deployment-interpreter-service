package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(project, ref);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobProjectDependency other = (JobProjectDependency) obj;
		return Objects.equals(project, other.project) && Objects.equals(ref, other.ref);
	}
}
