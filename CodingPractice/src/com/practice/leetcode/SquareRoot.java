package com.practice.leetcode;

public class SquareRoot {
	//Babylonian Method
	//float has more precision than double
	public static float sqrt(int n) {
		float x = n;
		float y = 1.0f;
		float e = 0.000001f; //Precision Value
		while(x-y > e) {
			x = (x+y)/2;
			y = n/x;
		}
		return x;
	}
	
	public static void main(String[] args) {
		for(int i=1; i<=50; ++i)
			System.out.println(" n = " + i + " Sqrt = " + sqrt(i));
	}
}
