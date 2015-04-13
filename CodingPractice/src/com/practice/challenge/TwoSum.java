/**
 * Two Sum problem
 * @author Akassh
 */
package com.practice.challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public static int[] twoSumProblemUsingHashSetReturnsNumber(int[] A, int sum) {
		if(A==null||A.length==0)
			return null;
		Set<Integer> s = new HashSet<Integer>();
		for (int i : A)
			if(s.contains(i)) {
				int[] result = new int[2];
				result[0] = i;
				result[1] = sum-i;
				return result;
			}
			else 
				s.add(sum-i);
		return null;	
	}
	
	public static int[] twoSumProblemUsingHashMapReturnsIndex(int[] A, int sum) {
		if(A==null||A.length==0)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i=0;i<A.length;++i)
			if(hm.containsKey(A[i])) {
				int[] result = new int[2];
				result[0] = i;
				result[1] = hm.get(A[i]);
				return result;
			}
			else
				hm.put(sum - A[i], i);
		return null;	
	}
	
	public static int[] twoSumProblemBySorting(int[] A, int sum) {
		if(A==null||A.length==0)
			return null;
		Arrays.sort(A);
		for (int l=0,h=A.length-1;l<h;) {
			if(A[l]+A[h]==sum) {
				int[] result = new int[2];
				result[0] = A[l];
				result[1] = A[h];
				return result;
			} else if(A[l] + A[h] < sum)
				++l;
			else 
				--h;				
		}
		return null;	
	}
	
	public static void main(String[] args) {
		int[] A = {2, 7, 11, 15};
		ArraysUtility.printArray(A);
		ArraysUtility.printArray(twoSumProblemUsingHashSetReturnsNumber(A, 9));
		ArraysUtility.printArray(twoSumProblemUsingHashMapReturnsIndex(A, 9));
		ArraysUtility.printArray(twoSumProblemBySorting(A, 9));
	}
	
}
