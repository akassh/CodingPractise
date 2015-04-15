package com.practice.challenge;

public class StringPermutation {
	public static void permutationWithRepetition(String str) { 
		permutationWithRepetition("", str); 
	}	

	private static void permutationWithRepetition(String prefix, String str) {
	    if (str.length() == prefix.length()) 
	    	System.out.println(prefix);
	    else
	        for (int i = 0; i < str.length(); i++)
	            permutationWithRepetition(prefix + str.charAt(i), str);
	}
	
	public static void permutation(String str) { 
    	permutation("", str); 
	}
	
	private static void permutation(String prefix, String str) {
	    if (str.length() == 0) 
	    	System.out.println(prefix);
	    else
	        for (int i = 0; i < str.length(); i++)
	            permutation(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
	}
	
	public static void main(String[] args) {
		permutation("AB");
		permutationWithRepetition("AB");
	}
}
