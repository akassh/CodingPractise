package com.practice.challenge;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithEqual0N1 {
	public static int getLargestSubarray(int[] A) {
		assert(A!=null);
		int[] ls = new int[A.length];
		for(int i=0;i<A.length;++i) 
			if(i==0)
				ls[i] = A[i];
			else 
				ls[i] = ((A[i]==0) ? -1 : 1) + ls[i-1];
		int maxLen = 0;
		//int index = -1;
		Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
		for(int i=0;i<A.length;++i)
			if(ls[i]==0 && i+1>maxLen) {
				maxLen = i+1;
				//index = 0; 
			} else {
				if(visited.containsKey(ls[i])) {
					if(i-visited.get(ls[i]) > maxLen) {
						maxLen = i-visited.get(ls[i]);
						//index = visited.get(ls[i])+1;
					}
				}
				else 
					visited.put(ls[i], i);
			}
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] A = {1,0,1,1,1,0,0};
		System.out.println(getLargestSubarray(A));
	}
}
