package com.practice.challenge;

public class NQueenProblem {
	private int[] q;
	
	public int[] getSolution() {
		return this.q;
	}
	
	public NQueenProblem(int n) {
		this.q = new int[n];
	}
	
	public boolean solveNQueenProblem() {
		return solveNQueenProblem(0);
	}
	
	private boolean solveNQueenProblem(int i) {
		if(i==q.length)
			return true;
		for(int k=0;k<q.length;++k) {
			q[i] = k;
			if(isSafe(i) && solveNQueenProblem(i+1))
				return true;
		}
		return false;		
	}
	
	public int countNQueenProblem() {
		int[] count = new int[1];
		countNQueenProblem(0, count);
		return count[0];
	}
	
	private void countNQueenProblem(int i,int[] count) {
		if(i==q.length) {
			++count[0];
		}
		else {
			for(int k=0;k<q.length;++k) {
				q[i] = k;
				if(isSafe(i))
					countNQueenProblem(i+1, count);
			}	
		}
	}
	
	private boolean isSafe(int i) {
		for(int k=0;k<i;++k)
			if(q[k]==q[i])
				return false;
			else if(Math.abs(k-i)==Math.abs(q[k]-q[i]))
				return false;
		return true;
	}
	
	public char[][] getMatrixFormForNQueen() {
		char[][] m = new char[q.length][q.length];
		for(int i=0;i<q.length;++i)
			m[i][q[i]] = 'Q';
		return m;
	}
	
	public static void main(String[] args) {
		NQueenProblem nQueen = new NQueenProblem(4);
		if(nQueen.solveNQueenProblem()) {
			ArraysUtility.printArray(nQueen.getSolution());
			ArraysUtility.printMatrix(nQueen.getMatrixFormForNQueen());
		}
		NQueenProblem nQueen2 = new NQueenProblem(8);
		System.out.println(nQueen2.countNQueenProblem());
			
	}
}
