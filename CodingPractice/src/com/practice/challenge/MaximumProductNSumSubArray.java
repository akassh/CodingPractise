package com.practice.challenge;

public class MaximumProductNSumSubArray {
	
	private static int max(int a,int b, int c) {
		return Math.max(Math.max(a, b),c); 
	}
	
	private static int min(int a,int b, int c) {
		return Math.min(Math.min(a, b),c); 
	}
	
	public static int maximumSubArrayProduct(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Invalid input: Array is null or with no elements");
		int currMin = 1;
		int currMax = 1;
		int prevMin = 1;
		int prevMax = 1;
		int globalMax = Integer.MIN_VALUE; 
		for(int i=0;i<A.length;++i) {
			currMin = min(A[i]*prevMin, A[i]*prevMax, A[i]);
			currMax = max(A[i]*prevMin, A[i]*prevMax, A[i]);
			if(globalMax < currMax)
				globalMax = currMax;
			prevMin = currMin;
			prevMax = currMax;
		}
		return globalMax;
	}
	/**
	 * Kadane's Algorithm
	 * @param A
	 * @return
	 */
	public static int[] maximumSubArraySum(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Invalid input: Array is null or with no elements");
		int[] result = new int[3];
		result[0] = Integer.MIN_VALUE;
		int sum = 0;
		int iS = 0;
		int iE = 0;
		for(int i=0;i<A.length;++i) {
			if(sum < 0) {
				sum = 0;
				iS = i;
				iE = i;
			} else {
				sum += A[i];
				iE = i+1; 
			}
			if(result[0] < sum) {
				result[0] = sum;
				result[1] = iS;
				result[2] = iE;
			}
		}
		return result;
	}
	
	int[] LargestSubArrayWithEqualNumberOf0N1(int[] A) {
		
	}
	
	public static void main(String[] args) {
		int[] A = {6, -3, -10, 0, 2};
		ArraysUtility.printArray(A);
		System.out.println(maximumSubArrayProduct(A));
		ArraysUtility.printArray(maximumSubArraySum(A));
		int[] B = {-1, -3, -10, 0, 60};
		ArraysUtility.printArray(B);
		System.out.println(maximumSubArrayProduct(B));
		ArraysUtility.printArray(maximumSubArraySum(B));
		int[] C = {-2, -3, 0, -2, -40};
		ArraysUtility.printArray(C);
		System.out.println(maximumSubArrayProduct(C));
		ArraysUtility.printArray(maximumSubArraySum(C));
		int[] D = {0, 0, -20, 0};
		ArraysUtility.printArray(D);
		System.out.println(maximumSubArrayProduct(D));
		ArraysUtility.printArray(maximumSubArraySum(D));
		int[] E = {0, 0, 0};
		ArraysUtility.printArray(E);
		System.out.println(maximumSubArrayProduct(E));
		ArraysUtility.printArray(maximumSubArraySum(E));
	}
}
