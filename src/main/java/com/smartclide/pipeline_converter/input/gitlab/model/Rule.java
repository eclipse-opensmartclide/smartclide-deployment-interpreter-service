package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Map;

public class Rule {
	String _if;
	List<String> changes;
	List<String> exists;
	Map<String, String> variables;
	RunConditions when;
	String start_in;
	AllowFailure allow_failure;
	public String get_if() {
		return _if;
	}
	public void set_if(String _if) {
		this._if = _if;
	}
	public List<String> getChanges() {
		return changes;
	}
	public void setChanges(List<String> changes) {
		this.changes = changes;
	}
	public List<String> getExists() {
		return exists;
	}
	public void setExists(List<String> exists) {
		this.exists = exists;
	}
	public Map<String, String> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
	public RunConditions getWhen() {
		return when;
	}
	public void setWhen(RunConditions when) {
		this.when = when;
	}
	public String getStart_in() {
		return start_in;
	}
	public void setStart_in(String start_in) {
		this.start_in = start_in;
	}
	public AllowFailure getAllow_failure() {
		return allow_failure;
	}
	public void setAllow_failure(AllowFailure allow_failure) {
		this.allow_failure = allow_failure;
	}
}
