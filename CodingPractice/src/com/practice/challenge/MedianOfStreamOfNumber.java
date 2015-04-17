package com.practice.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.akassh.datastructure.Heap;

public class MedianOfStreamOfNumber {
	private static Heap left = new Heap(false);
	private static Heap right = new Heap(true);
	private static double effectiveMedian;
	
	public static double getMedian(int x) {
		
		int balanceFactor = Heap.balanced(left, right);
		
		switch(balanceFactor) {
			case -1	: 	if(effectiveMedian > x)
							left.insert(x);
						else {
							left.insert(right.getMax());
							right.insert(x);
						}
						effectiveMedian = (double)((right.top() + left.top()))/ 2;
						break;
			case 0	:	if(effectiveMedian < x) {
							right.insert(x);
							effectiveMedian = right.top();
						} else {
							left.insert(x);
							effectiveMedian = left.top();
						}
						break;
			case 1	:	if(effectiveMedian < x)
							right.insert(x);
						else {
							right.insert(left.getMax());
							left.insert(x);
						}
						effectiveMedian = (double)((right.top() + left.top()))/ 2;
		}
		return effectiveMedian;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		int x;
		do {
			System.out.print("Enter the Number: ");
			x = Integer.parseInt(bw.readLine());
			System.out.println(getMedian(x));
		}while(x>=0);
		bw.close();
	}
}
