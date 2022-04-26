package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
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
    "if",
    "variables",
    "when"
})
@Generated("jsonschema2pojo")
public class Rule {

    @JsonProperty("if")
    private String _if;
    /**
     * Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.
     * 
     */
    @JsonProperty("variables")
    @JsonPropertyDescription("Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.")
    private Variables variables;
    @JsonProperty("when")
    private Rule.When when;

    @JsonProperty("if")
    public String getIf() {
        return _if;
    }

    @JsonProperty("if")
    public void setIf(String _if) {
        this._if = _if;
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

    @JsonProperty("when")
    public Rule.When getWhen() {
        return when;
    }

    @JsonProperty("when")
    public void setWhen(Rule.When when) {
        this.when = when;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Rule.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_if");
        sb.append('=');
        sb.append(((this._if == null)?"<null>":this._if));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
        sb.append(',');
        sb.append("when");
        sb.append('=');
        sb.append(((this.when == null)?"<null>":this.when));
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
        result = ((result* 31)+((this._if == null)? 0 :this._if.hashCode()));
        result = ((result* 31)+((this.when == null)? 0 :this.when.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Rule) == false) {
            return false;
        }
        Rule rhs = ((Rule) other);
        return ((((this.variables == rhs.variables)||((this.variables!= null)&&this.variables.equals(rhs.variables)))&&((this._if == rhs._if)||((this._if!= null)&&this._if.equals(rhs._if))))&&((this.when == rhs.when)||((this.when!= null)&&this.when.equals(rhs.when))));
    }

    @Generated("jsonschema2pojo")
    public enum When {

        ALWAYS("always"),
        NEVER("never");
        private final String value;
        private final static Map<String, Rule.When> CONSTANTS = new HashMap<String, Rule.When>();

        static {
            for (Rule.When c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        When(String value) {
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
        public static Rule.When fromValue(String value) {
            Rule.When constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
