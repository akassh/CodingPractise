package com.practice.challenge;

public class JosephusProblem {
	/**
	 * ((n-1, k)+k-1) % n + 1
	 * @param n
	 * @param k
	 * @return
	 */
	public static int getJosephusProblemSolution(int n, int k) {
		if(n<=0||k<=1)
			throw new IllegalArgumentException("Invalid Input argument");
		if(n==1)
			return n;
		int[] soln = new int[n];
		for(int i=1;i<=n;++i) {
			if(i==1)
				soln[i-1] = 1;
			else {
				soln[i-1] = (soln[i-2] + k - 1) % i + 1;
			}
		}
		return soln[n-1];
	}
	
	public static int getJosephusProblemSolution2(int n, int k) {
		if(n<=0||k<=1)
			throw new IllegalArgumentException("Invalid Input argument");
		if(n==1)
			return n;
		int[] soln = new int[n+1];
		for(int i=1;i<=n;++i) {
			if(i==1)
				soln[i] = 1;
			else {
				soln[i] = (soln[i-1] + k - 1) % i + 1;
			}
		}
		return soln[n];
	}
	
	public static void main(String[] args) {
		System.out.println(getJosephusProblemSolution(5, 2));
		System.out.println(getJosephusProblemSolution2(5, 2));
	}
}
