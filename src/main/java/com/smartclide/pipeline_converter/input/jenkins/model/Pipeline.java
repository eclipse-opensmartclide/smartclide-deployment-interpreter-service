package com.smartclide.pipeline_converter.input.jenkins.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Pipeline {
	Agent agent;
	Map<String, String> environment = new LinkedHashMap<>();
	List<Stage> stages = new ArrayList<>();
	Post post;
	Options options;

}
