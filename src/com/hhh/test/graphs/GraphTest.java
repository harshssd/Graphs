package com.hhh.test.graphs;

import static org.junit.Assert.*;

import java.util.HashMap;

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
		Node seventeenNode = new Node("seventeen");
		fifteenNode.addNeighbor(seventeenNode);
		twoNode.addNeighbor(seventeenNode);
		Node twentyNode = new Node("twenty");
		twoNode.addNeighbor(twentyNode);
		root.addNeighbor(twoNode);
		Node threeNode = new Node("three");
		threeNode.addNeighbor(fifteenNode);
		root.addNeighbor(threeNode);
		root.addNeighbor(twentyNode);
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
		assertTrue(graph.dfs("seventeen"));
	}
	
	@Test
	public void dijkstrasTestPositive() {
		Node oneDistance = new Node("distanceIs1");
		Node twoDistance = new Node("distanceIs2");
		Node threeDistance = new Node("distanceIs3");
		Node fourDistance = new Node("distanceIs4");
		Node oneOrfourDistance = new Node("distanceIs4Or1");
		root.addNeighbor(oneDistance);
		oneDistance.addNeighbor(twoDistance);
		twoDistance.addNeighbor(threeDistance);
		threeDistance.addNeighbor(fourDistance);
		threeDistance.addNeighbor(oneOrfourDistance);
		root.addNeighbor(oneOrfourDistance);
		System.out.println("True when shortest distance is returned");
		HashMap<Node, Integer> distanceMap= graph.dijkstra();
		assertTrue(distanceMap.get(oneOrfourDistance)==1 && distanceMap.get(fourDistance)==4 &&
				distanceMap.get(threeDistance)==3 && distanceMap.get(twoDistance)==2);
	}
}
