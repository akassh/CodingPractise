package com.practice.challenge;

public class KnightTourProblem {
	private int[] x = {2, 2, 1, -1, -2, -2, -1, 1}; 
	private int[] y = {1, -1, -2, -2, -1, 1, 2, 2};
	private int[][] m;
	
	public KnightTourProblem(int n) {
		m = new int[n][n];
	}
	
	private boolean isSafe(int x, int y) {
		return !(x<0||y<0||x>=m.length||y>=m.length||m[x][y]!=0);
	}
	
	public boolean getSolution() {
		m[0][0] = 1;
		return getSolution(0, 0, 2);
	}
	
	private boolean getSolution(int currX, int currY, int count) {
		if(count==m.length*m.length+1)
			return true;
		for(int i=0;i<x.length;++i) {
			int newX = currX + x[i];
			int newY = currY + y[i];
			if(isSafe(newX, newY)) {
				m[newX][newY] = count;
				if(getSolution(newX, newY, count+1))
					return true;
				else 
					m[newX][newY] = 0;
			}
		}
		return false;
	}
	
	public void printSolution() {
		ArraysUtility.printMatrixTab(m);
	}
	
	public static void main(String[] args) {
		KnightTourProblem k = new KnightTourProblem(8);
		k.getSolution();
		k.printSolution();
	}
}
