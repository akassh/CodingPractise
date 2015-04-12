package com.practice.challenge;

public class ArraysUtility {
	public static void printArray(int[] a) {
		if(a==null||a.length==0) {
			System.out.println();
			return;
		}
		for (int i : a)
			System.out.print( i + " ");
		System.out.println();
	}
	
	public static void printArray(Integer[] a) {
		if(a==null||a.length==0) {
			System.out.println();
			return;
		}
		for (int i : a)
			System.out.print( i + " ");
		System.out.println();
	}
	
	public static void printMatrix(int[][] m) {
		if(m==null||m.length==0) {
			System.out.println();
			return;
		}
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}
	
}
