package com.smartclide.pipeline_converter.input.gitlab.model;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "url",
    "filepath",
    "link_type"
})
@Generated("jsonschema2pojo")
public class Link {

    /**
     * The name of the link.
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The name of the link.")
    private String name;
    /**
     * The URL to download a file.
     * (Required)
     * 
     */
    @JsonProperty("url")
    @JsonPropertyDescription("The URL to download a file.")
    private String url;
    /**
     * The redirect link to the url.
     * 
     */
    @JsonProperty("filepath")
    @JsonPropertyDescription("The redirect link to the url.")
    private String filepath;
    /**
     * The content kind of what users can download via url.
     * 
     */
    @JsonProperty("link_type")
    @JsonPropertyDescription("The content kind of what users can download via url.")
    private Link.LinkType linkType;

    /**
     * The name of the link.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The name of the link.
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The URL to download a file.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * The URL to download a file.
     * (Required)
     * 
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The redirect link to the url.
     * 
     */
    @JsonProperty("filepath")
    public String getFilepath() {
        return filepath;
    }

    /**
     * The redirect link to the url.
     * 
     */
    @JsonProperty("filepath")
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * The content kind of what users can download via url.
     * 
     */
    @JsonProperty("link_type")
    public Link.LinkType getLinkType() {
        return linkType;
    }

    /**
     * The content kind of what users can download via url.
     * 
     */
    @JsonProperty("link_type")
    public void setLinkType(Link.LinkType linkType) {
        this.linkType = linkType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Link.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("filepath");
        sb.append('=');
        sb.append(((this.filepath == null)?"<null>":this.filepath));
        sb.append(',');
        sb.append("linkType");
        sb.append('=');
        sb.append(((this.linkType == null)?"<null>":this.linkType));
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
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.linkType == null)? 0 :this.linkType.hashCode()));
        result = ((result* 31)+((this.filepath == null)? 0 :this.filepath.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Link) == false) {
            return false;
        }
        Link rhs = ((Link) other);
        return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.linkType == rhs.linkType)||((this.linkType!= null)&&this.linkType.equals(rhs.linkType))))&&((this.filepath == rhs.filepath)||((this.filepath!= null)&&this.filepath.equals(rhs.filepath))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))));
    }


    /**
     * The content kind of what users can download via url.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum LinkType {

        RUNBOOK("runbook"),
        PACKAGE("package"),
        IMAGE("image"),
        OTHER("other");
        private final String value;
        private final static Map<String, Link.LinkType> CONSTANTS = new HashMap<String, Link.LinkType>();

        static {
            for (Link.LinkType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        LinkType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Link.LinkType fromValue(String value) {
            Link.LinkType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
