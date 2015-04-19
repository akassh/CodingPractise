package com.practice.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumProblem {
	public static int[] twoSum(int[] A, int x) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input Array is null or empty");
		Arrays.sort(A);
		int low = 0;
		int high = A.length-1;
		int[] result = new int[2];
		while(low<high)
			if(A[low]+A[high]<x)
				++low;
			else if(A[low]+A[high]>x)
				--high;
			else {
				result[0] = A[low];
				result[1] = A[high];
				break;
			}
		return result;
	}
	
	public static int[] twoSumV2(int[] A, int x) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input Array is null or empty");
		Set<Integer> s = new HashSet<Integer>();
		int[] result = new int[2];
		for(int i=0;i<A.length;++i)
			if(!s.contains(A[i]))
				s.add(x-A[i]);
			else {
				result[0] = A[i];
				result[1] = x-A[i];
				break;
			}	
		return result;
	}
	
	public static void main(String[] args) {
		int A[] = {1, 4, 45, 6, 10, 8};
	    int n = 16;
	    ArraysUtility.printArray(twoSum(A, n));
	    ArraysUtility.printArray(twoSumV2(A, n));
	}
}
