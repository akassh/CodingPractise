package com.practice.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysTestCases {
	
/*	//Find Sub-Array With Given Sum
	@Test
	public void testSubArrayExistInMiddle() {
		int[] a = {1, 4, 20, 3, 10, 5};
		int[] result = {2,4};
		//ArraysUtility.printArray(a);
		//ArraysUtility.printArray(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 33));
		assertArrayEquals(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 33), result);
	}
	
	@Test
	public void testSubArrayExistOfSingleElement() {
		int[] a = {1, 3, 1, 1, 7, 10, 5};
		int[] result = {4,4};
		//ArraysUtility.printArray(a);
		//ArraysUtility.printArray(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 7));
		assertArrayEquals(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 7), result);
	}

	@Test
	public void testSubArrayDoestNotExist() {
		int[] a = {3, 4};
		//ArraysUtility.printArray(a);
		//ArraysUtility.printArray(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 0));
		assertNull("Sub-Array Doest Not Exist", FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 0));
	}*/
	
	//Find Minimum Distance Between Two Given Numbers
	@Test(expected=IllegalArgumentException.class)
	public void testWithNullArray() {
		int[] A = null;
		//ArraysUtility.printArray(A);
		FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 1, 2);
	}
	
	@Test
	public void testWithEmptyArray() {
		int[] A = {};
		//ArraysUtility.printArray(A);
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 1, 2), Integer.MAX_VALUE);
	}
	
	@Test
	public void testWithElementsNotInArray() {
		int[] A = {1,2,3,4,5};
		//ArraysUtility.printArray(A);
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 6, 7), Integer.MAX_VALUE);
	}
	
	@Test
	public void testWithOneElementNotInArray() {
		int[] A = {1,2,3,4,5};
		//ArraysUtility.printArray(A);
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 2, 7), Integer.MAX_VALUE);
	}
	
	@Test
	public void testWithoutDuplicates() {
		int[] A = {1, 2};
		//ArraysUtility.printArray(A);
		//System.out.println("Distance: " + FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 1, 2));
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 1, 2),1);
	}
	
	@Test
	public void testWithoutDuplicates2() {
		int[] A = {3, 4, 5};
		//ArraysUtility.printArray(A);
		//System.out.println("Distance: " + FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 3, 5));
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 3, 5),2);
	}
	
	@Test
	public void testWithDuplicates() {
		int[] A = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		//ArraysUtility.printArray(A);
		//System.out.println("Distance: " + FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 3, 6));
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 3, 6),4);
	}
	
	@Test
	public void testWithDuplicates2() {
		int[] A = {2, 5, 3, 5, 4, 4, 2, 3};
		//ArraysUtility.printArray(A);
		//System.out.println("Distance: " + FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 3, 2));
		assertEquals(FindMinimumDistanceBetweenTwoGivenNumbers.findMinimumDistanceBetweenTwoGivenNumbers(A, 3, 2),1);
	}
}
