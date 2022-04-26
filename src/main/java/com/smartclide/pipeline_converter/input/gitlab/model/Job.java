package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
@JsonPropertyOrder({
	"stage",
	"extends",
	"needs",
    "image",
    "services",
    "cache",
    "variables",
    "beforeScript",
    "afterScript",
    "pages",
    "jobs"
})
public class Job {
	@JsonIgnore
	String name;
	DockerImage image;
	List<DockerImage> services;
	List<String> beforeScript;
	List<String> afterScript;
	List<Rule> rules;
	Map<String, String> variables;
	List<CacheEntry> cache;
	List<CacheEntry> secrets;
	@JsonDeserialize()
	List<String> script;
	String stage;
	Filter only;
	@JsonProperty("extends")
	List<String> _extends = new ArrayList<String>();
	List<BaseJobDependency> needs;
	Filter except;
	List<String> tags;
	AllowFailure allowFailure;
	String timeout;
	RunConditions when;
	String startIn;
	List<String> dependencies;
	Artifacts artifacts;
	Environment environment;
	Release release;
	String coverage;
	Retry retry;
//	Parallel parallel; //not supported by now
	Boolean interruptible;
	String resource_group;
	Trigger trigger;
	Inherit inherit;
	
	public Job() {
	}
	
	public Job(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public List<Rule> getRules() {
		return rules;
	}
	public void setRules(List<Rule> rules) {
		this.rules = rules;
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
	public List<CacheEntry> getSecrets() {
		return secrets;
	}
	public void setSecrets(List<CacheEntry> secrets) {
		this.secrets = secrets;
	}
	public List<String> getScript() {
		return script;
	}
	public void setScript(Object script) {
		if(String.class.isInstance(script)) {
			this.script = List.of((String)script);
		}else {
			this.script = (List<String>)script;
		}
	}
	
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public Filter getOnly() {
		return only;
	}
	public void setOnly(Object filter) {
		this.only = parseFilter(filter);
	}
	public List<String> getExtends() {
		return _extends;
	}
	public void setExtends(List<String> _extends) {
		this._extends = _extends;
	}
	public void addExtends(String _extends) {
		this._extends.add(_extends);
	}
	
	public List<BaseJobDependency> getNeeds() {
		return needs;
	}
	public void setNeeds(List<BaseJobDependency> needs) {
		this.needs = needs;
	}
	public Filter getExcept() {
		return except;
	}
	public void setExcept(Object filter) {
		this.except = parseFilter(filter);
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public AllowFailure getAllowFailure() {
		return allowFailure;
	}
	public void setAllowFailure(AllowFailure allowFailure) {
		this.allowFailure = allowFailure;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public RunConditions getWhen() {
		return when;
	}
	public void setWhen(RunConditions when) {
		this.when = when;
	}
	public String getStartIn() {
		return startIn;
	}
	public void setStartIn(String startIn) {
		this.startIn = startIn;
	}
	public List<String> getDependencies() {
		return dependencies;
	}
	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}
	public Artifacts getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(Artifacts artifacts) {
		this.artifacts = artifacts;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public Release getRelease() {
		return release;
	}
	public void setRelease(Release release) {
		this.release = release;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public Retry getRetry() {
		return retry;
	}
	public void setRetry(Retry retry) {
		this.retry = retry;
	}
	public Boolean getInterruptible() {
		return interruptible;
	}
	public void setInterruptible(Boolean interruptible) {
		this.interruptible = interruptible;
	}
	public String getResource_group() {
		return resource_group;
	}
	public void setResource_group(String resource_group) {
		this.resource_group = resource_group;
	}
	public Trigger getTrigger() {
		return trigger;
	}
	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	public Inherit getInherit() {
		return inherit;
	}
	public void setInherit(Inherit inherit) {
		this.inherit = inherit;
	}
	
	private Filter parseFilter(Object filter) {
		Filter theFilter;
		if(Filter.class.isInstance(filter)) {
			theFilter = (Filter)filter;
		}else if(List.class.isInstance(filter) && String.class.isInstance(((List)filter).get(0))){
			theFilter = new Filter((List)filter);
		}else {
			ObjectMapper om = new ObjectMapper();
			theFilter = om.convertValue(filter, Filter.class);
		}
		return theFilter;
	}
}
