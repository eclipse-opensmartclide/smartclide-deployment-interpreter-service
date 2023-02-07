package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

public class DockerImage {
	String name;
	List<String> entryPoint;
	
	public DockerImage() {}
	
	public DockerImage(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getEntryPoint() {
		return entryPoint;
	}
	public void setEntryPoint(List<String> entryPoint) {
		this.entryPoint = entryPoint;
	}
	@Override
	public int hashCode() {
		return Objects.hash(entryPoint, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DockerImage other = (DockerImage) obj;
		return Objects.equals(entryPoint, other.entryPoint) && Objects.equals(name, other.name);
	}
}
