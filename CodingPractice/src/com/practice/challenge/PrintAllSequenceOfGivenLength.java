package com.practice.challenge;

import java.util.Arrays;

/**
 * Print all sequences of given length
 * Given two integers k and n, 
 * write a function that prints all the sequences of length k 
 * & composed of numbers 1,2..n. 
 * You need to print these sequences in sorted order
 * 
 * @author Akassh
 *
 */
public class PrintAllSequenceOfGivenLength {
	
	public static void printAllSequenceOfGivenLength(int k, int n) {
		if(k<=0 || n<=0)
			return;
		int[] a = new int[k];
		Arrays.fill(a, 1);
		boolean flag=true;
		while(flag) {
			ArraysUtility.printArray(a);
			for(int i=k-1;i>=0;--i,flag=false)
				if(a[i] < n) {
					++a[i];
					Arrays.fill(a, i+1, k, 1);
					flag = true;
					break;
				}
		}
	}
	
	public static void main(String[] args) {
		printAllSequenceOfGivenLength(3,4);
	}
}
