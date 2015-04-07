package com.practice.challenge;
/**
 * 
 * @author Akassh
 *
 */
public class BitonicSubArray {
	
	public static int bitonicSubArray(int[] A) {
		int[] inc = new int[A.length];
		int[] dec = new int[A.length];
		inc[0] = 1;
		for(int i=1; i<inc.length; ++i)
			if(A[i-1] < A[i])
				inc[i] = inc[i-1] + 1;
			else
				inc[i] = 1;
		
		dec[dec.length-1] = 1;
		for(int i=dec.length-2; i>=0; --i)
			if(A[i+1] < A[i])
				dec[i] = dec[i+1] + 1;
			else
				dec[i] = 1;
		int max = Integer.MIN_VALUE;	
		for(int i=0; i<inc.length; ++i) {
			if(max < inc[i] + dec[i])
				max = inc[i] + dec[i] - 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {20, 0, 1, 2, 3, 4, 2, 1};//{20, 4, 1, 2, 3, 4, 2, 10};
		for (int i : a)
			System.out.print(i + "\t");
		System.out.println();
		System.out.println(bitonicSubArray(a));
	}
}
