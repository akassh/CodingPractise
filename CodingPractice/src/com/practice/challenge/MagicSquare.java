/**
 * @author Akassh
 */
package com.practice.challenge;

public class MagicSquare {
	/**
	 * Algo 
	 * move i+1, j+1 if that cell is not filled
	 * 		else move i-1, j
	 * @param n
	 * @return
	 */
	public static int[][] generateMagicSquare(int n) {
		int[][] magicSquare = new int[n][n];
		for(int c=1,i=n-1,j=n/2;c<=n*n;++c) {
			magicSquare[i][j] = c;
			if(magicSquare[(i+1)%n][(j+1)%n]==0) {
				i = (i+1)%n;
				j = (j+1)%n;
			} 
			else 
				i = (i-1) < 0 ? n-1 : i-1;
		}
		return magicSquare;
	}
	
	public static void main(String[] args) {
		int n = 5;
		ArraysUtility.printMatrixTab(MagicSquare.generateMagicSquare(n));
	}
}
