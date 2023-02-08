package com.smartclide.pipeline_converter.input.jenkins.model;

import com.smartclide.pipeline_converter.input.jenkins.common.Util;
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
public class Options {
  private String timeout;
  private Retry retry;
  @Override
  public String toString() {
    return getResponse();
  }

  private String getResponse() {
    String response="";
    if(timeout!= null && !timeout.isEmpty()){
      String unit = Util.filterEnded(timeout, Util.SEPARATOR_BLANK);
      String time = Util.filterInitial(timeout, Util.SEPARATOR_BLANK);
      response += "    timeout(time: " + time + ", unit: " + unit + ")";
    }
    if(retry!= null){
      response += "retry(" + retry + ")";
    }
    return response;
  }

}
