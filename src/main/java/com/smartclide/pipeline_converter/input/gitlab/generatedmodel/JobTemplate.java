package com.smartclide.pipeline_converter.input.gitlab.generatedmodel;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "image",
    "services",
    "before_script",
    "after_script",
    "rules",
    "variables",
    "cache",
    "secrets",
    "script",
    "stage",
    "only",
    "extends",
    "needs",
    "except",
    "tags",
    "allow_failure",
    "timeout",
    "when",
    "start_in",
    "dependencies",
    "artifacts",
    "environment",
    "release",
    "coverage",
    "retry",
    "parallel",
    "interruptible",
    "resource_group",
    "trigger",
    "inherit"
})
@Generated("jsonschema2pojo")
public class JobTemplate {

    /**
     * Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.
     * 
     */
    @JsonProperty("image")
    @JsonPropertyDescription("Specifies the docker image to use for the job or globally for all jobs. Job configuration takes precedence over global setting. Requires a certain kind of Gitlab runner executor.")
    private Object image;
    /**
     * Similar to `image` property, but will link the specified services to the `image` container.
     * 
     */
    @JsonProperty("services")
    @JsonPropertyDescription("Similar to `image` property, but will link the specified services to the `image` container.")
    private List<Object> services = new ArrayList<Object>();
    /**
     * Defines scripts that should run *before* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("before_script")
    @JsonPropertyDescription("Defines scripts that should run *before* the job. Can be set globally or per job.")
    private List<Object> beforeScript = new ArrayList<Object>();
    /**
     * Defines scripts that should run *after* the job. Can be set globally or per job.
     * 
     */
    @JsonProperty("after_script")
    @JsonPropertyDescription("Defines scripts that should run *after* the job. Can be set globally or per job.")
    private List<Object> afterScript = new ArrayList<Object>();
    /**
     * rules allows for an array of individual rule objects to be evaluated in order, until one matches and dynamically provides attributes to the job.
     * 
     */
    @JsonProperty("rules")
    @JsonPropertyDescription("rules allows for an array of individual rule objects to be evaluated in order, until one matches and dynamically provides attributes to the job.")
    private List<Rule__2> rules = new ArrayList<Rule__2>();
    /**
     * Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.
     * 
     */
    @JsonProperty("variables")
    @JsonPropertyDescription("Defines environment variables for specific jobs. Job level property overrides global variables. If a job sets `variables: {}`, all global variables are turned off.")
    private Variables variables;
    @JsonProperty("cache")
    private Object cache;
    /**
     * Defines secrets to be injected as environment variables
     * 
     */
    @JsonProperty("secrets")
    @JsonPropertyDescription("Defines secrets to be injected as environment variables")
    private Secrets__1 secrets;
    /**
     * Shell scripts executed by the Runner. The only required property of jobs. Be careful with special characters (e.g. `:`, `{`, `}`, `&`) and use single or double quotes to avoid issues.
     * 
     */
    @JsonProperty("script")
    @JsonPropertyDescription("Shell scripts executed by the Runner. The only required property of jobs. Be careful with special characters (e.g. `:`, `{`, `}`, `&`) and use single or double quotes to avoid issues.")
    private Object script;
    /**
     * Define what stage the job will run in.
     * 
     */
    @JsonProperty("stage")
    @JsonPropertyDescription("Define what stage the job will run in.")
    private String stage = "test";
    @JsonProperty("only")
    private Object only;
    /**
     * The name of one or more jobs to inherit configuration from.
     * 
     */
    @JsonProperty("extends")
    @JsonPropertyDescription("The name of one or more jobs to inherit configuration from.")
    private Object _extends;
    /**
     * The list of jobs in previous stages whose sole completion is needed to start the current job.
     * 
     */
    @JsonProperty("needs")
    @JsonPropertyDescription("The list of jobs in previous stages whose sole completion is needed to start the current job.")
    private List<Object> needs = new ArrayList<Object>();
    @JsonProperty("except")
    private Object except;
    /**
     * Used to select runners from the list of available runners. A runner must have all tags listed here to run the job.
     * 
     */
    @JsonProperty("tags")
    @JsonPropertyDescription("Used to select runners from the list of available runners. A runner must have all tags listed here to run the job.")
    private List<String> tags = new ArrayList<String>();
    /**
     * Allow job to fail. A failed job does not cause the pipeline to fail.
     * 
     */
    @JsonProperty("allow_failure")
    @JsonPropertyDescription("Allow job to fail. A failed job does not cause the pipeline to fail.")
    private Object allowFailure;
    /**
     * Allows you to configure a timeout for a specific job (e.g. `1 minute`, `1h 30m 12s`). Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#timeout
     * 
     */
    @JsonProperty("timeout")
    @JsonPropertyDescription("Allows you to configure a timeout for a specific job (e.g. `1 minute`, `1h 30m 12s`). Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#timeout")
    private String timeout;
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
     * Specify a list of job names from earlier stages from which artifacts should be loaded. By default, all previous artifacts are passed. Use an empty array to skip downloading artifacts.
     * 
     */
    @JsonProperty("dependencies")
    @JsonPropertyDescription("Specify a list of job names from earlier stages from which artifacts should be loaded. By default, all previous artifacts are passed. Use an empty array to skip downloading artifacts.")
    private List<String> dependencies = new ArrayList<String>();
    /**
     * Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.
     * 
     */
    @JsonProperty("artifacts")
    @JsonPropertyDescription("Used to specify a list of files and directories that should be attached to the job if it succeeds. Artifacts are sent to Gitlab where they can be downloaded.")
    private Artifacts artifacts;
    /**
     * Used to associate environment metadata with a deploy. Environment can have a name and URL attached to it, and will be displayed under /environments under the project.
     * 
     */
    @JsonProperty("environment")
    @JsonPropertyDescription("Used to associate environment metadata with a deploy. Environment can have a name and URL attached to it, and will be displayed under /environments under the project.")
    private Object environment;
    /**
     * Indicates that the job creates a Release.
     * 
     */
    @JsonProperty("release")
    @JsonPropertyDescription("Indicates that the job creates a Release.")
    private Release release;
    /**
     * Must be a regular expression, optionally but recommended to be quoted, and must be surrounded with '/'. Example: '/Code coverage: \d+\.\d+/'
     * 
     */
    @JsonProperty("coverage")
    @JsonPropertyDescription("Must be a regular expression, optionally but recommended to be quoted, and must be surrounded with '/'. Example: '/Code coverage: \\d+\\.\\d+/'")
    private Pattern coverage;
    /**
     * Retry a job if it fails. Can be a simple integer or object definition.
     * 
     */
    @JsonProperty("retry")
    @JsonPropertyDescription("Retry a job if it fails. Can be a simple integer or object definition.")
    private Object retry;
    /**
     * Parallel will split up a single job into several, and provide `CI_NODE_INDEX` and `CI_NODE_TOTAL` environment variables for the running jobs.
     * 
     */
    @JsonProperty("parallel")
    @JsonPropertyDescription("Parallel will split up a single job into several, and provide `CI_NODE_INDEX` and `CI_NODE_TOTAL` environment variables for the running jobs.")
    private Object parallel;
    /**
     * Interruptible is used to indicate that a job should be canceled if made redundant by a newer pipeline run.
     * 
     */
    @JsonProperty("interruptible")
    @JsonPropertyDescription("Interruptible is used to indicate that a job should be canceled if made redundant by a newer pipeline run.")
    private Boolean interruptible = false;
    /**
     * Limit job concurrency. Can be used to ensure that the Runner will not run certain jobs simultaneously.
     * 
     */
    @JsonProperty("resource_group")
    @JsonPropertyDescription("Limit job concurrency. Can be used to ensure that the Runner will not run certain jobs simultaneously.")
    private String resourceGroup;
    /**
     * Trigger allows you to define downstream pipeline trigger. When a job created from trigger definition is started by GitLab, a downstream pipeline gets created. Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#trigger
     * 
     */
    @JsonProperty("trigger")
    @JsonPropertyDescription("Trigger allows you to define downstream pipeline trigger. When a job created from trigger definition is started by GitLab, a downstream pipeline gets created. Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#trigger")
    private Object trigger;
    /**
     * Controls inheritance of globally-defined defaults and variables. Boolean values control inheritance of all default: or variables: keywords. To inherit only a subset of default: or variables: keywords, specify what you wish to inherit. Anything not listed is not inherited.
     * 
     */
    @JsonProperty("inherit")
    @JsonPropertyDescription("Controls inheritance of globally-defined defaults and variables. Boolean values control inheritance of all default: or variables: keywords. To inherit only a subset of default: or variables: keywords, specify what you wish to inherit. Anything not listed is not inherited.")
    private Inherit inherit;

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
     * rules allows for an array of individual rule objects to be evaluated in order, until one matches and dynamically provides attributes to the job.
     * 
     */
    @JsonProperty("rules")
    public List<Rule__2> getRules() {
        return rules;
    }

    /**
     * rules allows for an array of individual rule objects to be evaluated in order, until one matches and dynamically provides attributes to the job.
     * 
     */
    @JsonProperty("rules")
    public void setRules(List<Rule__2> rules) {
        this.rules = rules;
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

    @JsonProperty("cache")
    public Object getCache() {
        return cache;
    }

    @JsonProperty("cache")
    public void setCache(Object cache) {
        this.cache = cache;
    }

    /**
     * Defines secrets to be injected as environment variables
     * 
     */
    @JsonProperty("secrets")
    public Secrets__1 getSecrets() {
        return secrets;
    }

    /**
     * Defines secrets to be injected as environment variables
     * 
     */
    @JsonProperty("secrets")
    public void setSecrets(Secrets__1 secrets) {
        this.secrets = secrets;
    }

    /**
     * Shell scripts executed by the Runner. The only required property of jobs. Be careful with special characters (e.g. `:`, `{`, `}`, `&`) and use single or double quotes to avoid issues.
     * 
     */
    @JsonProperty("script")
    public Object getScript() {
        return script;
    }

    /**
     * Shell scripts executed by the Runner. The only required property of jobs. Be careful with special characters (e.g. `:`, `{`, `}`, `&`) and use single or double quotes to avoid issues.
     * 
     */
    @JsonProperty("script")
    public void setScript(Object script) {
        this.script = script;
    }

    /**
     * Define what stage the job will run in.
     * 
     */
    @JsonProperty("stage")
    public String getStage() {
        return stage;
    }

    /**
     * Define what stage the job will run in.
     * 
     */
    @JsonProperty("stage")
    public void setStage(String stage) {
        this.stage = stage;
    }

    @JsonProperty("only")
    public Object getOnly() {
        return only;
    }

    @JsonProperty("only")
    public void setOnly(Object only) {
        this.only = only;
    }

    /**
     * The name of one or more jobs to inherit configuration from.
     * 
     */
    @JsonProperty("extends")
    public Object getExtends() {
        return _extends;
    }

    /**
     * The name of one or more jobs to inherit configuration from.
     * 
     */
    @JsonProperty("extends")
    public void setExtends(Object _extends) {
        this._extends = _extends;
    }

    /**
     * The list of jobs in previous stages whose sole completion is needed to start the current job.
     * 
     */
    @JsonProperty("needs")
    public List<Object> getNeeds() {
        return needs;
    }

    /**
     * The list of jobs in previous stages whose sole completion is needed to start the current job.
     * 
     */
    @JsonProperty("needs")
    public void setNeeds(List<Object> needs) {
        this.needs = needs;
    }

    @JsonProperty("except")
    public Object getExcept() {
        return except;
    }

    @JsonProperty("except")
    public void setExcept(Object except) {
        this.except = except;
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
     * Specify a list of job names from earlier stages from which artifacts should be loaded. By default, all previous artifacts are passed. Use an empty array to skip downloading artifacts.
     * 
     */
    @JsonProperty("dependencies")
    public List<String> getDependencies() {
        return dependencies;
    }

    /**
     * Specify a list of job names from earlier stages from which artifacts should be loaded. By default, all previous artifacts are passed. Use an empty array to skip downloading artifacts.
     * 
     */
    @JsonProperty("dependencies")
    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
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
     * Used to associate environment metadata with a deploy. Environment can have a name and URL attached to it, and will be displayed under /environments under the project.
     * 
     */
    @JsonProperty("environment")
    public Object getEnvironment() {
        return environment;
    }

    /**
     * Used to associate environment metadata with a deploy. Environment can have a name and URL attached to it, and will be displayed under /environments under the project.
     * 
     */
    @JsonProperty("environment")
    public void setEnvironment(Object environment) {
        this.environment = environment;
    }

    /**
     * Indicates that the job creates a Release.
     * 
     */
    @JsonProperty("release")
    public Release getRelease() {
        return release;
    }

    /**
     * Indicates that the job creates a Release.
     * 
     */
    @JsonProperty("release")
    public void setRelease(Release release) {
        this.release = release;
    }

    /**
     * Must be a regular expression, optionally but recommended to be quoted, and must be surrounded with '/'. Example: '/Code coverage: \d+\.\d+/'
     * 
     */
    @JsonProperty("coverage")
    public Pattern getCoverage() {
        return coverage;
    }

    /**
     * Must be a regular expression, optionally but recommended to be quoted, and must be surrounded with '/'. Example: '/Code coverage: \d+\.\d+/'
     * 
     */
    @JsonProperty("coverage")
    public void setCoverage(Pattern coverage) {
        this.coverage = coverage;
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
     * Parallel will split up a single job into several, and provide `CI_NODE_INDEX` and `CI_NODE_TOTAL` environment variables for the running jobs.
     * 
     */
    @JsonProperty("parallel")
    public Object getParallel() {
        return parallel;
    }

    /**
     * Parallel will split up a single job into several, and provide `CI_NODE_INDEX` and `CI_NODE_TOTAL` environment variables for the running jobs.
     * 
     */
    @JsonProperty("parallel")
    public void setParallel(Object parallel) {
        this.parallel = parallel;
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
     * Limit job concurrency. Can be used to ensure that the Runner will not run certain jobs simultaneously.
     * 
     */
    @JsonProperty("resource_group")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * Limit job concurrency. Can be used to ensure that the Runner will not run certain jobs simultaneously.
     * 
     */
    @JsonProperty("resource_group")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * Trigger allows you to define downstream pipeline trigger. When a job created from trigger definition is started by GitLab, a downstream pipeline gets created. Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#trigger
     * 
     */
    @JsonProperty("trigger")
    public Object getTrigger() {
        return trigger;
    }

    /**
     * Trigger allows you to define downstream pipeline trigger. When a job created from trigger definition is started by GitLab, a downstream pipeline gets created. Read more: https://docs.gitlab.com/ee/ci/yaml/README.html#trigger
     * 
     */
    @JsonProperty("trigger")
    public void setTrigger(Object trigger) {
        this.trigger = trigger;
    }

    /**
     * Controls inheritance of globally-defined defaults and variables. Boolean values control inheritance of all default: or variables: keywords. To inherit only a subset of default: or variables: keywords, specify what you wish to inherit. Anything not listed is not inherited.
     * 
     */
    @JsonProperty("inherit")
    public Inherit getInherit() {
        return inherit;
    }

    /**
     * Controls inheritance of globally-defined defaults and variables. Boolean values control inheritance of all default: or variables: keywords. To inherit only a subset of default: or variables: keywords, specify what you wish to inherit. Anything not listed is not inherited.
     * 
     */
    @JsonProperty("inherit")
    public void setInherit(Inherit inherit) {
        this.inherit = inherit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(JobTemplate.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null)?"<null>":this.image));
        sb.append(',');
        sb.append("services");
        sb.append('=');
        sb.append(((this.services == null)?"<null>":this.services));
        sb.append(',');
        sb.append("beforeScript");
        sb.append('=');
        sb.append(((this.beforeScript == null)?"<null>":this.beforeScript));
        sb.append(',');
        sb.append("afterScript");
        sb.append('=');
        sb.append(((this.afterScript == null)?"<null>":this.afterScript));
        sb.append(',');
        sb.append("rules");
        sb.append('=');
        sb.append(((this.rules == null)?"<null>":this.rules));
        sb.append(',');
        sb.append("variables");
        sb.append('=');
        sb.append(((this.variables == null)?"<null>":this.variables));
        sb.append(',');
        sb.append("cache");
        sb.append('=');
        sb.append(((this.cache == null)?"<null>":this.cache));
        sb.append(',');
        sb.append("secrets");
        sb.append('=');
        sb.append(((this.secrets == null)?"<null>":this.secrets));
        sb.append(',');
        sb.append("script");
        sb.append('=');
        sb.append(((this.script == null)?"<null>":this.script));
        sb.append(',');
        sb.append("stage");
        sb.append('=');
        sb.append(((this.stage == null)?"<null>":this.stage));
        sb.append(',');
        sb.append("only");
        sb.append('=');
        sb.append(((this.only == null)?"<null>":this.only));
        sb.append(',');
        sb.append("_extends");
        sb.append('=');
        sb.append(((this._extends == null)?"<null>":this._extends));
        sb.append(',');
        sb.append("needs");
        sb.append('=');
        sb.append(((this.needs == null)?"<null>":this.needs));
        sb.append(',');
        sb.append("except");
        sb.append('=');
        sb.append(((this.except == null)?"<null>":this.except));
        sb.append(',');
        sb.append("tags");
        sb.append('=');
        sb.append(((this.tags == null)?"<null>":this.tags));
        sb.append(',');
        sb.append("allowFailure");
        sb.append('=');
        sb.append(((this.allowFailure == null)?"<null>":this.allowFailure));
        sb.append(',');
        sb.append("timeout");
        sb.append('=');
        sb.append(((this.timeout == null)?"<null>":this.timeout));
        sb.append(',');
        sb.append("when");
        sb.append('=');
        sb.append(((this.when == null)?"<null>":this.when));
        sb.append(',');
        sb.append("startIn");
        sb.append('=');
        sb.append(((this.startIn == null)?"<null>":this.startIn));
        sb.append(',');
        sb.append("dependencies");
        sb.append('=');
        sb.append(((this.dependencies == null)?"<null>":this.dependencies));
        sb.append(',');
        sb.append("artifacts");
        sb.append('=');
        sb.append(((this.artifacts == null)?"<null>":this.artifacts));
        sb.append(',');
        sb.append("environment");
        sb.append('=');
        sb.append(((this.environment == null)?"<null>":this.environment));
        sb.append(',');
        sb.append("release");
        sb.append('=');
        sb.append(((this.release == null)?"<null>":this.release));
        sb.append(',');
        sb.append("coverage");
        sb.append('=');
        sb.append(((this.coverage == null)?"<null>":this.coverage));
        sb.append(',');
        sb.append("retry");
        sb.append('=');
        sb.append(((this.retry == null)?"<null>":this.retry));
        sb.append(',');
        sb.append("parallel");
        sb.append('=');
        sb.append(((this.parallel == null)?"<null>":this.parallel));
        sb.append(',');
        sb.append("interruptible");
        sb.append('=');
        sb.append(((this.interruptible == null)?"<null>":this.interruptible));
        sb.append(',');
        sb.append("resourceGroup");
        sb.append('=');
        sb.append(((this.resourceGroup == null)?"<null>":this.resourceGroup));
        sb.append(',');
        sb.append("trigger");
        sb.append('=');
        sb.append(((this.trigger == null)?"<null>":this.trigger));
        sb.append(',');
        sb.append("inherit");
        sb.append('=');
        sb.append(((this.inherit == null)?"<null>":this.inherit));
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
        result = ((result* 31)+((this.resourceGroup == null)? 0 :this.resourceGroup.hashCode()));
        result = ((result* 31)+((this.release == null)? 0 :this.release.hashCode()));
        result = ((result* 31)+((this.rules == null)? 0 :this.rules.hashCode()));
        result = ((result* 31)+((this.startIn == null)? 0 :this.startIn.hashCode()));
        result = ((result* 31)+((this.when == null)? 0 :this.when.hashCode()));
        result = ((result* 31)+((this.timeout == null)? 0 :this.timeout.hashCode()));
        result = ((result* 31)+((this.allowFailure == null)? 0 :this.allowFailure.hashCode()));
        result = ((result* 31)+((this.afterScript == null)? 0 :this.afterScript.hashCode()));
        result = ((result* 31)+((this.parallel == null)? 0 :this.parallel.hashCode()));
        result = ((result* 31)+((this.only == null)? 0 :this.only.hashCode()));
        result = ((result* 31)+((this.retry == null)? 0 :this.retry.hashCode()));
        result = ((result* 31)+((this.artifacts == null)? 0 :this.artifacts.hashCode()));
        result = ((result* 31)+((this.needs == null)? 0 :this.needs.hashCode()));
        result = ((result* 31)+((this.coverage == null)? 0 :this.coverage.hashCode()));
        result = ((result* 31)+((this.image == null)? 0 :this.image.hashCode()));
        result = ((result* 31)+((this.variables == null)? 0 :this.variables.hashCode()));
        result = ((result* 31)+((this.cache == null)? 0 :this.cache.hashCode()));
        result = ((result* 31)+((this._extends == null)? 0 :this._extends.hashCode()));
        result = ((result* 31)+((this.services == null)? 0 :this.services.hashCode()));
        result = ((result* 31)+((this.trigger == null)? 0 :this.trigger.hashCode()));
        result = ((result* 31)+((this.secrets == null)? 0 :this.secrets.hashCode()));
        result = ((result* 31)+((this.interruptible == null)? 0 :this.interruptible.hashCode()));
        result = ((result* 31)+((this.script == null)? 0 :this.script.hashCode()));
        result = ((result* 31)+((this.tags == null)? 0 :this.tags.hashCode()));
        result = ((result* 31)+((this.dependencies == null)? 0 :this.dependencies.hashCode()));
        result = ((result* 31)+((this.environment == null)? 0 :this.environment.hashCode()));
        result = ((result* 31)+((this.stage == null)? 0 :this.stage.hashCode()));
        result = ((result* 31)+((this.inherit == null)? 0 :this.inherit.hashCode()));
        result = ((result* 31)+((this.except == null)? 0 :this.except.hashCode()));
        result = ((result* 31)+((this.beforeScript == null)? 0 :this.beforeScript.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobTemplate) == false) {
            return false;
        }
        JobTemplate rhs = ((JobTemplate) other);
        return (((((((((((((((((((((((((((((((this.resourceGroup == rhs.resourceGroup)||((this.resourceGroup!= null)&&this.resourceGroup.equals(rhs.resourceGroup)))&&((this.release == rhs.release)||((this.release!= null)&&this.release.equals(rhs.release))))&&((this.rules == rhs.rules)||((this.rules!= null)&&this.rules.equals(rhs.rules))))&&((this.startIn == rhs.startIn)||((this.startIn!= null)&&this.startIn.equals(rhs.startIn))))&&((this.when == rhs.when)||((this.when!= null)&&this.when.equals(rhs.when))))&&((this.timeout == rhs.timeout)||((this.timeout!= null)&&this.timeout.equals(rhs.timeout))))&&((this.allowFailure == rhs.allowFailure)||((this.allowFailure!= null)&&this.allowFailure.equals(rhs.allowFailure))))&&((this.afterScript == rhs.afterScript)||((this.afterScript!= null)&&this.afterScript.equals(rhs.afterScript))))&&((this.parallel == rhs.parallel)||((this.parallel!= null)&&this.parallel.equals(rhs.parallel))))&&((this.only == rhs.only)||((this.only!= null)&&this.only.equals(rhs.only))))&&((this.retry == rhs.retry)||((this.retry!= null)&&this.retry.equals(rhs.retry))))&&((this.artifacts == rhs.artifacts)||((this.artifacts!= null)&&this.artifacts.equals(rhs.artifacts))))&&((this.needs == rhs.needs)||((this.needs!= null)&&this.needs.equals(rhs.needs))))&&((this.coverage == rhs.coverage)||((this.coverage!= null)&&this.coverage.equals(rhs.coverage))))&&((this.image == rhs.image)||((this.image!= null)&&this.image.equals(rhs.image))))&&((this.variables == rhs.variables)||((this.variables!= null)&&this.variables.equals(rhs.variables))))&&((this.cache == rhs.cache)||((this.cache!= null)&&this.cache.equals(rhs.cache))))&&((this._extends == rhs._extends)||((this._extends!= null)&&this._extends.equals(rhs._extends))))&&((this.services == rhs.services)||((this.services!= null)&&this.services.equals(rhs.services))))&&((this.trigger == rhs.trigger)||((this.trigger!= null)&&this.trigger.equals(rhs.trigger))))&&((this.secrets == rhs.secrets)||((this.secrets!= null)&&this.secrets.equals(rhs.secrets))))&&((this.interruptible == rhs.interruptible)||((this.interruptible!= null)&&this.interruptible.equals(rhs.interruptible))))&&((this.script == rhs.script)||((this.script!= null)&&this.script.equals(rhs.script))))&&((this.tags == rhs.tags)||((this.tags!= null)&&this.tags.equals(rhs.tags))))&&((this.dependencies == rhs.dependencies)||((this.dependencies!= null)&&this.dependencies.equals(rhs.dependencies))))&&((this.environment == rhs.environment)||((this.environment!= null)&&this.environment.equals(rhs.environment))))&&((this.stage == rhs.stage)||((this.stage!= null)&&this.stage.equals(rhs.stage))))&&((this.inherit == rhs.inherit)||((this.inherit!= null)&&this.inherit.equals(rhs.inherit))))&&((this.except == rhs.except)||((this.except!= null)&&this.except.equals(rhs.except))))&&((this.beforeScript == rhs.beforeScript)||((this.beforeScript!= null)&&this.beforeScript.equals(rhs.beforeScript))));
    }

}
