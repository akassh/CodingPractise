package com.practice.challenge;

public class FindSubArrayWithGivenSum {
	public static int[] findSubArrayWithGivenSum (int[] A, int sum) {
		if(A==null||A.length==0)
			return null;
		int start = 0;
		int currSum = A[start];
		for(int i=1;i<A.length;++i) {
			while(start < i && currSum > sum) {
				currSum -= A[start++];
			}
			if(start==i){
				if(sum==A[start]) {
					int[] result = new int[2];
					result[0] = start;
					result[1] = start;
					return result;
				}
				break;
			}
			else if(currSum==sum) {
				int[] result = new int[2];
				result[0] = start;
				result[1] = i-1;
				return result;
			} 
			currSum += A[i]; 
		}
		return null;
	}
}
