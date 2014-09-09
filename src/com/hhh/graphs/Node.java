package com.hhh.graphs;

import java.util.HashSet;
import java.util.Set;

public class Node {
	
	private String data;
	private Set<Node> neighbors;

	public Node(String d) {
		this.data = d;
		this.neighbors = new HashSet<Node>();
	}
	
	public Node(String d, Set<Node> n) {
		this(d);
//		this.data = d;
		this.neighbors = n;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Set<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(Set<Node> neighbors) {
		this.neighbors = neighbors;
	}

	public void addNeighbor(Node n) {
		this.neighbors.add(n);
	}
	
	public int getNeighborsCount() {
		return this.neighbors.size();
	}
	
}
