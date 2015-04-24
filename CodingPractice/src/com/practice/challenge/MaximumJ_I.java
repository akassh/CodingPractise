package com.practice.challenge;

import java.util.Arrays;

public class MaximumJ_I {
	//RT O(n). S O(1)
	public static int getMaximumDifference(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input Array is empty or null.");
		int min = A[0];
		int maxDiff = -1;
		for(int i=1;i<A.length;++i) {
			if(min > A[i])
				min = A[i];
			else if(maxDiff < A[i]-min)
				maxDiff = A[i] - min;
		}
		return maxDiff;
	}
	
	private static int getMaximumSubArraySum(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input Array is empty or null.");
		int max = A[0];
		int currSum = A[0]; 
		for(int i=1;i<A.length;++i) {
			if(currSum < 0)
				currSum = A[i];
			else 
				currSum += A[i];
			if(max < currSum)
				max = currSum;
		}
		return max;
	}
	
	//RT O(n). S O(n)
		public static int getMaximumDifference2(int[] A) {
			if(A==null||A.length==0)
				throw new IllegalArgumentException("Input Array is empty or null.");
			int[] a = new int[A.length-1];
			for(int i=1;i<A.length;++i)
				a[i-1] = A[i] - A[i-1];
			return getMaximumSubArraySum(a);
		}
	
	public static void main(String[] args) {
		int[] A = {0,5,6,1,2,3,7};
		System.out.println(Arrays.toString(A));
		System.out.println(getMaximumDifference(A));
		System.out.println(getMaximumDifference2(A));
		int[] B = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(B));
		System.out.println(getMaximumDifference(B));
		System.out.println(getMaximumDifference2(B));
		int[] C = {7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(C));
		System.out.println(getMaximumDifference(C));
		System.out.println(getMaximumDifference2(C));
	}
}

