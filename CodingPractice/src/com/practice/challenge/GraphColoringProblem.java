package com.practice.challenge;

import com.akassh.datastructure.Graph;

public class GraphColoringProblem {
	Graph g;
	int[] vertexColor;
	int maxColor;
	public GraphColoringProblem(Graph g, int maxColor) {
		this.g = g;
		vertexColor = new int[g.getAdjacencyMatrix().length];
		this.maxColor = maxColor;
	}
	
	public boolean isSafe(int vertex, int color) {
		int[][] adjM = g.getAdjacencyMatrix();
		for(int i=0 ;i<adjM.length; ++i)
			if( adjM[vertex][i]!=Integer.MAX_VALUE && vertexColor[i]==color)
				return false;
		return true;
	}
	
	public  boolean solve() {
		 return solve(0);
	}
	
	private boolean solve(int vIndex) {
		if(vIndex == vertexColor.length)
			return true;
		for(int i=1; i<= maxColor; ++i){
			if(isSafe(vIndex, i)) {
				vertexColor[vIndex] = i;
				if(solve(vIndex+1))
					return true;
				vertexColor[vIndex] = 0;
			}
		}
		return false;
	}
	
	public void printSolution() {
		ArraysUtility.printArray(vertexColor);
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.graphAddEdges('A', 'B');
		g.graphAddEdges('A', 'C');
		g.graphAddEdges('A', 'D');
		g.graphAddEdges('B', 'C');
		g.graphAddEdges('C', 'D');
		GraphColoringProblem gcp = new GraphColoringProblem(g, 3);
		gcp.solve();
		gcp.printSolution();
	}
}
