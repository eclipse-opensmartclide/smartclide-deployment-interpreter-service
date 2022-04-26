package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;

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
}
