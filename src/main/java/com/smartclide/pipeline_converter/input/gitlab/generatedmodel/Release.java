package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Indicates that the job creates a Release.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tag_name",
    "description",
    "name",
    "ref",
    "milestones",
    "released_at",
    "assets"
})
@Generated("jsonschema2pojo")
public class Release {

    /**
     * The tag_name must be specified. It can refer to an existing Git tag or can be specified by the user.
     * (Required)
     * 
     */
    @JsonProperty("tag_name")
    @JsonPropertyDescription("The tag_name must be specified. It can refer to an existing Git tag or can be specified by the user.")
    private String tagName;
    /**
     * Specifies the longer description of the Release.
     * (Required)
     * 
     */
    @JsonProperty("description")
    @JsonPropertyDescription("Specifies the longer description of the Release.")
    private String description;
    /**
     * The Release name. If omitted, it is populated with the value of release: tag_name.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The Release name. If omitted, it is populated with the value of release: tag_name.")
    private String name;
    /**
     * If the release: tag_name doesn’t exist yet, the release is created from ref. ref can be a commit SHA, another tag name, or a branch name.
     * 
     */
    @JsonProperty("ref")
    @JsonPropertyDescription("If the release: tag_name doesn\u2019t exist yet, the release is created from ref. ref can be a commit SHA, another tag name, or a branch name.")
    private String ref;
    /**
     * The title of each milestone the release is associated with.
     * 
     */
    @JsonProperty("milestones")
    @JsonPropertyDescription("The title of each milestone the release is associated with.")
    private List<String> milestones = new ArrayList<String>();
    /**
     * The date and time when the release is ready. Defaults to the current date and time if not defined. Should be enclosed in quotes and expressed in ISO 8601 format.
     * 
     */
    @JsonProperty("released_at")
    @JsonPropertyDescription("The date and time when the release is ready. Defaults to the current date and time if not defined. Should be enclosed in quotes and expressed in ISO 8601 format.")
    private Date releasedAt;
    @JsonProperty("assets")
    private Assets assets;

    /**
     * The tag_name must be specified. It can refer to an existing Git tag or can be specified by the user.
     * (Required)
     * 
     */
    @JsonProperty("tag_name")
    public String getTagName() {
        return tagName;
    }

    /**
     * The tag_name must be specified. It can refer to an existing Git tag or can be specified by the user.
     * (Required)
     * 
     */
    @JsonProperty("tag_name")
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * Specifies the longer description of the Release.
     * (Required)
     * 
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Specifies the longer description of the Release.
     * (Required)
     * 
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The Release name. If omitted, it is populated with the value of release: tag_name.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The Release name. If omitted, it is populated with the value of release: tag_name.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * If the release: tag_name doesn’t exist yet, the release is created from ref. ref can be a commit SHA, another tag name, or a branch name.
     * 
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * If the release: tag_name doesn’t exist yet, the release is created from ref. ref can be a commit SHA, another tag name, or a branch name.
     * 
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * The title of each milestone the release is associated with.
     * 
     */
    @JsonProperty("milestones")
    public List<String> getMilestones() {
        return milestones;
    }

    /**
     * The title of each milestone the release is associated with.
     * 
     */
    @JsonProperty("milestones")
    public void setMilestones(List<String> milestones) {
        this.milestones = milestones;
    }

    /**
     * The date and time when the release is ready. Defaults to the current date and time if not defined. Should be enclosed in quotes and expressed in ISO 8601 format.
     * 
     */
    @JsonProperty("released_at")
    public Date getReleasedAt() {
        return releasedAt;
    }

    /**
     * The date and time when the release is ready. Defaults to the current date and time if not defined. Should be enclosed in quotes and expressed in ISO 8601 format.
     * 
     */
    @JsonProperty("released_at")
    public void setReleasedAt(Date releasedAt) {
        this.releasedAt = releasedAt;
    }

    @JsonProperty("assets")
    public Assets getAssets() {
        return assets;
    }

    @JsonProperty("assets")
    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Release.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("tagName");
        sb.append('=');
        sb.append(((this.tagName == null)?"<null>":this.tagName));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("ref");
        sb.append('=');
        sb.append(((this.ref == null)?"<null>":this.ref));
        sb.append(',');
        sb.append("milestones");
        sb.append('=');
        sb.append(((this.milestones == null)?"<null>":this.milestones));
        sb.append(',');
        sb.append("releasedAt");
        sb.append('=');
        sb.append(((this.releasedAt == null)?"<null>":this.releasedAt));
        sb.append(',');
        sb.append("assets");
        sb.append('=');
        sb.append(((this.assets == null)?"<null>":this.assets));
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
        result = ((result* 31)+((this.ref == null)? 0 :this.ref.hashCode()));
        result = ((result* 31)+((this.releasedAt == null)? 0 :this.releasedAt.hashCode()));
        result = ((result* 31)+((this.assets == null)? 0 :this.assets.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.tagName == null)? 0 :this.tagName.hashCode()));
        result = ((result* 31)+((this.milestones == null)? 0 :this.milestones.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Release) == false) {
            return false;
        }
        Release rhs = ((Release) other);
        return ((((((((this.ref == rhs.ref)||((this.ref!= null)&&this.ref.equals(rhs.ref)))&&((this.releasedAt == rhs.releasedAt)||((this.releasedAt!= null)&&this.releasedAt.equals(rhs.releasedAt))))&&((this.assets == rhs.assets)||((this.assets!= null)&&this.assets.equals(rhs.assets))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.tagName == rhs.tagName)||((this.tagName!= null)&&this.tagName.equals(rhs.tagName))))&&((this.milestones == rhs.milestones)||((this.milestones!= null)&&this.milestones.equals(rhs.milestones))));
    }

}
