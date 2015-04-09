/**
 * @author Akassh
 */
package com.practice.challenge;

public class FindSmallestMissingInSortedArray {
	public static int findSmallestMissingInSortedArray(int[] A) {
		if(A==null||A.length==0)
			return -1;
		int low = 0;
		int high = A.length-1;
		while(true) {
			if(low>high)
				return high + 1;
			else {
				int mid = (low + high) / 2;
				if(low != A[low])
					return low;
				else if(mid < A[mid])
						high = mid - 1;
				else low = mid + 1;
			}
		}
	}
	
	public static void smallestMissingPrint(int[] a) {
		ArraysUtility.printArray(a);
		System.out.println("Smallest Missing in Sorted Array is : " + findSmallestMissingInSortedArray(a));
	}
	
	
	public static void main(String[] args) {
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 10};
		smallestMissingPrint(a);
		int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		smallestMissingPrint(b);
		int[] c = {0, 1, 2, 6, 9};
		smallestMissingPrint(c);
		int[] d = {4, 5, 10, 11};
		smallestMissingPrint(d);
		int[] e = {0, 1, 2, 3};
		smallestMissingPrint(e);
	}
}
