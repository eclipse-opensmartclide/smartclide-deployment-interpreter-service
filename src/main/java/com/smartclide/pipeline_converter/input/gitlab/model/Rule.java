package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "if",
    "changes",
    "exists",
    "variables",
    "when",
    "start_in",
    "allow_failure"
})
public class Rule {
	@JsonProperty("if")
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
	@Override
	public int hashCode() {
		return Objects.hash(_if, allow_failure, changes, exists, start_in, variables, when);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		return Objects.equals(_if, other._if) && Objects.equals(allow_failure, other.allow_failure)
				&& Objects.equals(changes, other.changes) && Objects.equals(exists, other.exists)
				&& Objects.equals(start_in, other.start_in) && Objects.equals(variables, other.variables)
				&& when == other.when;
	}
}
