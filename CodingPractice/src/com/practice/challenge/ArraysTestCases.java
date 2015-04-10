package com.practice.challenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysTestCases {
	@Test
	public void testSubArrayExistInMiddle() {
		int[] a = {1, 4, 20, 3, 10, 5};
		int[] result = {2,4};
		assertArrayEquals(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 33), result);
	}
	
	@Test
	public void testSubArrayExistOfSingleElement() {
		int[] a = {1, 3, 1, 1, 7, 10, 5};
		int[] result = {4,4};
		assertArrayEquals(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 7), result);
	}

	@Test
	public void testSubArrayDoestNotExist() {
		int[] a = {1, 4};
		int[] result = null;
		assertArrayEquals(FindSubArrayWithGivenSum.findSubArrayWithGivenSum(a, 0), result);
	}
}
