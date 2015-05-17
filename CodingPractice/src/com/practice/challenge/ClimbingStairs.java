package com.practice.challenge;

public class ClimbingStairs {
	public static int climbStair(int n) {
		assert(n>=0);
		int[] a = new int[n+1];
		for(int i=0;i<=n;++i)
			if(i==0)
				a[i] = 0;
			else if(i==1)
				a[i] = 1;
			else if(i==2)
				a[i] = 2;
			else if(i==3)
				a[i] = 4;
			else 
				a[i] = a[i-1] + a[i-2] + a[i-3];
		return a[n];
	}
	
	public static void main(String[] args) {
		System.out.println(climbStair(4));
	}
}
