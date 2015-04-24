package com.practice.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnakeNLadders {
	public static void printMatrix(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++)
				System.out.print(m[i][j] + "\t");
			System.out.println();
		}
	}
	
	public static int[][] generateMatrix(int len) {
		int[][] snl = new int[len][len];
		int k = 0;
		int count = len*len;
		while(k < len) {
			for(int i=0;i<len;++i)
				snl[k][i] = count--;
			++k;
			if(k < len) {
				for(int i=len-1;i>=0;--i)
					snl[k][i] = count--;
				++k;
			}
		}
		
		return snl;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		for(int i=1; i<=n; i++){
			printMatrix(generateMatrix(i));
			System.out.println();
		}
	}
}
