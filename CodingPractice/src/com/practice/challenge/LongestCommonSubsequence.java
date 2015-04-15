package com.practice.challenge;

public class LongestCommonSubsequence {
	public static String getLongestCommonSubsequence(String s1, String s2) {
		if(s1==null||s2==null)
			return null;
		if(s1.isEmpty()||s2.isEmpty())
			return "";
		int[][] lcsMatrix = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<lcsMatrix.length;++i)
			for(int j=1;j<lcsMatrix[i].length;++j)
				if(s1.charAt(i-1)==s2.charAt(j-1))
					lcsMatrix[i][j] = lcsMatrix[i-1][j-1]+1;
				else 
					lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j],lcsMatrix[i][j-1]);
		int p = s1.length();
		int q = s2.length();
		StringBuilder r = new StringBuilder("");
		while( p>0 && q>0) {
			while(lcsMatrix[p][q]==lcsMatrix[p][q-1])
				--q;
			while(lcsMatrix[p][q]==lcsMatrix[p-1][q])
				--p;
			if(lcsMatrix[p][q]==lcsMatrix[p-1][q-1]+1) {
				--p;
				--q;
				r.append(s1.charAt(p));	
			}
		}
		return r.reverse().toString();
	}
	
	public static int getLongestCommonSubsequenceLength(String s1, String s2) {
		if(s1==null||s2==null||s1.isEmpty()||s2.isEmpty())
			return 0;
		int[][] lcsMatrix = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<lcsMatrix.length;++i)
			for(int j=1;j<lcsMatrix[i].length;++j)
				if(s1.charAt(i-1)==s2.charAt(j-1))
					lcsMatrix[i][j] = lcsMatrix[i-1][j-1]+1;
				else 
					lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j],lcsMatrix[i][j-1]);
		return lcsMatrix[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(getLongestCommonSubsequence("ABCDGH", "AEDFHR"));
		System.out.println(getLongestCommonSubsequenceLength("ABCDGH", "AEDFHR"));
		System.out.println(getLongestCommonSubsequence("AGGTAB", "GXTXAYB"));
		System.out.println(getLongestCommonSubsequenceLength("AGGTAB", "GXTXAYB"));
	}
}
