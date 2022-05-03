package com.smartclide.pipeline_converter.input.gitlab.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.
 * 
 */
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
@JsonPropertyOrder({
    "paths",
    "exclude",
    "expose_as",
    "name",
    "untracked",
    "when",
    "expire_in",
    "reports"
})
public class Artifacts {

    /**
     * A list of paths to files/folders that should be included in the artifact.
     * 
     */
    @JsonProperty("paths")
    @JsonPropertyDescription("A list of paths to files/folders that should be included in the artifact.")
    private List<String> paths = new ArrayList<String>();
    /**
     * A list of paths to files/folders that should be excluded in the artifact.
     * 
     */
    @JsonProperty("exclude")
    @JsonPropertyDescription("A list of paths to files/folders that should be excluded in the artifact.")
    private List<String> exclude = new ArrayList<String>();
    /**
     * Can be used to expose job artifacts in the merge request UI. GitLab will add a link <expose_as> to the relevant merge request that points to the artifact.
     * 
     */
    @JsonProperty("expose_as")
    @JsonPropertyDescription("Can be used to expose job artifacts in the merge request UI. GitLab will add a link <expose_as> to the relevant merge request that points to the artifact.")
    private String exposeAs;
    /**
     * Name for the archive created on job success. Can use variables in the name, e.g. '$CI_JOB_NAME'
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name for the archive created on job success. Can use variables in the name, e.g. '$CI_JOB_NAME'")
    private String name;
    /**
     * Whether to add all untracked files (along with 'artifacts.paths') to the artifact.
     * 
     */
    @JsonProperty("untracked")
    @JsonPropertyDescription("Whether to add all untracked files (along with 'artifacts.paths') to the artifact.")
    private Boolean untracked = false;
    /**
     * Configure when artifacts are uploaded depended on job status.
     * 
     */
    @JsonProperty("when")
    @JsonPropertyDescription("Configure when artifacts are uploaded depended on job status.")
    private ArtifactUploadConditions when = null;
    /**
     * How long artifacts should be kept. They are saved 30 days by default. Artifacts that have expired are removed periodically via cron job. Supports a wide variety of formats, e.g. '1 week', '3 mins 4 sec', '2 hrs 20 min', '2h20min', '6 mos 1 day', '47 yrs 6 mos and 4d', '3 weeks and 2 days'.
     * 
     */
    @JsonProperty("expire_in")
    @JsonPropertyDescription("How long artifacts should be kept. They are saved 30 days by default. Artifacts that have expired are removed periodically via cron job. Supports a wide variety of formats, e.g. '1 week', '3 mins 4 sec', '2 hrs 20 min', '2h20min', '6 mos 1 day', '47 yrs 6 mos and 4d', '3 weeks and 2 days'.")
    private String expireIn = "30 days";
    /**
     * Reports will be uploaded as artifacts, and often displayed in the Gitlab UI, such as in Merge Requests.
     * 
     */
    @JsonProperty("reports")
    @JsonPropertyDescription("Reports will be uploaded as artifacts, and often displayed in the Gitlab UI, such as in Merge Requests.")
    private Reports reports;

    /**
     * A list of paths to files/folders that should be included in the artifact.
     * 
     */
    @JsonProperty("paths")
    public List<String> getPaths() {
        return paths;
    }

    /**
     * A list of paths to files/folders that should be included in the artifact.
     * 
     */
    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    /**
     * A list of paths to files/folders that should be excluded in the artifact.
     * 
     */
    @JsonProperty("exclude")
    public List<String> getExclude() {
        return exclude;
    }

    /**
     * A list of paths to files/folders that should be excluded in the artifact.
     * 
     */
    @JsonProperty("exclude")
    public void setExclude(List<String> exclude) {
        this.exclude = exclude;
    }

    /**
     * Can be used to expose job artifacts in the merge request UI. GitLab will add a link <expose_as> to the relevant merge request that points to the artifact.
     * 
     */
    @JsonProperty("expose_as")
    public String getExposeAs() {
        return exposeAs;
    }

    /**
     * Can be used to expose job artifacts in the merge request UI. GitLab will add a link <expose_as> to the relevant merge request that points to the artifact.
     * 
     */
    @JsonProperty("expose_as")
    public void setExposeAs(String exposeAs) {
        this.exposeAs = exposeAs;
    }

    /**
     * Name for the archive created on job success. Can use variables in the name, e.g. '$CI_JOB_NAME'
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name for the archive created on job success. Can use variables in the name, e.g. '$CI_JOB_NAME'
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Whether to add all untracked files (along with 'artifacts.paths') to the artifact.
     * 
     */
    @JsonProperty("untracked")
    public Boolean getUntracked() {
        return untracked;
    }

    /**
     * Whether to add all untracked files (along with 'artifacts.paths') to the artifact.
     * 
     */
    @JsonProperty("untracked")
    public void setUntracked(Boolean untracked) {
        this.untracked = untracked;
    }

    /**
     * Configure when artifacts are uploaded depended on job status.
     * 
     */
    @JsonProperty("when")
    public ArtifactUploadConditions getWhen() {
        return when;
    }

    /**
     * Configure when artifacts are uploaded depended on job status.
     * 
     */
    @JsonProperty("when")
    public void setWhen(ArtifactUploadConditions when) {
        this.when = when;
    }

    /**
     * How long artifacts should be kept. They are saved 30 days by default. Artifacts that have expired are removed periodically via cron job. Supports a wide variety of formats, e.g. '1 week', '3 mins 4 sec', '2 hrs 20 min', '2h20min', '6 mos 1 day', '47 yrs 6 mos and 4d', '3 weeks and 2 days'.
     * 
     */
    @JsonProperty("expire_in")
    public String getExpireIn() {
        return expireIn;
    }

    /**
     * How long artifacts should be kept. They are saved 30 days by default. Artifacts that have expired are removed periodically via cron job. Supports a wide variety of formats, e.g. '1 week', '3 mins 4 sec', '2 hrs 20 min', '2h20min', '6 mos 1 day', '47 yrs 6 mos and 4d', '3 weeks and 2 days'.
     * 
     */
    @JsonProperty("expire_in")
    public void setExpireIn(String expireIn) {
        this.expireIn = expireIn;
    }

    /**
     * Reports will be uploaded as artifacts, and often displayed in the Gitlab UI, such as in Merge Requests.
     * 
     */
    @JsonProperty("reports")
    public Reports getReports() {
        return reports;
    }

    /**
     * Reports will be uploaded as artifacts, and often displayed in the Gitlab UI, such as in Merge Requests.
     * 
     */
    @JsonProperty("reports")
    public void setReports(Reports reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Artifacts.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("paths");
        sb.append('=');
        sb.append(((this.paths == null)?"<null>":this.paths));
        sb.append(',');
        sb.append("exclude");
        sb.append('=');
        sb.append(((this.exclude == null)?"<null>":this.exclude));
        sb.append(',');
        sb.append("exposeAs");
        sb.append('=');
        sb.append(((this.exposeAs == null)?"<null>":this.exposeAs));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("untracked");
        sb.append('=');
        sb.append(((this.untracked == null)?"<null>":this.untracked));
        sb.append(',');
        sb.append("when");
        sb.append('=');
        sb.append(((this.when == null)?"<null>":this.when));
        sb.append(',');
        sb.append("expireIn");
        sb.append('=');
        sb.append(((this.expireIn == null)?"<null>":this.expireIn));
        sb.append(',');
        sb.append("reports");
        sb.append('=');
        sb.append(((this.reports == null)?"<null>":this.reports));
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
		return Objects.hash(exclude, expireIn, exposeAs, name, paths, reports, untracked, when);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artifacts other = (Artifacts) obj;
		return Objects.equals(exclude, other.exclude) && Objects.equals(expireIn, other.expireIn)
				&& Objects.equals(exposeAs, other.exposeAs) && Objects.equals(name, other.name)
				&& Objects.equals(paths, other.paths) && Objects.equals(reports, other.reports)
				&& Objects.equals(untracked, other.untracked) && when == other.when;
	}

}
