package com.practice.challenge;

public class PaintersPartitioningProblem {
	public static int getSum(int[] A) {
		int sum = 0;
		for(int a : A)
			sum += a;
		return sum;
	}
	
	public static int getMax(int[] A) {
		int max = Integer.MIN_VALUE;
		for(int a : A)
			max = Math.max(max, a);
		return max;
	}
	
	public static int getRequiredPainters(int[] A, int val) {
		int painterCount = 1;
		int partialSum = 0;
		for(int i=0;i<A.length;++i) {
			partialSum += A[i];
			if(partialSum > val) {
				partialSum = A[i];
				++painterCount;
			} 
		}
		return painterCount;
	}
	
	public static int painterPartitioning(int[] A, int k) {
		int low = getMax(A);
		int high = getSum(A);
		while(low < high) {
			int mid = (low+high)/2;
			int requiredPainters = getRequiredPainters(A, mid);
			if(requiredPainters <= k)
				high = mid;
			else
				low = mid+1;
		}
		return low;
	}
	
	public static void main(String[] args) {
		int[] A = { 100, 200, 300, 400, 500, 600, 700, 800, 900  };
		System.out.println(painterPartitioning(A, 3));
	}
	
}
