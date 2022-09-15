package com.smartclide.pipeline_converter.input.jenkins.model;

import java.util.ArrayList;
import java.util.List;

public class Stage {
	String name;
	Agent agent;
	When when;
	List<String> steps = new ArrayList<>();
	Post post;

}
