/**
 * 
 * @author Akassh
 */
package com.practice.challenge;
import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumInAllSubArrayOfSizeK {
	
	public static void maximumInAllSubArrayOfSizeK(int[] A, int k) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=0; i<k; ++i) {
			if(!q.isEmpty() && A[q.peek()] < A[i])
				q.poll();
			q.add(i);
		}
		System.out.print( A[q.peek()] + " ");
		for(int i=k; i<A.length; ++i) {
			while(!q.isEmpty() && (A[q.peek()] < A[i] || i-k+1 > q.peek()))
				q.poll();
			q.add(i);
			System.out.print( A[q.peek()] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] a =  {1, 2, 3, 1, 4, 5, 2, 3, 6};
		ArraysUtility.printArray(a);
		maximumInAllSubArrayOfSizeK(a,4);
	}
}
