package com.practice.challenge;

public class BuildLowestNumberByRemovingNDigits {
	public static String getLowestNumberByRemovingNDigits(String s, int n) {
		if(s==null||s.length()==0||n>=s.length())
			return "";
		else if(n<=0)
			return s;
		else {
			int endIndex = Math.min(n+2, s.length());
			int smallCharacterIndex = 0;
			char smallChar = Character.isDigit(s.charAt(smallCharacterIndex)) ? s.charAt(0) : 0;
			for(int i=1;i<endIndex;++i)
				if(smallChar==0||!Character.isDigit(s.charAt(i)))
					throw new IllegalArgumentException("Invalid String input");
				else if(smallChar > s.charAt(i)){
					smallChar = s.charAt(i);
					smallCharacterIndex = i;
				}
			return smallChar + getLowestNumberByRemovingNDigits( s.substring(smallCharacterIndex+1),n-smallCharacterIndex);
		}
	}
	
	public static void main(String[] args) {
		String str = "121198";
	    int n = 2;
	    System.out.println(getLowestNumberByRemovingNDigits(str,n));
	}
}
