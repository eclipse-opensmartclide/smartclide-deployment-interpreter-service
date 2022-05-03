package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Filter {
	List<String> refs = new ArrayList<>();
	String kubernetes;
	List<String> variables = new ArrayList<>();
	List<String> changes = new ArrayList<>();
	
	public Filter() {
		
	}
	
	public Filter(List<String> refs) {
		this.refs = refs;
	}
	
	public List<String> getRefs() {
		return refs;
	}
//	public void setRefs(List<String> refs) {
//		this.refs = refs;
//	}
	public void setRefs(Object ref) {
		if(String.class.isInstance(ref)) {
			this.addRef((String)ref);
		}else {
			this.refs = (List<String>)ref;
		}
	}
	public void addRef(String ref) {
		this.refs.add(ref);
	}
	public String getKubernetes() {
		return kubernetes;
	}
	public void setKubernetes(String kubernetes) {
		this.kubernetes = kubernetes;
	}
	public List<String> getVariables() {
		return variables;
	}
	public void setVariables(List<String> variables) {
		this.variables = variables;
	}
	public List<String> getChanges() {
		return changes;
	}
	public void setChanges(List<String> changes) {
		this.changes = changes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(changes, kubernetes, refs, variables);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filter other = (Filter) obj;
		return Objects.equals(changes, other.changes) && Objects.equals(kubernetes, other.kubernetes)
				&& Objects.equals(refs, other.refs) && Objects.equals(variables, other.variables);
	}
}
