package com.practice.challenge;

import java.util.Arrays;

public class MaximumJ_I {
	public static int getMaximumJ_I(int[] A) {
		if(A==null||A.length==0)
			return -1;
		int[] lMin = new int [A.length];
		int minIndex = 0;
		for(int i=0;i<lMin.length;++i) {
			if(A[minIndex] > A[i])
				minIndex = i;
			lMin[i] = minIndex;
			
		}
		
		int[] rMax = new int [A.length];
		int maxIndex = A.length-1;
		for(int i=rMax.length-1;i>=0;--i) {
			if(A[maxIndex] < A[i])
				maxIndex = i;
			rMax[i] = maxIndex;
		}
		
		int maxDiff = Integer.MIN_VALUE;
		
		for(int i=0,j=0; i<A.length && j<A.length; ) {
			if(A[lMin[i]] < A[rMax[j]])	{
				if(maxDiff < rMax[j] - lMin[i])
					maxDiff = rMax[j] - lMin[i];
				++j;
			}
			else
				++i;
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		int[] A = {4,3,5,2,1,3,2,3};
		System.out.println(Arrays.toString(A));
		System.out.println(getMaximumJ_I(A));
		
		
	}
}
