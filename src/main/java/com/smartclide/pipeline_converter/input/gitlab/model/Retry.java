package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(items);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			When other = (When) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(items, other.items);
		}

		private Retry getEnclosingInstance() {
			return Retry.this;
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

	@Override
	public int hashCode() {
		return Objects.hash(maxRetries, when);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retry other = (Retry) obj;
		return Objects.equals(maxRetries, other.maxRetries) && Objects.equals(when, other.when);
	}
	
}
