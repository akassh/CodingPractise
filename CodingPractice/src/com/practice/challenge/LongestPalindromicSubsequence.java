package com.practice.challenge;

public class LongestPalindromicSubsequence {
	
	public static int getLongestPalindromicSubsequence(String s) {
		if(s==null||s.length()==0)
			return 0;
		int[][] p = new int[s.length()][s.length()];
		for(int i=0;i<p.length;++i)
			p[i][i] = 1;
		for(int k=0;k<p.length;++k)
			for(int i=0, j=k+1;i<p.length&&j<p[i].length ;++j,++i)
				if(s.charAt(i)==s.charAt(j))
					p[i][j] = p[i+1][j-1] + 2;
				else
					p[i][j] = Math.max(p[i+1][j],p[i][j-1]);
		return p[0][p.length-1];
	}
	
	public static void main(String[] args) {
		String s = "GEAEKEA";
		System.out.printf("Palindromic Subsequence of %s is %d", s, getLongestPalindromicSubsequence(s));
	}

}
