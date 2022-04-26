package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Reports will be uploaded as artifacts, and often displayed in the Gitlab UI, such as in Merge Requests.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "junit",
    "cobertura",
    "codequality",
    "dotenv",
    "lsif",
    "sast",
    "dependency_scanning",
    "container_scanning",
    "dast",
    "license_management",
    "license_scanning",
    "performance",
    "requirements",
    "secret_detection",
    "metrics",
    "terraform"
})
@Generated("jsonschema2pojo")
public class Reports {

    /**
     * Path for file(s) that should be parsed as JUnit XML result
     * 
     */
    @JsonProperty("junit")
    @JsonPropertyDescription("Path for file(s) that should be parsed as JUnit XML result")
    private Object junit;
    /**
     * Path for file(s) that should be parsed as Cobertura XML coverage report
     * 
     */
    @JsonProperty("cobertura")
    @JsonPropertyDescription("Path for file(s) that should be parsed as Cobertura XML coverage report")
    private Object cobertura;
    @JsonProperty("codequality")
    private Object codequality;
    @JsonProperty("dotenv")
    private Object dotenv;
    @JsonProperty("lsif")
    private Object lsif;
    @JsonProperty("sast")
    private Object sast;
    @JsonProperty("dependency_scanning")
    private Object dependencyScanning;
    @JsonProperty("container_scanning")
    private Object containerScanning;
    @JsonProperty("dast")
    private Object dast;
    @JsonProperty("license_management")
    private Object licenseManagement;
    @JsonProperty("license_scanning")
    private Object licenseScanning;
    @JsonProperty("performance")
    private Object performance;
    @JsonProperty("requirements")
    private Object requirements;
    @JsonProperty("secret_detection")
    private Object secretDetection;
    @JsonProperty("metrics")
    private Object metrics;
    @JsonProperty("terraform")
    private Object terraform;

    /**
     * Path for file(s) that should be parsed as JUnit XML result
     * 
     */
    @JsonProperty("junit")
    public Object getJunit() {
        return junit;
    }

    /**
     * Path for file(s) that should be parsed as JUnit XML result
     * 
     */
    @JsonProperty("junit")
    public void setJunit(Object junit) {
        this.junit = junit;
    }

    /**
     * Path for file(s) that should be parsed as Cobertura XML coverage report
     * 
     */
    @JsonProperty("cobertura")
    public Object getCobertura() {
        return cobertura;
    }

    /**
     * Path for file(s) that should be parsed as Cobertura XML coverage report
     * 
     */
    @JsonProperty("cobertura")
    public void setCobertura(Object cobertura) {
        this.cobertura = cobertura;
    }

    @JsonProperty("codequality")
    public Object getCodequality() {
        return codequality;
    }

    @JsonProperty("codequality")
    public void setCodequality(Object codequality) {
        this.codequality = codequality;
    }

    @JsonProperty("dotenv")
    public Object getDotenv() {
        return dotenv;
    }

    @JsonProperty("dotenv")
    public void setDotenv(Object dotenv) {
        this.dotenv = dotenv;
    }

    @JsonProperty("lsif")
    public Object getLsif() {
        return lsif;
    }

    @JsonProperty("lsif")
    public void setLsif(Object lsif) {
        this.lsif = lsif;
    }

    @JsonProperty("sast")
    public Object getSast() {
        return sast;
    }

    @JsonProperty("sast")
    public void setSast(Object sast) {
        this.sast = sast;
    }

    @JsonProperty("dependency_scanning")
    public Object getDependencyScanning() {
        return dependencyScanning;
    }

    @JsonProperty("dependency_scanning")
    public void setDependencyScanning(Object dependencyScanning) {
        this.dependencyScanning = dependencyScanning;
    }

    @JsonProperty("container_scanning")
    public Object getContainerScanning() {
        return containerScanning;
    }

    @JsonProperty("container_scanning")
    public void setContainerScanning(Object containerScanning) {
        this.containerScanning = containerScanning;
    }

    @JsonProperty("dast")
    public Object getDast() {
        return dast;
    }

    @JsonProperty("dast")
    public void setDast(Object dast) {
        this.dast = dast;
    }

    @JsonProperty("license_management")
    public Object getLicenseManagement() {
        return licenseManagement;
    }

    @JsonProperty("license_management")
    public void setLicenseManagement(Object licenseManagement) {
        this.licenseManagement = licenseManagement;
    }

    @JsonProperty("license_scanning")
    public Object getLicenseScanning() {
        return licenseScanning;
    }

    @JsonProperty("license_scanning")
    public void setLicenseScanning(Object licenseScanning) {
        this.licenseScanning = licenseScanning;
    }

    @JsonProperty("performance")
    public Object getPerformance() {
        return performance;
    }

    @JsonProperty("performance")
    public void setPerformance(Object performance) {
        this.performance = performance;
    }

    @JsonProperty("requirements")
    public Object getRequirements() {
        return requirements;
    }

    @JsonProperty("requirements")
    public void setRequirements(Object requirements) {
        this.requirements = requirements;
    }

    @JsonProperty("secret_detection")
    public Object getSecretDetection() {
        return secretDetection;
    }

    @JsonProperty("secret_detection")
    public void setSecretDetection(Object secretDetection) {
        this.secretDetection = secretDetection;
    }

    @JsonProperty("metrics")
    public Object getMetrics() {
        return metrics;
    }

    @JsonProperty("metrics")
    public void setMetrics(Object metrics) {
        this.metrics = metrics;
    }

    @JsonProperty("terraform")
    public Object getTerraform() {
        return terraform;
    }

    @JsonProperty("terraform")
    public void setTerraform(Object terraform) {
        this.terraform = terraform;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reports.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("junit");
        sb.append('=');
        sb.append(((this.junit == null)?"<null>":this.junit));
        sb.append(',');
        sb.append("cobertura");
        sb.append('=');
        sb.append(((this.cobertura == null)?"<null>":this.cobertura));
        sb.append(',');
        sb.append("codequality");
        sb.append('=');
        sb.append(((this.codequality == null)?"<null>":this.codequality));
        sb.append(',');
        sb.append("dotenv");
        sb.append('=');
        sb.append(((this.dotenv == null)?"<null>":this.dotenv));
        sb.append(',');
        sb.append("lsif");
        sb.append('=');
        sb.append(((this.lsif == null)?"<null>":this.lsif));
        sb.append(',');
        sb.append("sast");
        sb.append('=');
        sb.append(((this.sast == null)?"<null>":this.sast));
        sb.append(',');
        sb.append("dependencyScanning");
        sb.append('=');
        sb.append(((this.dependencyScanning == null)?"<null>":this.dependencyScanning));
        sb.append(',');
        sb.append("containerScanning");
        sb.append('=');
        sb.append(((this.containerScanning == null)?"<null>":this.containerScanning));
        sb.append(',');
        sb.append("dast");
        sb.append('=');
        sb.append(((this.dast == null)?"<null>":this.dast));
        sb.append(',');
        sb.append("licenseManagement");
        sb.append('=');
        sb.append(((this.licenseManagement == null)?"<null>":this.licenseManagement));
        sb.append(',');
        sb.append("licenseScanning");
        sb.append('=');
        sb.append(((this.licenseScanning == null)?"<null>":this.licenseScanning));
        sb.append(',');
        sb.append("performance");
        sb.append('=');
        sb.append(((this.performance == null)?"<null>":this.performance));
        sb.append(',');
        sb.append("requirements");
        sb.append('=');
        sb.append(((this.requirements == null)?"<null>":this.requirements));
        sb.append(',');
        sb.append("secretDetection");
        sb.append('=');
        sb.append(((this.secretDetection == null)?"<null>":this.secretDetection));
        sb.append(',');
        sb.append("metrics");
        sb.append('=');
        sb.append(((this.metrics == null)?"<null>":this.metrics));
        sb.append(',');
        sb.append("terraform");
        sb.append('=');
        sb.append(((this.terraform == null)?"<null>":this.terraform));
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
        result = ((result* 31)+((this.cobertura == null)? 0 :this.cobertura.hashCode()));
        result = ((result* 31)+((this.secretDetection == null)? 0 :this.secretDetection.hashCode()));
        result = ((result* 31)+((this.junit == null)? 0 :this.junit.hashCode()));
        result = ((result* 31)+((this.requirements == null)? 0 :this.requirements.hashCode()));
        result = ((result* 31)+((this.licenseScanning == null)? 0 :this.licenseScanning.hashCode()));
        result = ((result* 31)+((this.dast == null)? 0 :this.dast.hashCode()));
        result = ((result* 31)+((this.containerScanning == null)? 0 :this.containerScanning.hashCode()));
        result = ((result* 31)+((this.licenseManagement == null)? 0 :this.licenseManagement.hashCode()));
        result = ((result* 31)+((this.dotenv == null)? 0 :this.dotenv.hashCode()));
        result = ((result* 31)+((this.performance == null)? 0 :this.performance.hashCode()));
        result = ((result* 31)+((this.lsif == null)? 0 :this.lsif.hashCode()));
        result = ((result* 31)+((this.dependencyScanning == null)? 0 :this.dependencyScanning.hashCode()));
        result = ((result* 31)+((this.codequality == null)? 0 :this.codequality.hashCode()));
        result = ((result* 31)+((this.sast == null)? 0 :this.sast.hashCode()));
        result = ((result* 31)+((this.terraform == null)? 0 :this.terraform.hashCode()));
        result = ((result* 31)+((this.metrics == null)? 0 :this.metrics.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Reports) == false) {
            return false;
        }
        Reports rhs = ((Reports) other);
        return (((((((((((((((((this.cobertura == rhs.cobertura)||((this.cobertura!= null)&&this.cobertura.equals(rhs.cobertura)))&&((this.secretDetection == rhs.secretDetection)||((this.secretDetection!= null)&&this.secretDetection.equals(rhs.secretDetection))))&&((this.junit == rhs.junit)||((this.junit!= null)&&this.junit.equals(rhs.junit))))&&((this.requirements == rhs.requirements)||((this.requirements!= null)&&this.requirements.equals(rhs.requirements))))&&((this.licenseScanning == rhs.licenseScanning)||((this.licenseScanning!= null)&&this.licenseScanning.equals(rhs.licenseScanning))))&&((this.dast == rhs.dast)||((this.dast!= null)&&this.dast.equals(rhs.dast))))&&((this.containerScanning == rhs.containerScanning)||((this.containerScanning!= null)&&this.containerScanning.equals(rhs.containerScanning))))&&((this.licenseManagement == rhs.licenseManagement)||((this.licenseManagement!= null)&&this.licenseManagement.equals(rhs.licenseManagement))))&&((this.dotenv == rhs.dotenv)||((this.dotenv!= null)&&this.dotenv.equals(rhs.dotenv))))&&((this.performance == rhs.performance)||((this.performance!= null)&&this.performance.equals(rhs.performance))))&&((this.lsif == rhs.lsif)||((this.lsif!= null)&&this.lsif.equals(rhs.lsif))))&&((this.dependencyScanning == rhs.dependencyScanning)||((this.dependencyScanning!= null)&&this.dependencyScanning.equals(rhs.dependencyScanning))))&&((this.codequality == rhs.codequality)||((this.codequality!= null)&&this.codequality.equals(rhs.codequality))))&&((this.sast == rhs.sast)||((this.sast!= null)&&this.sast.equals(rhs.sast))))&&((this.terraform == rhs.terraform)||((this.terraform!= null)&&this.terraform.equals(rhs.terraform))))&&((this.metrics == rhs.metrics)||((this.metrics!= null)&&this.metrics.equals(rhs.metrics))));
    }

}
