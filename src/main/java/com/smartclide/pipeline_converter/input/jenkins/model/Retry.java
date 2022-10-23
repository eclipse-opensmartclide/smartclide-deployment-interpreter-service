package com.smartclide.pipeline_converter.input.jenkins.model;

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
public class Retry {

  String maxRetries;
  When when;

  @Override
  public String toString() {
    return getResponse();
  }

  private String getResponse() {
    String response = "retry(";
    if(maxRetries != null && !maxRetries.isEmpty()){
      response += maxRetries + ")";
    }
    return response;
  }

}
