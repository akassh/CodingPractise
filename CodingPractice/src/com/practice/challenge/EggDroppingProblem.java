package com.practice.challenge;

public class EggDroppingProblem {
	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 * Doesn't Work Need to Figure out
	 */
	public static int eggDroppingProblemRecursive(int n, int k) {
		int min = Integer.MAX_VALUE;
		int result;
		if(n==1||k==0||k==1)
			return k;
		else 
			for(int i=1;i<=k;++i){
				result = Math.max(eggDroppingProblemRecursive(n-1, k-1), eggDroppingProblemRecursive(n, k-i));
				if(min > result)
					min = result;
			}
		return min + 1;
	}
	
	// O((k n^2)works
	public static int[][] eggDroppingProblemDynamicProgramming(int f, int e) {
		int[][] m = new int[f+1][e+1];
		for(int i=0;i<=f;++i)
			for(int j=1;j<=e;++j)
				if(i==0||i==1||j==1)
					m[i][j] = i;
				else {
					m[i][j] = Integer.MAX_VALUE;
					for(int k=1;k<=i;++k) {
						int min = 1+Math.max(m[k-1][j-1], m[i-k][j]);
						if(m[i][j] > min) 
							m[i][j] = min;
					}
				}
		return m;			
	}
	
	public static void main(String[] args) {
		//System.out.printf("Egg/s = %d, Floor= %d, Minimum Trials Needed: ", 2, 4);
		ArraysUtility.printMatrix( eggDroppingProblemDynamicProgramming(1000, 10));
		
	}
}
