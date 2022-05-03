package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(key, paths, policy, untracked);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CacheEntry other = (CacheEntry) obj;
		return Objects.equals(key, other.key) && Objects.equals(paths, other.paths)
				&& Objects.equals(policy, other.policy) && Objects.equals(untracked, other.untracked);
	}
}
