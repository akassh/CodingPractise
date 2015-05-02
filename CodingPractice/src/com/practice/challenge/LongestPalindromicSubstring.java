package com.practice.challenge;

public class LongestPalindromicSubstring {
	private static String expandAtCenter(String s, int l, int r) {
		if(s.isEmpty())
			return s;
		while(l>=0 && r < s.length() && s.charAt(l)==s.charAt(r)) {
			--l;
			++r;
		}
		return s.substring(l+1, r);
	}
	
	public static String getLongestPalindromicSubstring(String str) {
		if(str==null)
			throw new IllegalArgumentException("String argument provided is null.");
		String longestPalindrome = null;
		for(int i=0;i<str.length();++i) {
			String odd = expandAtCenter(str, i, i);
			if(longestPalindrome == null || odd.length() > longestPalindrome.length())
				longestPalindrome = odd;
			String even = expandAtCenter(str, i, i+1);
			if(longestPalindrome == null || even.length() > longestPalindrome.length())
				longestPalindrome = even;
		}
		return longestPalindrome;
	}
	
	public static void main(String[] args) {
		System.out.println("->"+getLongestPalindromicSubstring("a"));
		//System.out.println("->"+getLongestPalindromicSubstring("asasshmishra"));
	}
}
