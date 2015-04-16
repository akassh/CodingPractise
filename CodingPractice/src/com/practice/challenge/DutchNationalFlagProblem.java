package com.practice.challenge;

public class DutchNationalFlagProblem {
	public static void sortTheThreeColors(int[] A) {
		if(A==null||A.length==0)
			return;
		int low = 0;
		int mid = 0;
		int high = A.length-1;
		while(mid < high && low <= mid) {
			switch(A[mid]) {
				case	0 	: 	int t = A[mid];
								A[mid++] = A[low];
								A[low++] = t;
								break;
				case	1	:	++mid;
								break;
				case	2	:	t = A[mid];
								A[mid] = A[high];
								A[high--] = t;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 2, 1, 2, 2, 1, 1};
		ArraysUtility.printArray(a);
		sortTheThreeColors(a);
		ArraysUtility.printArray(a);
	}
}
