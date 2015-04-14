package com.practice.challenge;

public class CountNumberOfBinaryStringsWithoutConsecutiveOne {
	public static int countNumberOfBinaryStringsWithoutConsecutiveOne(int n) {
		if(n<0)
			return -1;
		if(n==0)
			return 1;
		int[] a = new int [n]; //Binary Strings Without Consecutive 1 ending in 0
		int[] b = new int [n]; //Binary Strings Without Consecutive 1 ending in 1
		a[0] = 1;
		b[0] = 1;
		for(int i=1;i<n;++i) {
			a[i] = a[i-1] + b[i-1]; //Binary Strings Without Consecutive 1 ending in 0 has 2 choice ending in 1 or 0
			b[i] = a[i-1]; //Binary Strings Without Consecutive 1 ending in 0 has 1 choice ending in 1
		}
		return a[n-1] + b[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(countNumberOfBinaryStringsWithoutConsecutiveOne(3));
	}
}
