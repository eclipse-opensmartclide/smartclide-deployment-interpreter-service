package com.smartclide.pipeline_converter.input.jenkins.common;

import com.smartclide.pipeline_converter.input.jenkins.model.Stage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Util {
    public static final String ARTIFACT = "archiveArtifacts artifacts: ";
    public static final String BRANCH = "CI_COMMIT_BRANCH";
    public static final String SEPARATOR_EQUAL = "==";
    public static final String SEPARATOR_BLANK = " ";

    public static String getListFlatten(List<String> list, String condition){
        final StringBuilder textFlatten = new StringBuilder();
        if(list != null && !list.isEmpty()){
            list.forEach(text ->  textFlatten.append(getTextAppend(condition, text)));
        }
        return textFlatten.toString();
    }

    public static String getStagesFlatten(List<Stage> stages, String condition) {
        StringBuilder textFlatten = new StringBuilder();
        if(stages != null && !stages.isEmpty()){
            stages.forEach(stage ->  textFlatten.append(getStageAppend(condition, stage)));
        }
        return textFlatten.toString();
    }
    public static String getMapFlatten(Map<String, String> map, String condition) {
        StringBuilder mapFlatten = new StringBuilder();
        if(map != null && !map.isEmpty()) {
            for (Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator(); entries.hasNext(); ) {
                Map.Entry<String, String> entry = entries.next();
                mapFlatten.append(getMapAppend(condition, entry.getKey(), entry.getValue()));
            }
        }
        return mapFlatten.toString();
    }

    public static String filterInitial(String text, String separator) {
        return text.substring(0, text.lastIndexOf(separator));
    }
    public static String filterEnded(String text, String separator) {
        return  text.substring(text.lastIndexOf(separator)+2);
    }

    public static String getTextAppend(String condition, String text) {
        String result="";
        switch (condition) {
            case "agent":
            case "success":
            case "artifact":
                result = " " + text;
                break;
            case "docker":
            case "always":
                result = " " + text + "\n ";
                break;
            case "steps":
                result = "    " + text + "\n     ";
                break;
            case "expression":
                result = "          " + text;
                break;
            case "environment":
                result = "      " + text + "    \n    ";
                break;
            case "branch":
                result = text;
                break;
        }
        return result;
    }

    public static String getStageAppend(String condition, Stage stage) {
        String result="";
        switch (condition) {
            case "pipeline":
                result = "    " + stage + "\n ";
                break;
            case "parallel":
                result = "      " + stage + "\n ";
                break;
        }
        return result;
    }
    public static String getMapAppend(String condition, String key, String value){
        String result="";
        switch (condition) {
            case "pipeline":
                result = "       " + key + " = '" + value + "'\n";
                break;
            case "stage":
                result = "       " + key + " = " + value + "\n";
                break;
        }
        return result;
    }
}

