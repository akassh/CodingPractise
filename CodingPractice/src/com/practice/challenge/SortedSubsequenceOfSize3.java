package com.practice.challenge;

public class SortedSubsequenceOfSize3 {
	public static int[] getsortedSubsequenceOfSize3(int[] A)  {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input Array is empty or null");
		int[] smaller = new int[A.length];
		smaller[0] = -1;
		for(int i=1,min=0;i<A.length;++i)
			if(A[i]<A[min]) {
				min = i;
				smaller[min] = -1;
			} else
				smaller[i] = min;
		
		int[] bigger = new int[A.length];
		for(int i=A.length-2,max=A.length-1;i>=0;--i)
			if(A[i]>=A[max]) {
				max = i;
				bigger[max] = -1;
			} else
				bigger[i] = max;
		
		for(int i=0;i<A.length;++i)
			if(smaller[i]!=-1&&bigger[i]!=-1) {
				int[] r = new int[3];
				r[0] = A[smaller[i]];
				r[1] = A[i];
				r[2] = A[bigger[i]];
				return r;
			}
		return null;
	}
	
	public static void main(String[] args) {
		int[] A = {12, 11, 10, 5, 6, 2, 30};
		ArraysUtility.printArray(getsortedSubsequenceOfSize3(A));
	}
}
