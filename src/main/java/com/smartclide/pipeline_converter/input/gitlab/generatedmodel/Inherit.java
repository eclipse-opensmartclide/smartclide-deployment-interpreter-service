package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Controls inheritance of globally-defined defaults and variables. Boolean values control inheritance of all default: or variables: keywords. To inherit only a subset of default: or variables: keywords, specify what you wish to inherit. Anything not listed is not inherited.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "variables"
})
@Generated("jsonschema2pojo")
public class Inherit {

    /**
     * Whether to inherit all globally-defined defaults or not. Or subset of inherited defaults
     * 
     */
    @JsonProperty("default")
    @JsonPropertyDescription("Whether to inherit all globally-defined defaults or not. Or subset of inherited defaults")
    private Object _default;
    /**
     * Whether to inherit all globally-defined variables or not. Or subset of inherited variables
     * 
     */
    @JsonProperty("variables")
    @JsonPropertyDescription("Whether to inherit all globally-defined variables or not. Or subset of inherited variables")
    private Object variables;

    /**
     * Whether to inherit all globally-defined defaults or not. Or subset of inherited defaults
     * 
     */
    @JsonProperty("default")
    public Object getDefault() {
        return _default;
    }

    /**
     * Whether to inherit all globally-defined defaults or not. Or subset of inherited defaults
     * 
     */
    @JsonProperty("default")
    public void setDefault(Object _default) {
        this._default = _default;
    }

    /**
     * Whether to inherit all globally-defined variables or not. Or subset of inherited variables
     * 
     */
    @JsonProperty("variables")
    public Object getVariables() {
        return variables;
    }

    /**
     * Whether to inherit all globally-defined variables or not. Or subset of inherited variables
     * 
     */
    @JsonProperty("variables")
    public void setVariables(Object variables) {
        this.variables = variables;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Inherit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_default");
        sb.append('=');
        sb.append(((this._default == null)?"<null>":this._default));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
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
        result = ((result* 31)+((this._default == null)? 0 :this._default.hashCode()));
        result = ((result* 31)+((this.variables == null)? 0 :this.variables.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Inherit) == false) {
            return false;
        }
        Inherit rhs = ((Inherit) other);
        return (((this._default == rhs._default)||((this._default!= null)&&this._default.equals(rhs._default)))&&((this.variables == rhs.variables)||((this.variables!= null)&&this.variables.equals(rhs.variables))));
    }

}
