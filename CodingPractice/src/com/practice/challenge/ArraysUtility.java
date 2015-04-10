package com.practice.challenge;

public class ArraysUtility {
	public static void printArray(int[] a) {
		if(a==null||a.length==0)
			return;
		for (int i : a)
			System.out.print( i + " ");
		System.out.println();
	}
}
