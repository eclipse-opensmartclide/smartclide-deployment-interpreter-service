package com.smartclide.pipeline_converter.input.jenkins;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Node{
	String type;
	String name;
	List<String> content = new ArrayList<>();
	List<Node> children = new ArrayList<>();
	Node parent;
	
	public Node(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public Optional<Node> getParent() {
		return Optional.ofNullable(parent);
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return "Node [type=" + type + ", name=" + name + ", content=" + content + ", children=" + children + "]";
	}
}
