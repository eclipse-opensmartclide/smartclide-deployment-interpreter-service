package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "services",
    "cache",
    "beforeScript",
    "afterScript",
    "variables",
    "stages",
    "pages",
    "jobs"
})
public class Pipeline {
	DockerImage image;
	List<DockerImage> services;
	@JsonProperty("default")
	Job _default;
	List<String> beforeScript;
	List<String> afterScript;
	@JsonProperty("variables")
	Map<String, String> variables;
	List<CacheEntry> cache;
	@JsonProperty("stages")
	List<String> stages = new ArrayList<String>();
	List<IncludeItem> include;
	Job pages;
//	Workflow workflow; //not supported by now
	
	Map<String, Job> jobs = new LinkedHashMap<>();
	
	public DockerImage getImage() {
		return image;
	}
	public void setImage(DockerImage image) {
		this.image = image;
	}
	public List<DockerImage> getServices() {
		return services;
	}
	public void setServices(List<DockerImage> services) {
		this.services = services;
	}
	public Job get_default() {
		return _default;
	}
	public void set_default(Job _default) {
		this._default = _default;
	}
	public List<String> getBeforeScript() {
		return beforeScript;
	}
	public void setBeforeScript(List<String> beforeScript) {
		this.beforeScript = beforeScript;
	}
	public List<String> getAfterScript() {
		return afterScript;
	}
	public void setAfterScript(List<String> afterScript) {
		this.afterScript = afterScript;
	}
	public Map<String, String> getVariables() {
		return variables;
	}
	public void setVariables(Map<String, String> variables) {
		this.variables = variables;
	}
	public List<CacheEntry> getCache() {
		return cache;
	}
	public void setCache(List<CacheEntry> cache) {
		this.cache = cache;
	}
	public List<String> getStages() {
		return stages;
	}
	public void setStages(List<String> stages) {
		this.stages = stages;
	}
	public List<IncludeItem> getInclude() {
		return include;
	}
	public void setInclude(List<IncludeItem> include) {
		this.include = include;
	}
	public Job getPages() {
		return pages;
	}
	public void setPages(Job pages) {
		this.pages = pages;
	}
	@JsonUnwrapped
	public Map<String, Job> getJobs() {
		return jobs;
	}
	
	@JsonAnySetter
	public void addJob(String jobname, Object job) {
		Job theJob;
		if(!Job.class.isInstance(job)) {
			ObjectMapper om = new ObjectMapper();
			theJob = om.convertValue(job, Job.class);
		}else {
			theJob = (Job) job;
		}
		this.jobs.put(jobname, theJob);
	}
}
