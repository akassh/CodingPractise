package com.practice.challenge;

public class EditDistance {
	public static int getEditDistance(String s1, String s2) {
		assert(s1!=null && s2!=null);
		int[][] ed = new int[s1.length()+1][s2.length()+1];
		for(int i=0;i<=s1.length();++i)
			for(int j=0;j<=s2.length();++j)
				if(i==0||j==0)
					ed[i][j] = i+j;
				else
					ed[i][j] = min(	 ed[i-1][j] + 1
									,ed[i][j-1] + 1
									,ed[i-1][j-1] + (s1.charAt(i-1)!=s2.charAt(j-1) ? 1:0));
		return ed[s1.length()][s2.length()];
	}
	
	private static int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
	public static void main(String[] args) {
		System.out.println(EditDistance.getEditDistance("hit", "dog"));
	}
}
