package com.practice.challenge;

public class RotatedArray {
	public static int getMaximumElementIndexInRotatedArray(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input array is null or empty");
		int low = 0;
		int high = A.length-1;
		while(high > low) {
			int mid = (low+high)/2;
			if(mid < high && A[mid] > A[mid+1])
				return A[mid];
			else if(A[mid] > A[low])
				low = mid+1;
			else if(A[mid] < A[low])
				high = mid-1;
			else
				++low;
		}
		//System.out.println(low + " " + high);
		return A[high];
	}
	
	public static int getMinimumElementIndexInRotatedArray(int[] A) {
		if(A==null||A.length==0)
			throw new IllegalArgumentException("Input array is null or empty");
		int low = 0;
		int high = A.length-1;
		while(low < high) {
			int mid = (low+high)/2;
			if(mid > low && A[mid] < A[mid-1])
				return mid;
			else if(A[mid] > A[high])
				low = mid+1;
			else if(A[mid] < A[high])
				high = mid-1;
			else 
				--high;
		}
		//System.out.println(low + " " + high);
		return A[low];
	}
	
	
	
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6};
		ArraysUtility.printArray(A);
		System.out.println(getMaximumElementIndexInRotatedArray(A));
		System.out.println(getMinimumElementIndexInRotatedArray(A));
		int[] B = {4,5,6,1,2,3};
		ArraysUtility.printArray(B);
		System.out.println(getMaximumElementIndexInRotatedArray(B));
		System.out.println(getMinimumElementIndexInRotatedArray(B));
		int[] C = {2,2,2,3,1};
		ArraysUtility.printArray(C);
		System.out.println(getMaximumElementIndexInRotatedArray(C));
		System.out.println(getMinimumElementIndexInRotatedArray(C));
		int[] E = {1,2,3,4,5};
		ArraysUtility.printArray(E);
		System.out.println(getMaximumElementIndexInRotatedArray(E));
		System.out.println(getMinimumElementIndexInRotatedArray(E));
		int[] G = {3,1};
		ArraysUtility.printArray(G);
		System.out.println(getMaximumElementIndexInRotatedArray(G));
		System.out.println(getMinimumElementIndexInRotatedArray(G));
		int[] H = {3,0,1,1,1,3};
		ArraysUtility.printArray(H);
		System.out.println(getMaximumElementIndexInRotatedArray(H));
		System.out.println(getMinimumElementIndexInRotatedArray(H));
	}
}

