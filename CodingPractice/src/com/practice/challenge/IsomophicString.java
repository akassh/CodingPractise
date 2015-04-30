package com.practice.challenge;

import java.util.HashMap;
import java.util.Map;

public class IsomophicString {
	public static boolean isIsomorphic(String s, String t) {
        return getHashCode(s).equals(getHashCode(t));
    }
    
    private static String getHashCode(String s) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();++i) {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), count++);
        }   
        StringBuilder result = new StringBuilder("");
        for(int i=0;i<s.length();++i) {
            int num = map.get(s.charAt(i));
            if(num < 10)
                result.append("0" + num);
            else 
                result.append(num);
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
		System.out.println("title " + getHashCode("title"));
	}
}
