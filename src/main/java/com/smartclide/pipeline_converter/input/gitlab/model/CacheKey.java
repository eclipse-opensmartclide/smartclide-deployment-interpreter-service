package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

public class CacheKey {
	String value;
	List<String> files;
	
	public CacheKey(String value) {
		this.value = value;
	}
	
	public CacheKey(List<String> files) {
		this.files = files;
	}
	
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
	@Override
	public int hashCode() {
		return Objects.hash(files, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CacheKey other = (CacheKey) obj;
		return Objects.equals(files, other.files) && Objects.equals(value, other.value);
	}
}
