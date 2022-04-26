package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;

public class CacheKey {
	String value;
	List<String> files;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
}
