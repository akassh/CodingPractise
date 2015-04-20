/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
 * For example, if length of the rod is 8 and the values of different pieces are given as following, 
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * 
 * @author Akassh
 */
package com.practice.challenge;

public class CuttingRod {
	public static int cuttingRodMaximumPrice(int[] price, int size) {
		if(price==null || price.length==0 || size==0)
			return 0;
		int[] val = new int[size+1];
		val[0] = 0;
		for(int i=1,max = Integer.MIN_VALUE;i<val.length;val[i++] = max)
			for(int j=0;j<i;++j)
				if(max < (price[j] + val[i-j-1]))
					max = price[j] + val[i-j-1];
		return val[size];
	}
	
	public static void main(String[] args) {
		int[] p = {1, 5, 8, 9, 10, 17, 17, 20}; 
		System.out.println(cuttingRodMaximumPrice(p, 8));
	}
}
