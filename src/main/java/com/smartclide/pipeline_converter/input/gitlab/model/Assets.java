package com.smartclide.pipeline_converter.input.gitlab.model;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "links"
})
@Generated("jsonschema2pojo")
public class Assets {

    /**
     * Include asset links in the release.
     * (Required)
     * 
     */
    @JsonProperty("links")
    @JsonPropertyDescription("Include asset links in the release.")
    private List<Link> links = new ArrayList<Link>();

    /**
     * Include asset links in the release.
     * (Required)
     * 
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * Include asset links in the release.
     * (Required)
     * 
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Assets.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
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
        result = ((result* 31)+((this.links == null)? 0 :this.links.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Assets) == false) {
            return false;
        }
        Assets rhs = ((Assets) other);
        return ((this.links == rhs.links)||((this.links!= null)&&this.links.equals(rhs.links)));
    }

}
