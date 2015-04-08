package com.practice.challenge;

public class BitonicArrayMaximumElement {
	//O(log n)
	public static int findMaximumElementInBitonicArray(int[] a) {
		if(a==null || a.length==0)
			return -1;
		if(a.length==1)
			return 0;
		int low = 0;
		int high = a.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(low==high)
				return low;
			else if(low+1 == high && a[low] > a[high])
				return low;
			else if(low+1 == high && a[low] < a[high])
				return high;
			else if(a[mid-1] < a[mid] && a[mid] > a[mid+1])
				return mid;
			else if(a[mid-1] < a[mid] && a[mid] < a[mid+1])
				low = mid+1;
			else if(a[mid-1] > a[mid] && a[mid] > a[mid+1])
				high = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};//{10, 20, 30, 40, 50};//{1, 3, 50, 10, 9, 7, 6};//{120, 100, 80, 20, 0};//
		ArraysUtility.printArray(a);
		System.out.println((findMaximumElementInBitonicArray(a)!=-1 ? a[findMaximumElementInBitonicArray(a)] : -1) + ", Element at position : " + findMaximumElementInBitonicArray(a));
	}
}
