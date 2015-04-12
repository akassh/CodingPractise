package com.practice.challenge;

public class MajorityElementInAnArray {
	int mooresVotingAlgorithm(int[] A) {
		int majority = 0;
		int count = 1;
		for(int i=1;i<A.length;++i) {
			if(A[i]==A[majority])
				++count;
			else 
				--count;
			if(count==0) {
				majority=i;
				count=1;
			}
		}
		count=0;
		for(int i=0;i<A.length;++i)
			if(A[i]==A[majority] && count < A.length/2)
				++count;
		return count==A.length/2 ? majority : -1;
	}
}
