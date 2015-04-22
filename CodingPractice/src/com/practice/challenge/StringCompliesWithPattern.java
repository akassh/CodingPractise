package com.practice.challenge; 

public class StringCompliesWithPattern {
	
	private static boolean isNPresent(int n, String s) {
		if(s==null||s.isEmpty())
			return false;
		String ns = n+"";
		for(int i=0;i<ns.length();++i)
			if(ns.charAt(i)!=s.charAt(i))
				return false;
		return true;
	}
	
	public static boolean complies(String s) {
		if(s==null)
			throw new IllegalArgumentException("Input string is null.");
		if(s.isEmpty())
			return false;
		for(int i=0,ilen=1,jlen=1,j=i+ilen;i<s.length()-ilen&&(!s.substring(i, i+ilen).isEmpty())&&j<s.length()-jlen&&(!s.substring(j, j+jlen).isEmpty());) {
				int N2 = Integer.parseInt(s.substring(i, i+ilen));
				int N1 = Integer.parseInt(s.substring(j, j+jlen));
				if(N1<N2||!isNPresent(N1+N2, s.substring(j+jlen))) {
					if(j+jlen==s.length()-1) {
						++ilen;
						j=i+ilen;
						jlen = ilen;
					}
					else 
						++jlen;
					
				}
				else {
					++i;
					j=i+ilen;
					System.out.printf("N: %d, N1: %d, N2: %d\n", N1+N2, N1, N2);
					if(i+ilen+jlen+((N1+N2)+"").length()-1==s.length())
						return true;
				}
			}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(complies("1235813"));
		System.out.println(complies("224610"));
		System.out.println(complies("11112233558"));
		System.out.println(complies("1101102203"));
		System.out.println(complies("123456789"));
	}
}
