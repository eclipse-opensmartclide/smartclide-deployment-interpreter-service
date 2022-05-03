package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

public class AllowFailure {
	Boolean allowFailure;
	List<String> exitCodes;
	public Boolean getAllowFailure() {
		return allowFailure;
	}
	public void setAllowFailure(Boolean allowFailure) {
		this.allowFailure = allowFailure;
	}
	public List<String> getExitCodes() {
		return exitCodes;
	}
	public void setExitCodes(List<String> exitCodes) {
		this.exitCodes = exitCodes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(allowFailure, exitCodes);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllowFailure other = (AllowFailure) obj;
		return Objects.equals(allowFailure, other.allowFailure) && Objects.equals(exitCodes, other.exitCodes);
	}
}
