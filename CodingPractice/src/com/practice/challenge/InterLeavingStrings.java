package com.practice.challenge;

import java.util.ArrayList;
import java.util.List;

public class InterLeavingStrings {

	public void printInterLeavingOfTwoString(String s1, String s2) {
		if(s1==null||s2==null)
			throw new IllegalArgumentException(" String parameters cannot be null!!!");
		printInterLeavingOfTwoString(s1, s2, 0, 0, "");
	}
	
	public String[] getListOfInterLeavingOfTwoString(String s1, String s2) {
		if(s1==null||s2==null)
			throw new IllegalArgumentException(" String parameters cannot be null!!!");
		List<String> interLeavedList = new ArrayList<String>();
		getListOfInterLeavingOfTwoString( s1, s2, 0, 0, "", interLeavedList);
		return interLeavedList.toArray(new String[interLeavedList.size()]);
	}
	
	private void printInterLeavingOfTwoString(String s1, String s2, int i, int j, String interLeavedString) {
		if(i==s1.length() && j==s2.length())
			System.out.println(interLeavedString);
		if(i != s1.length())
			printInterLeavingOfTwoString( s1, s2, i+1, j, interLeavedString + s1.charAt(i));
		if(j!=s2.length())
			printInterLeavingOfTwoString( s1, s2, i, j+1, interLeavedString + s2.charAt(j));
	}	
	
	private void getListOfInterLeavingOfTwoString(String s1, String s2, int i, int j, String interLeavedString, List<String> interLeavedList) {
		if(interLeavedList==null)
			return;
		if(i==s1.length() && j==s2.length())
			interLeavedList.add(interLeavedString);
		if(i != s1.length())
			getListOfInterLeavingOfTwoString( s1, s2, i+1, j, interLeavedString + s1.charAt(i), interLeavedList);
		if(j!=s2.length())
			getListOfInterLeavingOfTwoString( s1, s2, i, j+1, interLeavedString + s2.charAt(j), interLeavedList);
	}
	
	/**
	 * Fails for few cases
	 * @param s1
	 * @param s2
	 * @param check
	 * @return
	 */
	public boolean isInterLeavingOfTwoStringNotValidForRepeatingString(String s1, String s2, String check) {
		int j=0;
		int k=0;
		for(int i=0;i<check.length();++i)
			if(j < s1.length() && check.charAt(i)==s1.charAt(j))
				j++;
			else if(k < s2.length() && check.charAt(i)==s2.charAt(k))
				k++;
			else 
				return false;
		return (j == s1.length() && k == s2.length());
	}
	
	public boolean isInterLeavingOfTwoStringDynamicProgramming(String s1, String s2, String c) {
		if(s1==null||s2==null||c==null)
			return false;
		if(s1.isEmpty() && s2.isEmpty() && c.isEmpty())
			return true;
		if(s1.length() + s2.length() != c.length())
			return false;
		boolean[][] m = new boolean[s1.length()+1][s2.length()+1];
		for(int i=0;i<=s1.length();++i)
			for(int j=0;j<=s2.length();++j) {
				if(i==0 && j==0)
					m[i][j] = true;
				else if(i==0 && j<=s2.length() && s2.charAt(j-1)==c.charAt(j-1))
					m[i][j] = m[i][j-1];
				else if(j==0 && i<=s1.length() && s1.charAt(i-1)==c.charAt(i-1))
					m[i][j] = m[i-1][j];
				else if(i>=1 && j>=1 && i<=s1.length() && j<=s2.length()) {
					if(s1.charAt(i-1)==c.charAt(i+j-1) && s2.charAt(j-1)!=c.charAt(i+j-1))
						m[i][j] = m[i-1][j];
					else if(s1.charAt(i-1)!=c.charAt(i+j-1) && s2.charAt(j-1)==c.charAt(i+j-1) )
						m[i][j] = m[i][j-1];
					else if(s1.charAt(i-1)==c.charAt(i+j-1) && s2.charAt(j-1)==c.charAt(i+j-1) )
						m[i][j] = m[i][j-1] || m[i-1][j] ;
				}
					
			}
		return m[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		InterLeavingStrings s = new InterLeavingStrings();
		s.printInterLeavingOfTwoString("AB", "CD");
		ArraysUtility.printArray(s.getListOfInterLeavingOfTwoString("AB", "CD"));
		System.out.println(s.isInterLeavingOfTwoStringDynamicProgramming("", "B", "B"));
	}
}
