package com.practice.challenge;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	public static int[] getNextGreaterElement(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input Array is empty or null.");
		int[] nge = new int[A.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0;i<A.length;++i)
			if(s.isEmpty()||A[s.peek()] > A[i])
				s.push(i);
			else if(A[s.peek()] < A[i]) {
				while(!s.isEmpty() &&A[s.peek()] < A[i])
					nge[s.pop()] = A[i];
				s.push(i);
			}
		while(!s.isEmpty())
			nge[s.pop()] = -1;
		return nge;
	}
	
	public static void main(String[] args) {
		int[] A = {0,5,6,1,2,3,7};
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(getNextGreaterElement(A)));
		
	}
}
