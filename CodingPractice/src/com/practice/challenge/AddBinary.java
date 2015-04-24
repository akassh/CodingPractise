package com.practice.challenge;

public class AddBinary {
	public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        boolean flag = false;
        String s = "";
        while(i >= 0 && j >= 0) {
            if(a.charAt(i) == b.charAt(j)) {
            	s = flag ? "1" + s : "0" + s;
                flag = a.charAt(i) == '1';
            }
            else if(a.charAt(i)!=b.charAt(j))
            	s = flag ? "0" + s : "1" + s;
            --i;
            --j;
        }
        int k = i > j ? i : j;
        String r = i > j ? a : b;
        while(k >= 0) {
            s = r.charAt(k) == (flag ? '1' : '0') ? "0" + s : "1" + s;
            flag = r.charAt(k) == '1';
            --k;
        } 
        s = s.charAt(0) == '0' && s.length() > 1 ? s.substring(1,s.length()) : s;
        s = (flag ? "1" + s : s);
        return s;
    }
	
	public static void main(String[] args) {
		String s1 = "11";//"100"
		String s2 = "1";//"110010"
		System.out.println(s1 + " + " + s2 + " = " + addBinary(s1,s2));
	}
}
