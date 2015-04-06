package com.practice.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpiralMatrix {
	
	public static void printMatrix(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int len) {
		int[][] spiral = new int[len][len];
		int l = 0;
		int k = 0;
		int m = len;
		int n = len;
		int count = 0;
		while(k < m && l < n) {
			for(int i=l; i<n; ++i) 
				spiral[k][i] = ++count;
			++k;
			
			for(int i=k; i<m; ++i) 
				spiral[i][n-1] = ++count;
			--n;
			
			if(k < m) {
				for(int i=n-1; i>=l; --i) 
					spiral[m-1][i] = ++count;
				--m;
			}
			
			if(l < n) {
				for(int i=m-1; i>=k; --i) 
					spiral[i][l] = ++count;
				++l;
			}
		}
		return spiral;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		for(int i=1; i<=n; i++){
			printMatrix(generateMatrix(i));
			System.out.println();
		}
	}
}
