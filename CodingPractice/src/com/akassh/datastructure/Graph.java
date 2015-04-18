package com.akassh.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import com.practice.challenge.ArraysUtility;

public class Graph {
	private int[][] adjacencyMatrix;
	private boolean directed;
	
	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
		this.adjacencyMatrix = adjacencyMatrix;
	}

	private void matrixInitialization() {
		for(int i=0;i<adjacencyMatrix.length;++i)
			Arrays.fill(adjacencyMatrix[i], Integer.MAX_VALUE);
	}
	
	public Graph(int nodes) {
		adjacencyMatrix = new int[nodes][nodes];
		matrixInitialization();
		directed = false;
	}
	
	public Graph(int nodes, boolean directed) {
		adjacencyMatrix = new int[nodes][nodes];
		matrixInitialization();
		this.directed = directed; 
	}
	public boolean graphAddEdges(char v1,char v2, int weight) {
		int node1 = v1-'A';
		int node2 = v2-'A';
		if(adjacencyMatrix!=null || adjacencyMatrix.length==0 || node1<0 || node1>=adjacencyMatrix.length || node2<0 || node2>=adjacencyMatrix[0].length)
				return false;
		if(adjacencyMatrix[node1][node2]!=Integer.MAX_VALUE)
			return false;
		if(!directed) {
				adjacencyMatrix[node1][node2] = weight;
				adjacencyMatrix[node2][node1] = weight;
		} else
			adjacencyMatrix[node1][node2] = weight;
		return true;
	}
	
	public int[][] floydWarshall() {
		if(adjacencyMatrix==null || adjacencyMatrix.length==0)
			return null;
		int[][] dist = new int [adjacencyMatrix.length][adjacencyMatrix.length];
		for(int i=0;i<adjacencyMatrix.length;++i)
			for(int j=0;j<adjacencyMatrix[0].length;++j)
					dist[i][j] = adjacencyMatrix[i][j];
		
		for(int k=0;k<adjacencyMatrix.length;++k)
			for(int i=0;i<adjacencyMatrix.length;++i)
				for(int j=0;j<adjacencyMatrix[0].length;++j)
					if(dist[i][k] + dist[k][j] > 0 && dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
		return dist;
	}
	
	public int getNumberOfConnectedComponents() {
		int count = 0;
		boolean[][] visited = new boolean[adjacencyMatrix.length][adjacencyMatrix.length];
		for(int i=0;i<adjacencyMatrix.length;++i)
			for(int j=0;j<adjacencyMatrix.length;++j)
				if(adjacencyMatrix[i][j]!=Integer.MAX_VALUE&&!visited[i][j]) {
					floodFill(visited, i, j);
					++count;
				}
		return count;
	}
	
	private void floodFill(boolean[][] visited, int x, int y) {
		if(x>=adjacencyMatrix.length||x<0||y>=adjacencyMatrix.length||y<0||visited[x][y]||adjacencyMatrix[x][y]==Integer.MAX_VALUE)
			return;
		else {
			visited[x][y] = true;
			floodFill(visited, x, y-1);
			floodFill(visited, x, y+1);
			floodFill(visited, x-1, y-1);
			floodFill(visited, x-1, y);
			floodFill(visited, x-1, y+1);
			floodFill(visited, x+1, y+1);
			floodFill(visited, x+1, y-1);
			floodFill(visited, x+1, y);
		}
	}
	
	public boolean graphAddEdges(char v1,char v2) {
		int node1 = v1-'A';
		int node2 = v2-'A';
		if(adjacencyMatrix==null || adjacencyMatrix.length==0 || node1<0 || node1>=adjacencyMatrix.length || node2<0 || node2>=adjacencyMatrix[0].length)
				return false;
		if(adjacencyMatrix[node1][node2]!=Integer.MAX_VALUE)
			return false;
		if(!directed) {
				adjacencyMatrix[node1][node2] = 1;
				adjacencyMatrix[node2][node1] = 1;
		} else
			adjacencyMatrix[node1][node2] = 1;
		return true;
	}
	
	public List<Character> depthFirstSearch(char vertex) {
		int node = vertex-'A';
		if(node<0||node>=adjacencyMatrix.length)
			throw new IllegalArgumentException("Node not in range");
		Stack<Integer> stack = new Stack<Integer>();
		List<Character> dfs = new ArrayList<Character>();
		boolean[] visited = new boolean[adjacencyMatrix.length];
		stack.push(node);
		while(!stack.isEmpty()) {
			int v = stack.pop();
			if(!visited[v]) {
				visited[v]=true;
				dfs.add((char)(v+65));
				for(int i=0;i<adjacencyMatrix.length;++i)
					if(adjacencyMatrix[v][i]!=Integer.MAX_VALUE)
						stack.push(i);
			}
		}
		return dfs;
	}
	
	public List<Character> breadthFirstSearch(char vertex) {
		int node = vertex-'A';
		if(node<0||node>=adjacencyMatrix.length)
			throw new IllegalArgumentException("Node not in range");
		Queue<Integer> queue = new ArrayDeque<Integer>();
		List<Character> bfs = new ArrayList<Character>();
		boolean[] visited = new boolean[adjacencyMatrix.length];
		queue.add(node);
		while(!queue.isEmpty()) {
			int v = queue.remove();
			if(!visited[v]) {
				visited[v]=true;
				bfs.add((char)(v+65));
				for(int i=0;i<adjacencyMatrix.length;++i)
					if(adjacencyMatrix[v][i]!=Integer.MAX_VALUE)
						queue.add(i);
			}
		}
		return bfs;
	}
	
	public boolean isIsomorphic(Graph g) {
		int[][] g1 = this.getAdjacencyMatrix();
		int[][] g2 = g.getAdjacencyMatrix();
		if(g1.length!=g2.length)
			return false;
		for(int i=0;i<g1.length;++i) {
			if(g1[i].length!=g2[i].length)
				return false;
			for(int j=0;j<g2.length;++j)
				if(g1[i][j]!=g2[i][j])
					return false;
		}
		return true;
	}
	
	public boolean isCyclicDetected() {
		if(directed) {
			return false;
		} else {
			Random r = new Random(System.currentTimeMillis());
			int rVertex = r.nextInt(adjacencyMatrix.length);
			boolean[] onStack = new boolean[adjacencyMatrix.length];
			boolean[] visited = new boolean[adjacencyMatrix.length];
			Stack<Integer> s = new Stack<Integer>();
			s.push(rVertex);
			onStack[rVertex] = true;
			while(!s.isEmpty()) {
				int v = s.pop(); 
				onStack[v] = false;
				if(!visited[v]) {
					visited[v] = true;
					for(int i=0;i<adjacencyMatrix.length;++i)
						if(adjacencyMatrix[v][i]==1){
							if(onStack[i])
								return true;
							s.push(i);
							onStack[i] = true;
						}
				}
			}
			return false;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for(int[] A : adjacencyMatrix) {
			for(int r : A)
				if(r==Integer.MAX_VALUE)
					sb.append("INF" + "\t");
				else 
					sb.append(r + "\t");
			sb.append("\n");
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
		System.out.println("DFS: " + g1.depthFirstSearch('A'));
		System.out.println("BFS: " + g1.breadthFirstSearch('A'));
		System.out.println("Cycle Detected: " + g1.isCyclicDetected());
		ArraysUtility.printMatrix(g1.floydWarshall());
		System.out.println("Connected Components: " + g1.getNumberOfConnectedComponents());
		
		Graph g2 = new Graph(5);
		g2.graphAddEdges('A', 'B');
		g2.graphAddEdges('B', 'C');
		g2.graphAddEdges('C', 'D');
		g2.graphAddEdges('D', 'E');
		System.out.println(g2);
		System.out.println("DFS: " + g2.depthFirstSearch('A'));
		System.out.println("BFS: " + g2.breadthFirstSearch('A'));
		System.out.println("Cycle Detected: " + g2.isCyclicDetected());
		ArraysUtility.printMatrix(g2.floydWarshall());
		System.out.println("Connected Components: " + g2.getNumberOfConnectedComponents());
		
		System.out.println("Are G1 & G2 Isomorphic: " + g1.isIsomorphic(g2));
		
	}
}