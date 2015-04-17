package com.practice.sorting;

import java.util.Random;

import com.practice.challenge.ArraysUtility;

public class QuickSort {
	public static void quickSort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	
	public static void randomizeQuickSort(int[] A) {
		randomizeQuickSort(A, 0, A.length-1);
	}
	
	public static void quickSort(int[] A, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			int partitionIndex = partition(A, low, high, mid);
			quickSort(A, low, partitionIndex-1);
			quickSort(A, partitionIndex+1, high);
		}
	}
	
	public static void randomizeQuickSort(int[] A, int low, int high) {
		if(low<high) {
			int index = low + (new Random(System.currentTimeMillis()).nextInt()%(high-low));
			int partitionIndex = partition(A, low, high, index);
			quickSort(A, low, partitionIndex-1);
			quickSort(A, partitionIndex+1, high);
		}
	}
	
	private static void swap(int[] A, int index1, int index2) {
		int temp = A[index1];
		A[index1] = A[index2];
		A[index2] = temp;
	}
	
	private static int partition(int[] A, int low, int high, int index) {
		swap(A, low, index);
		index = low;
		low = low+1;
		while(low<high) {
			while(A[index] >= A[low])
				++low;
			while(A[index] < A[high])
				--high;
			if(low < high)
				swap(A, low, high);
		}
		swap(A, high, index);
		return high;
	}
	
	public static void main(String[] args) {
		int[] a = { 6, 3 , 1, 8, 3, 5, 5, 4, 1};
		ArraysUtility.printArray(a);
		randomizeQuickSort(a);
		ArraysUtility.printArray(a);
	}
}
