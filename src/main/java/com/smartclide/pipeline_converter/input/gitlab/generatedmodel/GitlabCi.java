package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.smartclide.pipeline_converter.input.gitlab.model.Workflow;


/**
 * Gitlab CI configuration
 * <p>
 * Gitlab has a built-in solution for doing CI called Gitlab CI. It is configured by supplying a file called `.gitlab-ci.yml`, which will list all the jobs that are going to run for the project. A full list of all options can be found at https://docs.gitlab.com/ee/ci/yaml/. You can read more about Gitlab CI at https://docs.gitlab.com/ee/ci/README.html.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "$schema",
    "image",
    "services",
    "before_script",
    "after_script",
    "variables",
    "cache",
    "default",
    "stages",
    "include",
    "pages",
    "workflow"
})
@Generated("jsonschema2pojo")
public class GitlabCi {

    @JsonProperty("$schema")
    private URI $schema;
    /**
     * Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.
     * 
     */
    @JsonProperty("image")
    @JsonPropertyDescription("Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.")
    private Object image;
    /**
     * Similar to `image` property, but will link the specified services to the `image` container.
     * 
     */
    @JsonProperty("services")
    @JsonPropertyDescription("Similar to `image` property, but will link the specified services to the `image` container.")
    private List<Object> services = new ArrayList<Object>();
    /**
     * Defines scripts that should run *before* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("before_script")
    @JsonPropertyDescription("Defines scripts that should run *before* the job. Can be set globally or per job.")
    private List<Object> beforeScript = new ArrayList<Object>();
    /**
     * Defines scripts that should run *after* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("after_script")
    @JsonPropertyDescription("Defines scripts that should run *after* the job. Can be set globally or per job.")
    private List<Object> afterScript = new ArrayList<Object>();
    /**
     * Defines environment variables globally. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off. You can use the value and description keywords to define variables that are prefilled when running a pipeline manually.
     * 
     */
    @JsonProperty("variables")
    @JsonPropertyDescription("Defines environment variables globally. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off. You can use the value and description keywords to define variables that are prefilled when running a pipeline manually.")
    private GlobalVariables variables;
    @JsonProperty("cache")
    private Object cache;
    @JsonProperty("default")
    private Default _default;
    /**
     * Groups jobs into stages. All jobs in one stage must complete before next stage is executed. Defaults to ['build', 'test', 'deploy'].
     * 
     */
    @JsonProperty("stages")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @JsonPropertyDescription("Groups jobs into stages. All jobs in one stage must complete before next stage is executed. Defaults to ['build', 'test', 'deploy'].")
    private Set<String> stages = new LinkedHashSet<String>(Arrays.asList("build", "test", "deploy"));
    /**
     * Can be `IncludeItem` or `IncludeItem[]`. Each `IncludeItem` will be a string, or an object with properties for the method if including external YAML file. The external content will be fetched, included and evaluated along the `.gitlab-ci.yml`.
     * 
     */
    @JsonProperty("include")
    @JsonPropertyDescription("Can be `IncludeItem` or `IncludeItem[]`. Each `IncludeItem` will be a string, or an object with properties for the method if including external YAML file. The external content will be fetched, included and evaluated along the `.gitlab-ci.yml`.")
    private Object include;
    @JsonProperty("pages")
    private Object pages;
    @JsonProperty("workflow")
    private Workflow workflow;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("$schema")
    public URI get$schema() {
        return $schema;
    }

    @JsonProperty("$schema")
    public void set$schema(URI $schema) {
        this.$schema = $schema;
    }

    /**
     * Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.
     * 
     */
    @JsonProperty("image")
    public Object getImage() {
        return image;
    }

    /**
     * Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.
     * 
     */
    @JsonProperty("image")
    public void setImage(Object image) {
        this.image = image;
    }

    /**
     * Similar to `image` property, but will link the specified services to the `image` container.
     * 
     */
    @JsonProperty("services")
    public List<Object> getServices() {
        return services;
    }

    /**
     * Similar to `image` property, but will link the specified services to the `image` container.
     * 
     */
    @JsonProperty("services")
    public void setServices(List<Object> services) {
        this.services = services;
    }

    /**
     * Defines scripts that should run *before* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("before_script")
    public List<Object> getBeforeScript() {
        return beforeScript;
    }

    /**
     * Defines scripts that should run *before* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("before_script")
    public void setBeforeScript(List<Object> beforeScript) {
        this.beforeScript = beforeScript;
    }

    /**
     * Defines scripts that should run *after* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("after_script")
    public List<Object> getAfterScript() {
        return afterScript;
    }

    /**
     * Defines scripts that should run *after* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("after_script")
    public void setAfterScript(List<Object> afterScript) {
        this.afterScript = afterScript;
    }

    /**
     * Defines environment variables globally. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off. You can use the value and description keywords to define variables that are prefilled when running a pipeline manually.
     * 
     */
    @JsonProperty("variables")
    public GlobalVariables getVariables() {
        return variables;
    }

    /**
     * Defines environment variables globally. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off. You can use the value and description keywords to define variables that are prefilled when running a pipeline manually.
     * 
     */
    @JsonProperty("variables")
    public void setVariables(GlobalVariables variables) {
        this.variables = variables;
    }

    @JsonProperty("cache")
    public Object getCache() {
        return cache;
    }

    @JsonProperty("cache")
    public void setCache(Object cache) {
        this.cache = cache;
    }

    @JsonProperty("default")
    public Default getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Default _default) {
        this._default = _default;
    }

    /**
     * Groups jobs into stages. All jobs in one stage must complete before next stage is executed. Defaults to ['build', 'test', 'deploy'].
     * 
     */
    @JsonProperty("stages")
    public Set<String> getStages() {
        return stages;
    }

    /**
     * Groups jobs into stages. All jobs in one stage must complete before next stage is executed. Defaults to ['build', 'test', 'deploy'].
     * 
     */
    @JsonProperty("stages")
    public void setStages(Set<String> stages) {
        this.stages = stages;
    }

    /**
     * Can be `IncludeItem` or `IncludeItem[]`. Each `IncludeItem` will be a string, or an object with properties for the method if including external YAML file. The external content will be fetched, included and evaluated along the `.gitlab-ci.yml`.
     * 
     */
    @JsonProperty("include")
    public Object getInclude() {
        return include;
    }

    /**
     * Can be `IncludeItem` or `IncludeItem[]`. Each `IncludeItem` will be a string, or an object with properties for the method if including external YAML file. The external content will be fetched, included and evaluated along the `.gitlab-ci.yml`.
     * 
     */
    @JsonProperty("include")
    public void setInclude(Object include) {
        this.include = include;
    }

    @JsonProperty("pages")
    public Object getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(Object pages) {
        this.pages = pages;
    }

    @JsonProperty("workflow")
    public Workflow getWorkflow() {
        return workflow;
    }

    @JsonProperty("workflow")
    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(GitlabCi.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("$schema");
        sb.append('=');
        sb.append(((this.$schema == null)?"<null>":this.$schema));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("services");
        sb.append('=');
        sb.append(((this.services == null)?"<null>":this.services));
        sb.append(',');
        sb.append("beforeScript");
        sb.append('=');
        sb.append(((this.beforeScript == null)?"<null>":this.beforeScript));
        sb.append(',');
        sb.append("afterScript");
        sb.append('=');
        sb.append(((this.afterScript == null)?"<null>":this.afterScript));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
        sb.append(',');
        sb.append("cache");
        sb.append('=');
        sb.append(((this.cache == null)?"<null>":this.cache));
        sb.append(',');
        sb.append("_default");
        sb.append('=');
        sb.append(((this._default == null)?"<null>":this._default));
        sb.append(',');
        sb.append("stages");
        sb.append('=');
        sb.append(((this.stages == null)?"<null>":this.stages));
        sb.append(',');
        sb.append("include");
        sb.append('=');
        sb.append(((this.include == null)?"<null>":this.include));
        sb.append(',');
        sb.append("pages");
        sb.append('=');
        sb.append(((this.pages == null)?"<null>":this.pages));
        sb.append(',');
        sb.append("workflow");
        sb.append('=');
        sb.append(((this.workflow == null)?"<null>":this.workflow));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this._default == null)? 0 :this._default.hashCode()));
        result = ((result* 31)+((this.include == null)? 0 :this.include.hashCode()));
        result = ((result* 31)+((this.variables == null)? 0 :this.variables.hashCode()));
        result = ((result* 31)+((this.cache == null)? 0 :this.cache.hashCode()));
        result = ((result* 31)+((this.$schema == null)? 0 :this.$schema.hashCode()));
        result = ((result* 31)+((this.workflow == null)? 0 :this.workflow.hashCode()));
        result = ((result* 31)+((this.services == null)? 0 :this.services.hashCode()));
        result = ((result* 31)+((this.afterScript == null)? 0 :this.afterScript.hashCode()));
        result = ((result* 31)+((this.pages == null)? 0 :this.pages.hashCode()));
        result = ((result* 31)+((this.stages == null)? 0 :this.stages.hashCode()));
        result = ((result* 31)+((this.beforeScript == null)? 0 :this.beforeScript.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GitlabCi) == false) {
            return false;
        }
        GitlabCi rhs = ((GitlabCi) other);
        return ((((((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this._default == rhs._default)||((this._default!= null)&&this._default.equals(rhs._default))))&&((this.include == rhs.include)||((this.include!= null)&&this.include.equals(rhs.include))))&&((this.variables == rhs.variables)||((this.variables!= null)&&this.variables.equals(rhs.variables))))&&((this.cache == rhs.cache)||((this.cache!= null)&&this.cache.equals(rhs.cache))))&&((this.$schema == rhs.$schema)||((this.$schema!= null)&&this.$schema.equals(rhs.$schema))))&&((this.workflow == rhs.workflow)||((this.workflow!= null)&&this.workflow.equals(rhs.workflow))))&&((this.services == rhs.services)||((this.services!= null)&&this.services.equals(rhs.services))))&&((this.afterScript == rhs.afterScript)||((this.afterScript!= null)&&this.afterScript.equals(rhs.afterScript))))&&((this.pages == rhs.pages)||((this.pages!= null)&&this.pages.equals(rhs.pages))))&&((this.stages == rhs.stages)||((this.stages!= null)&&this.stages.equals(rhs.stages))))&&((this.beforeScript == rhs.beforeScript)||((this.beforeScript!= null)&&this.beforeScript.equals(rhs.beforeScript))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
