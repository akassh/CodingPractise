/**
 * @author Akassh
 */
package com.practice.challenge;

public class FindSmallestMissingInSortedArray {
	
	//Non-negative from 0
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
	
	//Only Positive from 1
	public static int findSmallestMissingPositiveNumberInSortedArray(int[] A) {
		if(A==null||A.length==0)
			return -1;
		int low = 0;
		int high = A.length-1;
		while(true) {
			if(low>high)
				return high + 2;
			else {
				int mid = (low + high) / 2;
				if(low+1 != A[low])
					return low+1;
				else if(mid+1 < A[mid])
						high = mid - 1;
				else low = mid + 1;
			}
		}
	}
	
	public static void smallestMissingPrint(int[] a) {
		ArraysUtility.printArray(a);
		System.out.println("Smallest Missing Non-negative in Sorted Array is : " + findSmallestMissingInSortedArray(a));
	}
	
	public static void smallestMissingPrint1(int[] a) {
		ArraysUtility.printArray(a);
		System.out.println("Smallest Missing positive in Sorted Array is : " + findSmallestMissingPositiveNumberInSortedArray(a));
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
		
		System.out.println();
		
		int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 10};
		smallestMissingPrint1(a1);
		int[] b1 = { 1, 2, 3, 4, 5, 6, 7, 8};
		smallestMissingPrint1(b1);
		int[] c1 = { 1, 2, 6, 9};
		smallestMissingPrint1(c1);
		int[] d1 = { 4, 5, 10, 11};
		smallestMissingPrint1(d1);
		int[] e1 = { 1, 2, 3};
		smallestMissingPrint1(e1);
	}
}
