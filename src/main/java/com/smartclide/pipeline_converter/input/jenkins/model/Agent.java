package com.smartclide.pipeline_converter.input.jenkins.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder()
@NoArgsConstructor
@AllArgsConstructor
public class Agent {
	@Builder.Default
	private AgentType agentType = AgentType.ANY;
	private String label;
	private Docker docker;

	public enum AgentType {
		ANY, NONE, OTHER;
	}
}

