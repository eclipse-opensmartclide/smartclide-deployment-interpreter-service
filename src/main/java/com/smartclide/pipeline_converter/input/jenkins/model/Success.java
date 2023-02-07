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
public class Success {
  private List<String> archiveArtifacts;
  @Override
  public String toString() {
    final String artsFlatten = Util.getListFlatten(archiveArtifacts, "artifact");
    return getResponse(artsFlatten);
  }
  private String getResponse(String artsFlatten) {
    String response = "";
    if(archiveArtifacts != null && !archiveArtifacts.isEmpty()){
      response += Util.ARTIFACT + artsFlatten;
    }
    return response;
  }
}
