package com.hhh.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

	private Node root;
	
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
//			Add each node checked to the set of visited nodes
//			Add each neighbor node to the to be visited queue
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
	
	public boolean dfs(String searchKey) {
		HashSet<Node> visitedNodes = new HashSet<Node>();
		return dfsRecursive(searchKey, getRoot(), visitedNodes);
	}
	
	public boolean dfsRecursive(String searchKey, Node node, HashSet<Node> visitedNodes) {
		visitedNodes.add(node);
		if(node == null) {
			return false;
		} else {
			if(node.getData() == searchKey){
				return true;
			}
			for(Node neighbor: node.getNeighbors()){
				if(visitedNodes.contains(neighbor) == false)
					if(dfsRecursive(searchKey, neighbor, visitedNodes)==true)
						return true;
			}
		}
		return false;
	}
	
	public HashMap<Node, Integer> dijkstra(){
		HashMap<Node, Integer> distanceMap = new HashMap<Node, Integer>();
		LinkedList<Node> toBeVisitedQueue = new LinkedList<Node>();
		toBeVisitedQueue.add(getRoot());
		distanceMap.put(getRoot(), 0);
		while(!toBeVisitedQueue.isEmpty()) {
			Node currentNode = toBeVisitedQueue.poll();
			int currentDistance = distanceMap.get(currentNode);
			for(Node neighbor: currentNode.getNeighbors()){
				if(distanceMap.get(neighbor)==null || distanceMap.get(neighbor)>currentDistance+1){
					toBeVisitedQueue.add(neighbor);
					distanceMap.put(neighbor, currentDistance+1);
				}				
			}
		}
		return distanceMap;
	}
	
}
