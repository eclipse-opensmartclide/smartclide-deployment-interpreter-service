package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

public class KubernetesEnvironment {
	String namespace;

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public int hashCode() {
		return Objects.hash(namespace);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KubernetesEnvironment other = (KubernetesEnvironment) obj;
		return Objects.equals(namespace, other.namespace);
	}
}
