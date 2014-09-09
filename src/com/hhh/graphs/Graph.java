package com.hhh.graphs;

import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

	private Node root;
	HashSet<Node> visitedNodes = new HashSet<Node>();
	
	public Graph(String data) {
		root = new Node(data);
	}
	
	public Graph(Node n) {
		this.root = n;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public boolean bfs(String searchKey) {		
//		1. Check if the root is null, if true return null
		if(this.getRoot() == null){
			return false;
		} else {
//			2. Else traverse and check each neighbor nodes for equality
//			Add each node to the set of visited nodes
//			Add each node to the queue of neighbor nodes
			LinkedList<Node> toBeVisitedQueue = new LinkedList<Node>();
			HashSet<Node> visitedNodes = new HashSet<Node>();
			toBeVisitedQueue.add(this.getRoot());
			while(!toBeVisitedQueue.isEmpty()){
//				3. Dequeue the node and check whether it exists in the set of visited nodes
//				if true move on to next node in the queue
//				if false repeat step 2 for the node
				Node currentNode = toBeVisitedQueue.poll();
				visitedNodes.add(currentNode);
				if(currentNode.getData()==searchKey){
					return true;
				}
				for(Node neighbor: currentNode.getNeighbors()){
					if(visitedNodes.contains(neighbor)==false)
						toBeVisitedQueue.add(neighbor);
				}
			}
			return false;
		}		
	}
	
	public boolean dfs(String searchKey, Node node) {
		visitedNodes.add(node);
		if(node == null) {
			return false;
		} else {
			if(node.getData() == searchKey){
				return true;
			}
			for(Node neighbor: node.getNeighbors()){
				if(visitedNodes.contains(neighbor) == false)
					if(dfs(searchKey, neighbor)==true)
						return true;
			}
		}
		return false;
	}
	
}
