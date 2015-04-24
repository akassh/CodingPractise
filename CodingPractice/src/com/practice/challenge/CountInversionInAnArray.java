package com.practice.challenge;

public class CountInversionInAnArray {
	public static int countInversion(int[] A) {
		int[] a = new int [A.length];
		for(int i=0;i<A.length;++i)
			a[i] = A[i];
		return mergeSort(a, 0, a.length-1);
	}
	
	private static int mergeSort(int[] a, int low, int high) {
		int invCount = 0;
		if(high > low) {
			int mid = (low+high)/2;
			invCount += mergeSort( a, low, mid);
			invCount += mergeSort( a, mid+1, high);
			invCount += merge(a, low, mid+1, high);
		}
		return invCount;
	}
	
	private static int merge(int[] a, int low, int mid, int high) {
		if(low>=high)
			return 0;
		int i=low;
		int j=mid;
		int invCount = 0;
		int count = 0;
		int[] temp = new int[high-low+1];
		while(i<=mid-1 && j<=high) {
			if(a[i]<=a[j])
				temp[count++] = a[i++];
			else {
				temp[count++] = a[j++];
				invCount += mid - i;
			}
		}
		while(i<=mid-1)
			temp[count++] = a[i++];
		while(j<=high)
			temp[count++] = a[j++];
		for(int p=low,q=0;p<=high;)
			a[p++] = temp[q++];
		return invCount;
	}
	
	public static void main(String[] args) {
		int[] A = {2, 4, 1, 3, 5};
		ArraysUtility.printArray(A);
		System.out.printf("Count Inverstion: %d\n", countInversion(A));
		
		
		int[] B = {4, 3, 2, 1};
		ArraysUtility.printArray(B);
		System.out.printf("Count Inverstion: %d\n", countInversion(B));
		
		
		int[] C = {5,3,2,4,1,6,8,12,9,10};
		ArraysUtility.printArray(C);
		System.out.printf("Count Inverstion: %d\n", countInversion(C));
		
		
	}
}
