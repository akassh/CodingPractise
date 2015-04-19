package com.practice.challenge;

import java.util.ArrayList;
import java.util.List;

public class AllCombinationOfBalancedBraces {
	
	public static void printAllCombinationOfBalancedBraces(int n) {
		printAllCombinationOfBalancedBraces("", n, 0, 0);
	}
	
	private static void printAllCombinationOfBalancedBraces(String s, int n, int open, int close) {
		if(close==n)
			System.out.println(s);
		if(open>close)
			printAllCombinationOfBalancedBraces(s + '}', n, open, close+1);
		if(open<n)
			printAllCombinationOfBalancedBraces(s + '{', n, open+1, close);
	}
	
	public static List<String> getAllCombinationOfBalancedBraces(int n) {
		List<String> list = new ArrayList<String>();
		getAllCombinationOfBalancedBraces("", n, 0, 0, list);
		return list;
	}
	
	private static void getAllCombinationOfBalancedBraces(String s, int n, int open, int close, List<String> list) {
		if(close==n)
			list.add(s);
		if(open>close)
			getAllCombinationOfBalancedBraces(s + '}', n, open, close+1, list);
		if(open<n)
			getAllCombinationOfBalancedBraces(s + '{', n, open+1, close, list);
	}
	
	public static void main(String[] args) {
		printAllCombinationOfBalancedBraces(4);
		System.out.println(getAllCombinationOfBalancedBraces(4));
	}
}
