package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;

public class Retry {
	String maxRetries;
	When when;
	
	public class When{
		List<String> items;

		public List<String> getItems() {
			return items;
		}

		public void setItems(List<String> items) {
			this.items = items;
		}
	}

	public String getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(String maxRetries) {
		this.maxRetries = maxRetries;
	}

	public When getWhen() {
		return when;
	}

	public void setWhen(When when) {
		this.when = when;
	}
}
