package com.practice.challenge;


public class ReplaceElementWithNextGreatest {
	public static void replaceElementWithNextGreatest(int[] A) {
		if(A==null || A.length==0)
			throw new IllegalArgumentException("Invalid Input A null or empty.");
		int greater = Integer.MIN_VALUE;
		for(int i=A.length-1;i>=0;--i) {
			int replace = (greater == Integer.MIN_VALUE) ? -1 : greater;
			if(greater < A[i])
				greater = A[i];
			A[i] = replace;
		}
	}
	
	public static void main(String[] args) {
		int[] a =  {16, 17, 4, 3, 5, 2};
		ArraysUtility.printArray(a);
		replaceElementWithNextGreatest(a);
		ArraysUtility.printArray(a);
	}
}
