package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Specify files or directories to cache between jobs. Can be set globally or per job.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "paths",
    "key",
    "untracked",
    "policy"
})
@Generated("jsonschema2pojo")
public class CacheEntry {

    /**
     * List of files or paths to cache.
     * 
     */
    @JsonProperty("paths")
    @JsonPropertyDescription("List of files or paths to cache.")
    private List<String> paths = new ArrayList<String>();
    @JsonProperty("key")
    private Object key;
    /**
     * Set to `true` to cache untracked files.
     * 
     */
    @JsonProperty("untracked")
    @JsonPropertyDescription("Set to `true` to cache untracked files.")
    private Boolean untracked = false;
    /**
     * Determines the strategy for downloading and updating the cache.
     * 
     */
    @JsonProperty("policy")
    @JsonPropertyDescription("Determines the strategy for downloading and updating the cache.")
    private String policy = "pull-push";

    /**
     * List of files or paths to cache.
     * 
     */
    @JsonProperty("paths")
    public List<String> getPaths() {
        return paths;
    }

    /**
     * List of files or paths to cache.
     * 
     */
    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    @JsonProperty("key")
    public Object getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(Object key) {
        this.key = key;
    }

    /**
     * Set to `true` to cache untracked files.
     * 
     */
    @JsonProperty("untracked")
    public Boolean getUntracked() {
        return untracked;
    }

    /**
     * Set to `true` to cache untracked files.
     * 
     */
    @JsonProperty("untracked")
    public void setUntracked(Boolean untracked) {
        this.untracked = untracked;
    }

    /**
     * Determines the strategy for downloading and updating the cache.
     * 
     */
    @JsonProperty("policy")
    public String getPolicy() {
        return policy;
    }

    /**
     * Determines the strategy for downloading and updating the cache.
     * 
     */
    @JsonProperty("policy")
    public void setPolicy(String policy) {
        this.policy = policy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CacheEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("paths");
        sb.append('=');
        sb.append(((this.paths == null)?"<null>":this.paths));
        sb.append(',');
        sb.append("key");
        sb.append('=');
        sb.append(((this.key == null)?"<null>":this.key));
        sb.append(',');
        sb.append("untracked");
        sb.append('=');
        sb.append(((this.untracked == null)?"<null>":this.untracked));
        sb.append(',');
        sb.append("policy");
        sb.append('=');
        sb.append(((this.policy == null)?"<null>":this.policy));
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
        result = ((result* 31)+((this.untracked == null)? 0 :this.untracked.hashCode()));
        result = ((result* 31)+((this.paths == null)? 0 :this.paths.hashCode()));
        result = ((result* 31)+((this.key == null)? 0 :this.key.hashCode()));
        result = ((result* 31)+((this.policy == null)? 0 :this.policy.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CacheEntry) == false) {
            return false;
        }
        CacheEntry rhs = ((CacheEntry) other);
        return (((((this.untracked == rhs.untracked)||((this.untracked!= null)&&this.untracked.equals(rhs.untracked)))&&((this.paths == rhs.paths)||((this.paths!= null)&&this.paths.equals(rhs.paths))))&&((this.key == rhs.key)||((this.key!= null)&&this.key.equals(rhs.key))))&&((this.policy == rhs.policy)||((this.policy!= null)&&this.policy.equals(rhs.policy))));
    }

}
