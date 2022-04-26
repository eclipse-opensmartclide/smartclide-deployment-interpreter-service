package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "after_script",
    "artifacts",
    "before_script",
    "cache",
    "image",
    "interruptible",
    "retry",
    "services",
    "tags",
    "timeout"
})
@Generated("jsonschema2pojo")
public class Default {

    /**
     * Defines scripts that should run *after* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("after_script")
    @JsonPropertyDescription("Defines scripts that should run *after* the job. Can be set globally or per job.")
    private List<Object> afterScript = new ArrayList<Object>();
    /**
     * Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.
     * 
     */
    @JsonProperty("artifacts")
    @JsonPropertyDescription("Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.")
    private Artifacts artifacts;
    /**
     * Defines scripts that should run *before* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("before_script")
    @JsonPropertyDescription("Defines scripts that should run *before* the job. Can be set globally or per job.")
    private List<Object> beforeScript = new ArrayList<Object>();
    @JsonProperty("cache")
    private Object cache;
    /**
     * Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.
     * 
     */
    @JsonProperty("image")
    @JsonPropertyDescription("Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.")
    private Object image;
    /**
     * Interruptible is used to indicate that a job should be canceled if made redundant by a newer pipeline run.
     * 
     */
    @JsonProperty("interruptible")
    @JsonPropertyDescription("Interruptible is used to indicate that a job should be canceled if made redundant by a newer pipeline run.")
    private Boolean interruptible = false;
    /**
     * Retry a job if it fails. Can be a simple integer or object definition.
     * 
     */
    @JsonProperty("retry")
    @JsonPropertyDescription("Retry a job if it fails. Can be a simple integer or object definition.")
    private Object retry;
    /**
     * Similar to `image` property, but will link the specified services to the `image` container.
     * 
     */
    @JsonProperty("services")
    @JsonPropertyDescription("Similar to `image` property, but will link the specified services to the `image` container.")
    private List<Object> services = new ArrayList<Object>();
    /**
     * Used to select runners from the list of available runners. A runner must have all tags listed here to run the job.
     * 
     */
    @JsonProperty("tags")
    @JsonPropertyDescription("Used to select runners from the list of available runners. A runner must have all tags listed here to run the job.")
    private List<String> tags = new ArrayList<String>();
    /**
     * Allows you to configure a timeout for a specific job (e.g. `1 minute`, `1h 30m 12s`). Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#timeout
     * 
     */
    @JsonProperty("timeout")
    @JsonPropertyDescription("Allows you to configure a timeout for a specific job (e.g. `1 minute`, `1h 30m 12s`). Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#timeout")
    private String timeout;

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
     * Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.
     * 
     */
    @JsonProperty("artifacts")
    public Artifacts getArtifacts() {
        return artifacts;
    }

    /**
     * Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.
     * 
     */
    @JsonProperty("artifacts")
    public void setArtifacts(Artifacts artifacts) {
        this.artifacts = artifacts;
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

    @JsonProperty("cache")
    public Object getCache() {
        return cache;
    }

    @JsonProperty("cache")
    public void setCache(Object cache) {
        this.cache = cache;
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
     * Interruptible is used to indicate that a job should be canceled if made redundant by a newer pipeline run.
     * 
     */
    @JsonProperty("interruptible")
    public Boolean getInterruptible() {
        return interruptible;
    }

    /**
     * Interruptible is used to indicate that a job should be canceled if made redundant by a newer pipeline run.
     * 
     */
    @JsonProperty("interruptible")
    public void setInterruptible(Boolean interruptible) {
        this.interruptible = interruptible;
    }

    /**
     * Retry a job if it fails. Can be a simple integer or object definition.
     * 
     */
    @JsonProperty("retry")
    public Object getRetry() {
        return retry;
    }

    /**
     * Retry a job if it fails. Can be a simple integer or object definition.
     * 
     */
    @JsonProperty("retry")
    public void setRetry(Object retry) {
        this.retry = retry;
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
     * Used to select runners from the list of available runners. A runner must have all tags listed here to run the job.
     * 
     */
    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    /**
     * Used to select runners from the list of available runners. A runner must have all tags listed here to run the job.
     * 
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Allows you to configure a timeout for a specific job (e.g. `1 minute`, `1h 30m 12s`). Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#timeout
     * 
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * Allows you to configure a timeout for a specific job (e.g. `1 minute`, `1h 30m 12s`). Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#timeout
     * 
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Default.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("afterScript");
        sb.append('=');
        sb.append(((this.afterScript == null)?"<null>":this.afterScript));
        sb.append(',');
        sb.append("artifacts");
        sb.append('=');
        sb.append(((this.artifacts == null)?"<null>":this.artifacts));
        sb.append(',');
        sb.append("beforeScript");
        sb.append('=');
        sb.append(((this.beforeScript == null)?"<null>":this.beforeScript));
        sb.append(',');
        sb.append("cache");
        sb.append('=');
        sb.append(((this.cache == null)?"<null>":this.cache));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("interruptible");
        sb.append('=');
        sb.append(((this.interruptible == null)?"<null>":this.interruptible));
        sb.append(',');
        sb.append("retry");
        sb.append('=');
        sb.append(((this.retry == null)?"<null>":this.retry));
        sb.append(',');
        sb.append("services");
        sb.append('=');
        sb.append(((this.services == null)?"<null>":this.services));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("timeout");
        sb.append('=');
        sb.append(((this.timeout == null)?"<null>":this.timeout));
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
        result = ((result* 31)+((this.cache == null)? 0 :this.cache.hashCode()));
        result = ((result* 31)+((this.afterScript == null)? 0 :this.afterScript.hashCode()));
        result = ((result* 31)+((this.beforeScript == null)? 0 :this.beforeScript.hashCode()));
        result = ((result* 31)+((this.services == null)? 0 :this.services.hashCode()));
        result = ((result* 31)+((this.interruptible == null)? 0 :this.interruptible.hashCode()));
        result = ((result* 31)+((this.retry == null)? 0 :this.retry.hashCode()));
        result = ((result* 31)+((this.timeout == null)? 0 :this.timeout.hashCode()));
        result = ((result* 31)+((this.artifacts == null)? 0 :this.artifacts.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Default) == false) {
            return false;
        }
        Default rhs = ((Default) other);
        return (((((((((((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image)))&&((this.cache == rhs.cache)||((this.cache!= null)&&this.cache.equals(rhs.cache))))&&((this.afterScript == rhs.afterScript)||((this.afterScript!= null)&&this.afterScript.equals(rhs.afterScript))))&&((this.beforeScript == rhs.beforeScript)||((this.beforeScript!= null)&&this.beforeScript.equals(rhs.beforeScript))))&&((this.services == rhs.services)||((this.services!= null)&&this.services.equals(rhs.services))))&&((this.interruptible == rhs.interruptible)||((this.interruptible!= null)&&this.interruptible.equals(rhs.interruptible))))&&((this.retry == rhs.retry)||((this.retry!= null)&&this.retry.equals(rhs.retry))))&&((this.timeout == rhs.timeout)||((this.timeout!= null)&&this.timeout.equals(rhs.timeout))))&&((this.artifacts == rhs.artifacts)||((this.artifacts!= null)&&this.artifacts.equals(rhs.artifacts))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))));
    }

}
