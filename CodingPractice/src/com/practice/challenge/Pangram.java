package com.practice.challenge;
import java.util.*;

public class Pangram {

    public static void main(String[] args) {
        long l = 0;
        Scanner kbd = new Scanner(System.in);
        String s = "We promptly judged antique ivory buckles for the next prize";//kbd.next();
        kbd.close();
        s = s.toUpperCase();
        for(int i=0;i<s.length();i++) {
        	if(Character.isLetter(s.charAt(i)))
            	l = l | (1 << (s.charAt(i) - 65));
        }
        int count = 0;
        while(l > 0){
            l = l & (l-1);
            ++count;
        }
        System.out.println( count==26 ?  "pangram" : "not pangram");
    }
}