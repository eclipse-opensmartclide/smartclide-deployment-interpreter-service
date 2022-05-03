package com.smartclide.pipeline_converter.input.gitlab.model;

import java.util.List;
import java.util.Objects;

public class IncludeItems {
	List<IncludeItem> items;

	public List<IncludeItem> getItems() {
		return items;
	}

	public void setItems(List<IncludeItem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(items);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncludeItems other = (IncludeItems) obj;
		return Objects.equals(items, other.items);
	}
}
