package com.practice.challenge;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberToLetters { 
	private static void getReverseMapping(String number, String prefix, String[] mapping, List<String> res) {
		if(prefix.length()==number.length())
			res.add(prefix);
		else
			for(int i=0; i<mapping[number.charAt(prefix.length())-'0'].length(); ++i)
				getReverseMapping(number, prefix+mapping[number.charAt(prefix.length())-'0'].charAt(i) , mapping, res);
	}
	
	public static List<String> getReverseMapping(String number) {
		String[] mapping = {" ","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
		List<String> result = new ArrayList<String>();
		getReverseMapping( number, "", mapping, result);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getReverseMapping("234"));
	}
}
