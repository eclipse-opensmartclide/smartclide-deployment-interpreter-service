package com.smartclide.pipeline_converter.input.gitlab.model;

public enum RunConditions {
	on_success,
	on_failure,
	always,
	manual,
	delayed,
	never
}
