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
    "if",
    "changes",
    "exists",
    "variables",
    "when",
    "start_in",
    "allow_failure"
})
@Generated("jsonschema2pojo")
public class Rule__2 {

    /**
     * Expression to evaluate whether additional attributes should be provided to the job
     * 
     */
    @JsonProperty("if")
    @JsonPropertyDescription("Expression to evaluate whether additional attributes should be provided to the job")
    private String _if;
    /**
     * Additional attributes will be provided to job if any of the provided paths matches a modified file
     * 
     */
    @JsonProperty("changes")
    @JsonPropertyDescription("Additional attributes will be provided to job if any of the provided paths matches a modified file")
    private List<String> changes = new ArrayList<String>();
    /**
     * Additional attributes will be provided to job if any of the provided paths matches an existing file in the repository
     * 
     */
    @JsonProperty("exists")
    @JsonPropertyDescription("Additional attributes will be provided to job if any of the provided paths matches an existing file in the repository")
    private List<String> exists = new ArrayList<String>();
    /**
     * Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.
     * 
     */
    @JsonProperty("variables")
    @JsonPropertyDescription("Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.")
    private Variables variables;
    /**
     * Describes the conditions for when to run the job. Defaults to 'on_success'.
     * 
     */
    @JsonProperty("when")
    @JsonPropertyDescription("Describes the conditions for when to run the job. Defaults to 'on_success'.")
    private Object when = null;
    /**
     * Used in conjunction with 'when: delayed' to set how long to delay before starting a job.
     * 
     */
    @JsonProperty("start_in")
    @JsonPropertyDescription("Used in conjunction with 'when: delayed' to set how long to delay before starting a job.")
    private String startIn;
    /**
     * Allow job to fail. A failed job does not cause the pipeline to fail.
     * 
     */
    @JsonProperty("allow_failure")
    @JsonPropertyDescription("Allow job to fail. A failed job does not cause the pipeline to fail.")
    private Object allowFailure;

    /**
     * Expression to evaluate whether additional attributes should be provided to the job
     * 
     */
    @JsonProperty("if")
    public String getIf() {
        return _if;
    }

    /**
     * Expression to evaluate whether additional attributes should be provided to the job
     * 
     */
    @JsonProperty("if")
    public void setIf(String _if) {
        this._if = _if;
    }

    /**
     * Additional attributes will be provided to job if any of the provided paths matches a modified file
     * 
     */
    @JsonProperty("changes")
    public List<String> getChanges() {
        return changes;
    }

    /**
     * Additional attributes will be provided to job if any of the provided paths matches a modified file
     * 
     */
    @JsonProperty("changes")
    public void setChanges(List<String> changes) {
        this.changes = changes;
    }

    /**
     * Additional attributes will be provided to job if any of the provided paths matches an existing file in the repository
     * 
     */
    @JsonProperty("exists")
    public List<String> getExists() {
        return exists;
    }

    /**
     * Additional attributes will be provided to job if any of the provided paths matches an existing file in the repository
     * 
     */
    @JsonProperty("exists")
    public void setExists(List<String> exists) {
        this.exists = exists;
    }

    /**
     * Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.
     * 
     */
    @JsonProperty("variables")
    public Variables getVariables() {
        return variables;
    }

    /**
     * Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.
     * 
     */
    @JsonProperty("variables")
    public void setVariables(Variables variables) {
        this.variables = variables;
    }

    /**
     * Describes the conditions for when to run the job. Defaults to 'on_success'.
     * 
     */
    @JsonProperty("when")
    public Object getWhen() {
        return when;
    }

    /**
     * Describes the conditions for when to run the job. Defaults to 'on_success'.
     * 
     */
    @JsonProperty("when")
    public void setWhen(Object when) {
        this.when = when;
    }

    /**
     * Used in conjunction with 'when: delayed' to set how long to delay before starting a job.
     * 
     */
    @JsonProperty("start_in")
    public String getStartIn() {
        return startIn;
    }

    /**
     * Used in conjunction with 'when: delayed' to set how long to delay before starting a job.
     * 
     */
    @JsonProperty("start_in")
    public void setStartIn(String startIn) {
        this.startIn = startIn;
    }

    /**
     * Allow job to fail. A failed job does not cause the pipeline to fail.
     * 
     */
    @JsonProperty("allow_failure")
    public Object getAllowFailure() {
        return allowFailure;
    }

    /**
     * Allow job to fail. A failed job does not cause the pipeline to fail.
     * 
     */
    @JsonProperty("allow_failure")
    public void setAllowFailure(Object allowFailure) {
        this.allowFailure = allowFailure;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Rule__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_if");
        sb.append('=');
        sb.append(((this._if == null)?"<null>":this._if));
        sb.append(',');
        sb.append("changes");
        sb.append('=');
        sb.append(((this.changes == null)?"<null>":this.changes));
        sb.append(',');
        sb.append("exists");
        sb.append('=');
        sb.append(((this.exists == null)?"<null>":this.exists));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
        sb.append(',');
        sb.append("when");
        sb.append('=');
        sb.append(((this.when == null)?"<null>":this.when));
        sb.append(',');
        sb.append("startIn");
        sb.append('=');
        sb.append(((this.startIn == null)?"<null>":this.startIn));
        sb.append(',');
        sb.append("allowFailure");
        sb.append('=');
        sb.append(((this.allowFailure == null)?"<null>":this.allowFailure));
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
        result = ((result* 31)+((this.variables == null)? 0 :this.variables.hashCode()));
        result = ((result* 31)+((this.allowFailure == null)? 0 :this.allowFailure.hashCode()));
        result = ((result* 31)+((this.changes == null)? 0 :this.changes.hashCode()));
        result = ((result* 31)+((this.exists == null)? 0 :this.exists.hashCode()));
        result = ((result* 31)+((this.startIn == null)? 0 :this.startIn.hashCode()));
        result = ((result* 31)+((this._if == null)? 0 :this._if.hashCode()));
        result = ((result* 31)+((this.when == null)? 0 :this.when.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rule__2) == false) {
            return false;
        }
        Rule__2 rhs = ((Rule__2) other);
        return ((((((((this.variables == rhs.variables)||((this.variables!= null)&&this.variables.equals(rhs.variables)))&&((this.allowFailure == rhs.allowFailure)||((this.allowFailure!= null)&&this.allowFailure.equals(rhs.allowFailure))))&&((this.changes == rhs.changes)||((this.changes!= null)&&this.changes.equals(rhs.changes))))&&((this.exists == rhs.exists)||((this.exists!= null)&&this.exists.equals(rhs.exists))))&&((this.startIn == rhs.startIn)||((this.startIn!= null)&&this.startIn.equals(rhs.startIn))))&&((this._if == rhs._if)||((this._if!= null)&&this._if.equals(rhs._if))))&&((this.when == rhs.when)||((this.when!= null)&&this.when.equals(rhs.when))));
    }

}
