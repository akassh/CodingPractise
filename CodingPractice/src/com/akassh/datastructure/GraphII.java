package com.akassh.datastructure;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
	private char name;
	private Set<Node> adjVertex;
	
	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name+"";
	}

	public Set<Node> getAdjVertex() {
		return adjVertex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name;
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
		Node other = (Node) obj;
		if (name != other.name)
			return false;
		return true;
	}

	public void setAdjVertex(Set<Node> adjVertex) {
		this.adjVertex = adjVertex;
	}

	Node(char name) {
		this.name = name;
		adjVertex = new HashSet<Node>();
	}
	
	public void addNewVertex(Node n) {
		this.adjVertex.add(n);
	}
}

public class GraphII {
	Node startNode;
	
	private GraphII() {
		
	}
	
	public GraphII(Graph g) {
		if(g==null)
			throw new IllegalArgumentException("Graph argument is null...");
		Map<Character, Node> objectMap = new HashMap<Character, Node>();
		for(int i=0;i<g.getAdjacencyMatrix().length;++i)
			objectMap.put((char)(i+65), new Node((char)(i+65)));
		int[][] m = g.getAdjacencyMatrix();
		for(int i=0;i<m.length;++i) {
			Node s = objectMap.get((char)(i+65));
			for(int j=0;j<m[0].length;++j)
				if(m[i][j]!=Integer.MAX_VALUE)
					s.addNewVertex(objectMap.get((char)(j+65)));
		}
		this.startNode = objectMap.get((char)(0+65));
	}
	
	public static GraphII cloneGraphII(GraphII g) {
		if(g==null)
			throw new IllegalArgumentException("Graph argument is null...");
		GraphII copy = new GraphII();
		Map<Character, Node> objectMap = new HashMap<Character, Node>();
		copy.startNode = new Node(g.startNode.getName());
		objectMap.put(copy.startNode.getName(), copy.startNode);
		Queue<Node> qe = new ArrayDeque<Node>();
		Queue<Node> qc = new ArrayDeque<Node>();
		qe.add(g.startNode);
		qc.add(copy.startNode);
		Set<Character> s = new HashSet<Character>();
		while(!(qe.isEmpty()&&qc.isEmpty())) {
			Node p = qe.poll();
			Node cp = qc.poll();
			for (Node node : p.getAdjVertex()) 
				if(!cp.getAdjVertex().contains(node.getName())){
					if(!objectMap.containsKey(node.getName()))
						objectMap.put(node.getName(), new Node(node.getName()));
					cp.addNewVertex(objectMap.get(node.getName()));
					if(!s.contains(node.getName())) {
						qe.add(node);
						qc.add(objectMap.get(node.getName()));
					}
				}
			s.add(p.getName());
		}
		return copy;
	}
	
	public String getBFS() {
		if(this.startNode==null)
			return "";
		StringBuilder sb = new StringBuilder("");
		Queue<Node> q = new ArrayDeque<Node>();
		Set<Character> s = new HashSet<Character>();
		q.add(this.startNode);
		while(!q.isEmpty()) {
			Node p = q.poll();
			if(!s.contains(p.getName())) {
				sb.append(p.getName() + " ");
				for (Node node : p.getAdjVertex())
					if(!s.contains(node.getName()))
						q.add(node);
			}
			s.add(p.getName());
		}
		return sb.toString();
	}
	
	
	@Override
	public String toString() {
		if(this.startNode==null)
			return "";
		StringBuilder sb = new StringBuilder("");
		Queue<Node> q = new ArrayDeque<Node>();
		Set<Character> s = new HashSet<Character>();
		q.add(this.startNode);
		while(!q.isEmpty()) {
			Node p = q.poll();
			if(!s.contains(p.getName()))
				sb.append(p.getName() + "->" + p.getAdjVertex() + "\n");
			for (Node node : p.getAdjVertex())
				if(!s.contains(node.getName()))
					q.add(node);
			s.add(p.getName());
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Graph g1 = new Graph(8);
		g1.graphAddEdges('A', 'B');
		g1.graphAddEdges('A', 'D');
		g1.graphAddEdges('A', 'G');
		g1.graphAddEdges('B', 'E');
		g1.graphAddEdges('B', 'F');
		g1.graphAddEdges('E', 'G');
		g1.graphAddEdges('F', 'D');
		g1.graphAddEdges('F', 'C');
		g1.graphAddEdges('C', 'H');
		System.out.println(g1);
		System.out.println(g1.breadthFirstSearch('A'));
		GraphII g2 = new GraphII(g1);
		System.out.println(g2);
		GraphII g3 = GraphII.cloneGraphII(g2);
		System.out.println(g3.getBFS());
	}
}
