package com.practice.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumProductNSumSubArray {
	
	private static int max(int a,int b, int c) {
		return Math.max(Math.max(a, b),c); 
	}
	
	private static int min(int a,int b, int c) {
		return Math.min(Math.min(a, b),c); 
	}
	
	public static int getMaximumSubArrayProduct(int[] A) {
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
	public static int[] getMaximumSubArraySum(int[] A) {
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
	
	public static int[] getLargestSubArrayWithEqualNumberOf0N1(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Invalid Input: null or empty Array");
		int[] leftSum = new int[A.length];
		int[] result = new int[3];
		Arrays.fill(result, -1);
		for(int i=0;i<A.length;++i) {
			leftSum[i] = (A[i]==0 ? -1 : 1) + (i==0 ? 0 : leftSum[i-1]);
			if(leftSum[i]==0) {
				result[0] = i+1;
				result[1] = 0;
				result[2] = i;
			}
		}
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<A.length;++i)
			if(!map.containsKey(A[i]))
				map.put(A[i], i);
			else {
				int startIndex = map.get(A[i]);
				int endIndex = i;
				if(result[0] < endIndex - startIndex + 1) {
					result[0] = endIndex - startIndex + 1;
					result[1] = startIndex;
					result[2] = endIndex;
				}
			}
		return result;
	}
	
	public static void main(String[] args) {
		/*int[] A = {6, -3, -10, 0, 2};
		ArraysUtility.printArray(A);
		System.out.println(getMaximumSubArrayProduct(A));
		ArraysUtility.printArray(getMaximumSubArraySum(A));
		int[] B = {-1, -3, -10, 0, 60};
		ArraysUtility.printArray(B);
		System.out.println(getMaximumSubArrayProduct(B));
		ArraysUtility.printArray(getMaximumSubArraySum(B));
		int[] C = {-2, -3, 0, -2, -40};
		ArraysUtility.printArray(C);
		System.out.println(getMaximumSubArrayProduct(C));
		ArraysUtility.printArray(getMaximumSubArraySum(C));
		int[] D = {0, 0, -20, 0};
		ArraysUtility.printArray(D);
		System.out.println(getMaximumSubArrayProduct(D));
		ArraysUtility.printArray(getMaximumSubArraySum(D));
		int[] E = {0, 0, 0};
		ArraysUtility.printArray(E);
		System.out.println(getMaximumSubArrayProduct(E));
		ArraysUtility.printArray(getMaximumSubArraySum(E));*/
		
		int[] F = {1, 0, 1, 1, 1, 0, 0};
		ArraysUtility.printArray(F);
		ArraysUtility.printArray(getLargestSubArrayWithEqualNumberOf0N1(F));
		
		
		
	}
}
