package com.practice.challenge;
/**
 * @author Akassh
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Pair {
	int curr;
	int next;
	public int getCurr() {
		return curr;
	}
	public int getNext() {
		return next;
	}
	Pair(int curr, int next) {
		this.curr = curr;
		this.next = next;
	}
	@Override
	public String toString() {
		return String.format(" (%d, %d)", curr, next);
	}
}

public class RegularExpression {
	//* .
	
	private static int getLastState(String pattern) {
		int count =0;
		for (int i=0;i<pattern.length();++i)
			if(pattern.charAt(i)=='*')
				++count;
		return pattern.length() - 2*count;
	}
	
	private static String convertOneOrMoreToZeroOrMoreOccurrence(String pattern) {
		StringBuilder p = new StringBuilder(""); 
		for(int i=0;i<pattern.length();++i) {
			if(i+1< pattern.length() && pattern.charAt(i+1)=='?') {
				p.append(pattern.charAt(i) + "" + pattern.charAt(i) + "*");
				++i;
			}
			else 
				p.append(pattern.charAt(i));
		}
		return p.toString();
	}
	
	private static Map<Character, List<Pair>> generateStateMapping(String pattern) {
		Map<Character, List<Pair>> states = new HashMap<Character, List<Pair>>();
		int state = 0;
		pattern = convertOneOrMoreToZeroOrMoreOccurrence(pattern);
		for(int i=0;i<pattern.length();++i) {
			if(i+1< pattern.length() && pattern.charAt(i+1)=='*') {
				if(states.containsKey(pattern.charAt(i)))
					states.get(pattern.charAt(i)).add(new Pair(state,state));
				else {
					List<Pair> p = new ArrayList<Pair>();
					p.add(new Pair(state,state));
					states.put(pattern.charAt(i), p);
				}
				++i;
			} else {
				if(states.containsKey(pattern.charAt(i)))
					states.get(pattern.charAt(i)).add(new Pair(state,state+1));
				else {
					List<Pair> p = new ArrayList<Pair>();
					p.add(new Pair(state,state+1));
					states.put(pattern.charAt(i), p);
				}
				++state;
			}
		}
		//a.*c.*d (abcbcd)
		if(states.containsKey('.')) {
			List<Pair> dotPairList = states.get('.');
			Iterator<Character> iteratorOfChar = states.keySet().iterator();
			while(iteratorOfChar.hasNext()) {
				char p = iteratorOfChar.next();
				if(p!='.')
					states.get(p).addAll(dotPairList);
			}
		}
		
		return states;
	}
	
	private static boolean isMatch(String text, Map<Character, List<Pair>> states, int currState, int lastState) {
		if(text.isEmpty())
			return currState == lastState;
		char c = text.charAt(0);
		List<Pair> listOfPossibleStates = states.containsKey(c) ? states.get(c) : states.get('.');
		if(listOfPossibleStates==null)
			return false;
		for(Pair p : listOfPossibleStates) {
			if(p.getCurr()==currState && isMatch(text.substring(1), states, p.getNext(), lastState))
				return true;
		}
		return false;
	}

	public static boolean isMatch(String text, String pattern) {
		Map<Character, List<Pair>> states = generateStateMapping(pattern);
		int currState = 0;
		int lastState = getLastState(pattern);
		return isMatch(text, states, currState, lastState);
	}
	/**
	 * s = “abbbc”, p = “ab*c”
	 * s = “ac”, p = “ab*c”
	 * s = “abbc”, p = “ab*bbc”
	 * s = “abcbcd”, p = “a.*c.*d”
	 * @param args
	 */
	public static void main(String[] args) {
		/*System.out.println(isMatch("abbbc", "ab*c"));
		System.out.println(isMatch("ac", "ab*c"));
		System.out.println(isMatch("abbc", "ab*bbc"));*/
		//System.out.println(isMatch("abcdbcd", "a.*c.*d"));
		//System.out.println(isMatch("aaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
		System.out.println(convertOneOrMoreToZeroOrMoreOccurrence("a?b?c*"));
		//System.out.println(isMatch("aaaaaaa", "a*"));
		//System.out.println(generateStateMapping("a*b*c*") + "\n States : " + getLastState("a*b*c*") );
		//System.out.println(generateStateMapping("a.*c.*d") + "\n States : " + getLastState("a.*c.*d") );
	}
}
