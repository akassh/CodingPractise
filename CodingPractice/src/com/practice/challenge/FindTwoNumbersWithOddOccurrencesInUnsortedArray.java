/**
 * Given an unsorted array that contains even number of occurrences for all numbers except two numbers. 
 * Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.
 * 
 * @author Akassh
 */
package com.practice.challenge;

public class FindTwoNumbersWithOddOccurrencesInUnsortedArray {
	public static int[] findTwoNumbersWithOddOccurrencesInUnsortedArray(int[] A) {
		if(A==null || A.length==0)
			return null;
		int xor = 0;
		for (int i : A)
			xor ^= i;
		if(xor==0)
			return null;
		int b = (xor & -xor);
		int xor1=0,xor2=0;
		for (int i : A)
			if((i & b) == b)
				xor1 ^= i;
			else
				xor2 ^= i;
		int[] result = new int[2];
		result[0] = xor1;
		result[1] = xor2;
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {12, 23, 34, 12, 12, 23, 12, 45};
		ArraysUtility.printArray(A);
		System.out.print("-->");ArraysUtility.printArray(findTwoNumbersWithOddOccurrencesInUnsortedArray(A));
		
		int[] B = {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100};
		ArraysUtility.printArray(B);
		System.out.print("-->");ArraysUtility.printArray(findTwoNumbersWithOddOccurrencesInUnsortedArray(B));
		
		int[] C = {10, 20};
		ArraysUtility.printArray(C);
		System.out.print("-->");ArraysUtility.printArray(findTwoNumbersWithOddOccurrencesInUnsortedArray(C));
	}
}
