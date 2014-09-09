package com.hhh.test.graphs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.hhh.graphs.Graph;
import com.hhh.graphs.Node;

public class GraphTest{

	Graph graph;
	Node root;
	int numberOfElements;
	
	@Before
	public void setUp() throws Exception {
		root = new Node("One");
		Node twoNode = new Node("two");
		Node fifteenNode = new Node("fifteen");
		twoNode.addNeighbor(fifteenNode);
		twoNode.addNeighbor(new Node("seventeen"));
		twoNode.addNeighbor(new Node("twenty"));
		root.addNeighbor(twoNode);
		Node threeNode = new Node("three");
		threeNode.addNeighbor(fifteenNode);
		root.addNeighbor(threeNode);
		graph = new Graph(root);
		numberOfElements = graph.getRoot().getNeighborsCount();
	}
	
	@Test
	public void addNeighborTest() {
		int countBeforeAddingElement = numberOfElements;
		root.addNeighbor(new Node("four"));
		System.out.println("Count of neighbors will be increased after adding an element");
		assertTrue(graph.getRoot().getNeighborsCount()==countBeforeAddingElement+1);
	}
	
	@Test
	public void bfsTestNegative() {
		System.out.println("False when the term searched doesn't exist");
		assertFalse(graph.bfs("fourteen"));
	}
	@Test
	public void bfsTestPositive() {
		System.out.println("True when the term searched does exist");
		assertTrue(graph.bfs("fifteen"));
	}
	
	@Test
	public void dfsTestNegative() {
		System.out.println("False when the term searched doesn't exist");
		assertFalse(graph.dfs("fourteen"));
	}
	@Test
	public void dfsTestPositive() {
		System.out.println("True when the term searched does exist");
		assertTrue(graph.dfs("fifteen"));
	}
}
