package com.practice.challenge;

public class FindMinimumDistanceBetweenTwoGivenNumbers {
	public static int findMinimumDistanceBetweenTwoGivenNumbers(int[] A, int x, int y) {
		if(A==null)
			throw new IllegalArgumentException("Given Arrays is null");
		int prev = -1;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<A.length;++i)
			if(A[i]==x||A[i]==y)
				if(prev==-1)
					prev=i;
				else if(A[prev]==A[i]) 
					prev = i;
				else {
					if(min > i-prev)
						min = i-prev;
					prev = i;
				}
		return min;
	}
}
