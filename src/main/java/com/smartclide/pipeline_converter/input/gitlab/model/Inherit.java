package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

public class Inherit {
	Boolean allDefault;
	List<String> _defaultValues;
	List<String> variables;
	public Boolean getAllDefault() {
		return allDefault;
	}
	public void setAllDefault(Boolean allDefault) {
		this.allDefault = allDefault;
	}
	public List<String> get_defaultValues() {
		return _defaultValues;
	}
	public void set_defaultValues(List<String> _defaultValues) {
		this._defaultValues = _defaultValues;
	}
	public List<String> getVariables() {
		return variables;
	}
	public void setVariables(List<String> variables) {
		this.variables = variables;
	}
	@Override
	public int hashCode() {
		return Objects.hash(_defaultValues, allDefault, variables);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inherit other = (Inherit) obj;
		return Objects.equals(_defaultValues, other._defaultValues) && Objects.equals(allDefault, other.allDefault)
				&& Objects.equals(variables, other.variables);
	}
}
