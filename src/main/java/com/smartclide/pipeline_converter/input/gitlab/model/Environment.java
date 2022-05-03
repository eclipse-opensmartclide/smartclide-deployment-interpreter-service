package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.Objects;

public class Environment {
	String name;
	String url;
	String onStop;
	String action;
	String autoStopIn;
	KubernetesEnvironment kubernetes;
	String deploymentTier;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOnStop() {
		return onStop;
	}
	public void setOnStop(String onStop) {
		this.onStop = onStop;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getAutoStopIn() {
		return autoStopIn;
	}
	public void setAutoStopIn(String autoStopIn) {
		this.autoStopIn = autoStopIn;
	}
	public KubernetesEnvironment getKubernetes() {
		return kubernetes;
	}
	public void setKubernetes(KubernetesEnvironment kubernetes) {
		this.kubernetes = kubernetes;
	}
	public String getDeploymentTier() {
		return deploymentTier;
	}
	public void setDeploymentTier(String deploymentTier) {
		this.deploymentTier = deploymentTier;
	}
	@Override
	public int hashCode() {
		return Objects.hash(action, autoStopIn, deploymentTier, kubernetes, name, onStop, url);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Environment other = (Environment) obj;
		return Objects.equals(action, other.action) && Objects.equals(autoStopIn, other.autoStopIn)
				&& Objects.equals(deploymentTier, other.deploymentTier) && Objects.equals(kubernetes, other.kubernetes)
				&& Objects.equals(name, other.name) && Objects.equals(onStop, other.onStop)
				&& Objects.equals(url, other.url);
	}
	
}
