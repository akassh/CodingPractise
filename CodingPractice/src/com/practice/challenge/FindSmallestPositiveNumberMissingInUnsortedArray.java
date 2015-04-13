/**
 * You are given an unsorted array with both positive and negative elements. 
 * You have to find the smallest positive number missing from the array in O(n) time using constant extra space. 
 * You can modify the original array.
 * Examples
 *  Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 *  Output: 1
 *  Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 *  Output: 4
 *  Input: {1, 1, 0, -1, -2}
 *  Output: 2 
 *  
 * 
 * @author Akassh
 */
package com.practice.challenge;

public class FindSmallestPositiveNumberMissingInUnsortedArray {
	public static int getSmallestPositiveNumberMissingInUnsortedArray(int[] A) {
		if(A==null||A.length==0)
			return -1;
		int low=0;
		int high=A.length-1;
		while(low<high) {
			while(A[low]>0)
				++low;
			while(A[high]<=0)
				--high;
			if(low < high) {
				int temp = A[low];
				A[low] = A[high];
				A[high] = temp;
			}
		}
		for(int i=0;i<=high;++i)
			if(Math.abs(A[i])-1>=0 && Math.abs(A[i])-1 < high)
				A[Math.abs(A[i])-1] *= A[Math.abs(A[i])-1] > 0 ? -1 : 1;
		int index=0;
		for(int i=0;i<=high;++i)
			if(A[i]>0) {
				index = i;
				break;
			}
				
		for(int i=0;i<=high;++i)
			A[i] *= A[i] > 0 ? 1 : -1;
		
		return index+1;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 3, 7, 6, 8, -1, -10, 15};
		ArraysUtility.printArray(A);
		System.out.println(getSmallestPositiveNumberMissingInUnsortedArray(A));
		int[] B = { 2, 3, -7, 6, 8, 1, -10, 15 };
		ArraysUtility.printArray(B);
		System.out.println(getSmallestPositiveNumberMissingInUnsortedArray(B));
		int[] C = {1, 1, 0, -1, -2};
		ArraysUtility.printArray(C);
		System.out.println(getSmallestPositiveNumberMissingInUnsortedArray(C));
		int[] D = {0, 10, 2, -10, -20};
		ArraysUtility.printArray(D);
		System.out.println(getSmallestPositiveNumberMissingInUnsortedArray(D));
	}
}
