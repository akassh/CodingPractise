package com.practice.challenge;

import com.akassh.datastructure.Heap;

public class KLargestNSmallestInAnArray {
	public static int kthLargestInArray(int[] A, int k) {
		if(k<1||A==null||k>=A.length)
			throw new IllegalArgumentException("Given value cannot be negative or Larger than Array Size & Array cannot be null");
		Heap minHeap = new Heap(true);
		for(int i=0;i<A.length;++i) {
			if(i<k)
				minHeap.insert(A[i]);
			else if(A[i]>minHeap.top()) {
					minHeap.getMax();
					minHeap.insert(A[i]);
				}
		}
		return minHeap.getMax();
	}
	
	public static int kthSmallestInArray(int[] A, int k) {
		if(k<1||A==null||k>=A.length)
			throw new IllegalArgumentException("Given value cannot be negative or Larger than Array Size & Array cannot be null");
		Heap maxHeap = new Heap(false);
		for(int i=0;i<A.length;++i) {
			if(i<k)
				maxHeap.insert(A[i]);
			else if(A[i]<maxHeap.top()) {
				maxHeap.getMax();
				maxHeap.insert(A[i]);
			}
		}
		return maxHeap.getMax();
	}
	
	public static void main(String[] args) {
		int[] x = {-6, -6, 2, 2, 2, 10, 10, 10, -6, -6, 2, 2, 2, 2, 2};
		int[] a = {14, 13, 12, 11, 10,  9, 8, 7, 6, 5, 4, 3, 2, 1, 15};
		System.out.println(kthLargestInArray(a, 1));
		System.out.println(kthSmallestInArray(x, 2));
	}
}
