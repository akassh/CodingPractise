package com.practice.challenge;


import static org.junit.Assert.*;

import org.junit.Test;

public class MajorityElementInTheArray {
	public static int mooreVotingAlgorithm(int[] A) {
		if(A==null||A.length==0)
			return -1;
		int count = 1;
		int majIndex = 0;
		for(int i=1;i<A.length;++i) {
			if(A[majIndex]==A[i])
				++count;
			else 
				--count;
			if(count==0) {
				count = 1;
				majIndex = i;
			}				
		}
		count=0;
		for (int i : A)
			if(A[majIndex]==i)
				++count;
		
		return count > A.length/2 ? majIndex : -1;
	}
	
	@Test
	public void testCaseWithMajorityPresent() {
		int[] A = {3 ,3 ,4 ,2 ,4 ,4 ,2 ,4 ,4};
		assertEquals(4, A[mooreVotingAlgorithm(A)]);
	}
	
	@Test
	public void testCaseWithNoMajorityPresent() {
		int[] A = {3, 3, 4, 2, 4, 4, 2, 4};
		assertEquals(-1, mooreVotingAlgorithm(A));
	}

}
