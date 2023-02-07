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
public class When {

  List<String> expression;
  List<String> environment;
  List<String> branch;
  List<String> allOf;
  List<String> notAnyOf;

  @Override
  public String toString() {
    final String expressionFlatten = Util.getListFlatten(expression, "expression");
    final String envFlatten = Util.getListFlatten(environment, "environment");
    final String branchFlatten = Util.getListFlatten(branch, "branch");
    final String notFlatten = getNotAnyOfFlatten();
    final String allOfFlatten = getAllOfFlatten();
    return getResponse(expressionFlatten, envFlatten, branchFlatten, notFlatten, allOfFlatten);
  }
  private String getNotAnyOfFlatten() {
    String notAnyOfFlatten = "";
    String concatenated = "";
    if(this.notAnyOf != null && !this.notAnyOf.isEmpty()) {
      for (String nAnyOf: this.notAnyOf) {
        if(!nAnyOf.contains(Util.BRANCH)){
          String envName = Util.filterInitial(nAnyOf, Util.SEPARATOR_EQUAL);
          String enValue = Util.filterEnded(nAnyOf, Util.SEPARATOR_EQUAL);
          concatenated = "        environment name: '" + envName + "', environment value: '" + enValue + "'\n";
        }else{
          String branch = Util.filterEnded(nAnyOf, Util.SEPARATOR_EQUAL);
          concatenated = "        branch: " + branch + "\n";
        }
        notAnyOfFlatten += " " + concatenated;
      }
    }
    return notAnyOfFlatten;
  }
  private String getAllOfFlatten() {
    String response ="";
    if(this.allOf != null && !this.allOf.isEmpty()) {
      for (String allOf: this.allOf) {
        String envName = Util.filterInitial(allOf,Util.SEPARATOR_EQUAL);
        String enValue = Util.filterEnded(allOf,Util.SEPARATOR_EQUAL);
        String env = "       environment name: '" + envName + "', environment value: '" + enValue + "'\n";
        response += "  " + env;
      }
    }
    return response;
  }
  private String getResponse(String expressionFlatten, String envFlatten,
                             String branchFlatten, String notFlatten, String allOfs) {
    String response = "{\n";
    if(expression != null && !expression.isEmpty()) {
      response += "        expression{\n" + expressionFlatten + "\n        } \n";
    }
    if(environment != null && !environment.isEmpty()) {
      response += "        environment{\n" + "    "+ envFlatten + "    }\n";
    }
    if(branch != null && !branch.isEmpty()) {
      response += "        branch '" + branchFlatten + "'\n ";
    }
    if(notAnyOf != null && !notAnyOf.isEmpty()) {
      response += "        not{\n" + notFlatten + "        }\n";
    }
    if(allOf != null && !allOf.isEmpty()) {
      response += "         allOf{ \n " + allOfs + "    }\n";
    }
    response +="     }";

    return response;
  }
}
