package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_DEFAULT)
@JsonPropertyOrder({
    "image",
    "services",
    "cache",
    "beforeScript",
    "afterScript",
    "variables",
    "default",
    "stages",
    "pages",
    "jobs"
})
public class Pipeline {
	DockerImage image;
	List<DockerImage> services = new ArrayList<>();
	@JsonProperty("default")
	Job _default = new Job();
	List<String> beforeScript = new ArrayList<>();
	List<String> afterScript = new ArrayList<>();
	@JsonProperty("variables")
	Map<String, String> variables = new LinkedHashMap<>();
	List<CacheEntry> cache = new ArrayList<>();
	@JsonProperty("stages")
	Set<String> stages = new LinkedHashSet<String>();
	List<IncludeItem> include = new ArrayList<>();
	Job pages = new Job();
	Workflow workflow;

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
		variables.forEach(this.variables::put);
	}
	public List<CacheEntry> getCache() {
		return cache;
	}
	public void setCache(List<CacheEntry> cache) {
		this.cache = cache;
	}
	public Set<String> getStages() {
		return stages;
	}
	public void setStages(List<String> stages) {
		this.stages.addAll(stages);
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
	@JsonAnyGetter
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
		this.stages.add(theJob.getStage());
	}
	public Workflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}
	@Override
	public int hashCode() {
		return Objects.hash(_default, afterScript, beforeScript, cache, image, include, jobs, pages, services, stages,
				variables, workflow);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pipeline other = (Pipeline) obj;
		return Objects.equals(_default, other._default) && Objects.equals(afterScript, other.afterScript)
				&& Objects.equals(beforeScript, other.beforeScript) && Objects.equals(cache, other.cache)
				&& Objects.equals(image, other.image) && Objects.equals(include, other.include)
				&& Objects.equals(jobs, other.jobs) && Objects.equals(pages, other.pages)
				&& Objects.equals(services, other.services) && Objects.equals(stages, other.stages)
				&& Objects.equals(variables, other.variables) && Objects.equals(workflow, other.workflow);
	}
}
