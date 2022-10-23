package com.smartclide.pipeline_converter.input.jenkins.model;

import java.util.List;
import java.util.Map;

import com.smartclide.pipeline_converter.input.jenkins.common.Util;
import com.smartclide.pipeline_converter.input.jenkins.model.Agent.AgentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class Pipeline {
  private Agent agent;
  private Map<String, String> environment;
  private List<Stage> stages;
  private Post post;
  private Options options;

  @Override
  public String toString() {
    final Docker docker = agent.getDocker();
    final String stageFlatten = Util.getStagesFlatten(stages,"pipeline");
    final String envFlatten = Util.getMapFlatten(environment, "pipeline");
    return getResponse(stageFlatten, docker, envFlatten);
  }
  private String getResponse(String stageFlatten, Docker docker, String envFlatten) {
    String response = "pipeline{\n";
    if(agent != null && docker != null) {
      response += "    agent{\n     " + docker + "    \n    }\n";
    }else{
      response += "    agent " + AgentType.any + "\n";
    }
    if(options != null) {
      response += "    options{\n  " + options + "\n    }\n";
    }
    if(environment != null && !environment.isEmpty()) {
      response += "    environment{\n" + envFlatten + "    }\n";
    }
    if(stages != null && !stages.isEmpty()) {
      response += "    stages{\n " + stageFlatten + "  }";
    }
    if(post != null) {
      response += "    post " + post + "\n";
    }
    response += "\n}";

    return response;
  }
}
