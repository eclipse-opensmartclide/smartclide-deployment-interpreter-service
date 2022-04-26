package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;

public class CacheEntry {
	private List<String> paths;
	private CacheKey key;
	private Boolean untracked = false;
	private String policy = "pull-push";
	public List<String> getPaths() {
		return paths;
	}
	public void setPaths(List<String> paths) {
		this.paths = paths;
	}
	public CacheKey getKey() {
		return key;
	}
	public void setKey(CacheKey key) {
		this.key = key;
	}
	public Boolean getUntracked() {
		return untracked;
	}
	public void setUntracked(Boolean untracked) {
		this.untracked = untracked;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
}
