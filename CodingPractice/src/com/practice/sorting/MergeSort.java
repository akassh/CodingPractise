package com.practice.sorting;

import com.practice.challenge.ArraysUtility;

public class MergeSort {
	
	public static void sort(int[] A) {
		mergeSort(A, 0, A.length-1);
	}
	
	private static void mergeSort(int[] a, int low, int high) {
		if(high > low) {
			int mid = (low+high)/2;
			mergeSort( a, low, mid);
			mergeSort( a, mid+1, high);
			merge(a, low, mid+1, high);
		}
	}
	
	private static void merge(int[] a, int low, int mid, int high) {
		if(low>=high)
			return;
		int i=low;
		int j=mid;
		int count = 0;
		int[] temp = new int[high-low+1];
		while(i<=mid-1 && j<=high) {
			if(a[i]<=a[j])
				temp[count++] = a[i++];
			else 
				temp[count++] = a[j++];
		}
		while(i<=mid-1)
			temp[count++] = a[i++];
		while(j<=high)
			temp[count++] = a[j++];
		for(int p=low,q=0;p<=high;)
			a[p++] = temp[q++];
	}
	
	public static void main(String[] args) {
		int[] A = {2, 4, 1, 3, 5};
		ArraysUtility.printArray(A);
		sort(A);
		ArraysUtility.printArray(A);
		
		int[] B = {4, 3, 2, 1};
		ArraysUtility.printArray(B);
		sort(B);
		ArraysUtility.printArray(B);
		
		
		int[] C = {5,3,2,4,1,6,8,12,9,10};
		ArraysUtility.printArray(C);
		sort(C);
		ArraysUtility.printArray(C);
		
	}

}
