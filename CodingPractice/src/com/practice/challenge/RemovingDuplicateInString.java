package com.practice.challenge;

public class RemovingDuplicateInString {
	public static String getStringWithUniqueCharacters(String s) {
		long[] map = new long[3];
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<s.length();++i) {
			if((map[s.charAt(i)/63] & 1 << s.charAt(i)%63)==0) {
				map[s.charAt(i)/63] = map[s.charAt(i)/63] | 1 << s.charAt(i)%63;
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	/*
	public static String removeCharacterInStringIfPresentInSecondString(String s1, String s2) {
		
	}*/
	
	public static String getDuplicatesWithinTheString(String s) {
		long[] map = new long[3];
		long[] map2 = new long[3];
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<s.length();++i) {
			if((map[s.charAt(i)/63] & 1 << s.charAt(i)%63)==0) {
				map[s.charAt(i)/63] = map[s.charAt(i)/63] | 1 << s.charAt(i)%63;
			} else if((map2[s.charAt(i)/63] & 1 << s.charAt(i)%63)==0){
				map2[s.charAt(i)/63] = map2[s.charAt(i)/63] | 1 << s.charAt(i)%63;
				sb.append(s.charAt(i));
			}
				
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getStringWithUniqueCharacters("%%%$%^@#!@@#erwerssdfsf@!@#!@_+_+{}::#!#KLJLK"));
		System.out.println(getDuplicatesWithinTheString("%%%$%^@#!@@#erwerssdfsf@!@#!@_+_+{}::#!#KLJLK"));
	}
}
