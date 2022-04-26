package com.smartclide.pipeline_converter.input.gitlab.model;

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
	
}
