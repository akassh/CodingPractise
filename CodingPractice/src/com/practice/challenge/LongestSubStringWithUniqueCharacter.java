package com.practice.challenge;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithUniqueCharacter {
		public static int getLongestSubStringWithUniqueCharacterLength(String s) {
			if(s==null||s.isEmpty())
				return 0;
			int max = 0;
			int curr = 0;
			int prev = -1;
			Map<Character,Integer> visited = new HashMap<Character,Integer> (); 
			for(int i=0;i<s.length();++i) {
				prev = visited.containsKey(s.charAt(i)) ? visited.get(s.charAt(i)) : -1;
				if(prev==-1 || prev < i-curr)
					++curr;
				else {
					if(max < curr)
						max = curr;
					curr = i-curr;
				}
				visited.put(s.charAt(i), i);
			}
			if(max < curr)
				max = curr;
			return max;
		}
		
		public static String getLongestSubStringWithUniqueCharacter(String s) {
			if(s==null||s.isEmpty())
				return "";
			int max = 0;
			int curr = 0;
			int prev = -1;
			int endIndex = 0;
			Map<Character,Integer> visited = new HashMap<Character,Integer> (); 
			for(int i=0;i<s.length();++i) {
				prev = visited.containsKey(s.charAt(i)) ? visited.get(s.charAt(i)) : -1;
				if(prev==-1 || prev < i-curr)
					++curr;
				else {
					if(max < curr) {
						max = curr;
						endIndex =  i - curr-1;
					}
					curr = i-curr;
				}
				visited.put(s.charAt(i), i);
			}
			if(max < curr) {
				max = curr;
				endIndex =  s.length() - curr -1;
			}
			return s.substring(endIndex, endIndex+max);
		}
		
		public static void main(String[] args) {
			System.out.println(getLongestSubStringWithUniqueCharacterLength("GEEKSFORGEEKS"));
			System.out.println(getLongestSubStringWithUniqueCharacter("GEEKSFORGEEKS"));
			
			System.out.println(getLongestSubStringWithUniqueCharacterLength("AKASSHMISHRA"));
			System.out.println(getLongestSubStringWithUniqueCharacter("AKASSHMISHRA"));
		}
}
