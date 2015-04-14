package com.practice.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSetUsingGosperHack {
	/**
	 * int set = (1 << k) - 1;
	 * int limit = (1 << n);
	 * while (set < limit) {
	 *     doStuff(set);
	 *     // Gosper's hack:
	 *     int c = set & -set;
	 *     int r = set + c;
	 *     set = (((r^set) >>> 2) / c) | r;
	 *     }
	 * @param x
	 * @param mask
	 * @return Next Higher Power with same number of 1's
	 */
	private static int getGospelHackNextPermutation(int x) {
		int u = x & -x;
		int v = (u + x) ;
		return v + (((v^x)/u)>>2);
	}
	
	private static int getParity(int i) {
		int parity = 0;
		for(int k=i;k>0;k=(k&(k-1)))
			++parity;
		return parity;
	}
	
	public static List<List<Integer>> generatePowerSet(Integer[] A) {
		List<List<Integer>> cList = new ArrayList<List<Integer>>();
		List<Integer> pList = new ArrayList<Integer>();
		cList.add(pList);
		pList = new ArrayList<Integer>();
		int i=1;
		int count=1;
		while(getParity(i)<A.length) {
			for(int j=i;j!=0;j=j^(j&-j)) {
				int p=0;
				for(int b = j&-j;b>0;b = b>>1)
					++p;
				pList.add(A[p-1]);
			}
			cList.add(pList);
			pList = new ArrayList<Integer>();			
			i = getGospelHackNextPermutation(i);
			if(Math.max(A.length, count)%Math.min(A.length, count) ==0 && count!=1)
				i = (int)Math.pow(2, getParity(i)+1)-1;
			++count;
		}
		pList = Arrays.asList(A);
		cList.add(pList);
		return cList;
	}
	
	public static void main(String[] args) {
		Integer[] s = {1, 2, 3,4};
		System.out.println(generatePowerSet(s));	
		/*for(int i=1;i<Math.pow(2, 3); i = getGospelHackNextPermutation(i))
			
				System.out.println(Integer.toBinaryString(i));*/
		//System.out.println(getParity(2));
	}
}
