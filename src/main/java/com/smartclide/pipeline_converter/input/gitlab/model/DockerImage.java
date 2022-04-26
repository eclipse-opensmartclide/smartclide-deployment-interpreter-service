package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;

public class DockerImage {
	String name;
	List<String> entryPoint;
	
	public DockerImage(String name) {
		super();
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
}
