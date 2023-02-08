package com.smartclide.pipeline_converter.input.jenkins.model;

import java.util.List;

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
public class Post{
  private List<String> success;
  private List<String> always;
  @Override
  public String toString() {
    final String alwaysFlatten = Util.getListFlatten(always, "always");
    final String successFlatten = Util.getListFlatten(success, "success");
    return getResponse(alwaysFlatten, successFlatten);
  }
  private String getResponse(String alwaysFlatten, String successFlatten){
    String response = "";
    if(this.always != null && !this.always.isEmpty()){
      response += "     always{\n      " + alwaysFlatten + "     }";
    }
    if(this.success != null && !this.success.isEmpty()){
      response += "      success{\n     " + successFlatten + "\n  }";
    }
    return response;
  }
}
