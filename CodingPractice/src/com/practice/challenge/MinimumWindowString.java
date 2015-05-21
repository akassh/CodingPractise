package com.practice.challenge;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class MinimumWindowString {
	public static String findMinimumWindow(String str, String p) {
		String minLenString = null;
		int minWindow = Integer.MAX_VALUE;
		Map<Character, Integer> needToFill = new HashMap<Character, Integer>();
		Map<Character, ArrayDeque<Integer>> qMap = new HashMap<Character, ArrayDeque<Integer>>();
		for(int i=0;i<p.length();++i)
			if(needToFill.containsKey(p.charAt(i)))
				needToFill.put(p.charAt(i), needToFill.get(p.charAt(i)+1));
			else {
				needToFill.put(p.charAt(i), 1);
				qMap.put(p.charAt(i), new ArrayDeque<Integer>());
			}
		
		ConcurrentSkipListMap<Integer, Character> indexes = new ConcurrentSkipListMap<Integer, Character>();
		for(int i=0;i<str.length();++i) {
			if(!needToFill.containsKey(str.charAt(i)))
				continue;
			if(qMap.get(str.charAt(i)).size() < needToFill.get(str.charAt(i))) {
				qMap.get(str.charAt(i)).add(i);
				indexes.put(i, str.charAt(i));
			}
			else {
				int idxToRemove = qMap.get(str.charAt(i)).remove();
				indexes.remove(idxToRemove);
				qMap.get(str.charAt(i)).add(i);
				indexes.put(i, str.charAt(i));
			}
			if(indexes.size()==p.length()) {
				int start = indexes.firstKey();
				int end = indexes.lastKey();
				if(minWindow > end-start+1) {
					minWindow = end-start+1;
					minLenString = str.substring(start, end+1);
				}
			}
		}
		return minLenString;
	}
	
	public static void main(String[] args) {
		System.out.println(findMinimumWindow("ADOBECODEBANC", "CE"));
	}
}
