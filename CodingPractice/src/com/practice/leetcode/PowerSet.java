package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> cList = new ArrayList<List<Integer>>();
        List<Integer> pList = new ArrayList<Integer>();
        int n = (int) Math.pow(2,S.length);
        for(int i=0;i<n;i++) {
        	int j = i;
            while(j!=0) {
                int lastSetBit = (j & -j);
                int positionOfSetBit = 0;
                for(positionOfSetBit=0;lastSetBit!=0;lastSetBit = lastSetBit>>1,++positionOfSetBit);
                pList.add(S[positionOfSetBit-1]);
                j = j & (j-1);
            }
            Collections.sort(pList);
            cList.add(pList);
            pList = new ArrayList<Integer>();
        }
        Collections.sort(cList, new Comparator<List<Integer>>() {

									@Override
									public int compare(List<Integer> l1, List<Integer> l2) {
										String s1 = "";
										String s2 = "";
										for(int i=0;i<l1.size();++i)
											s1 += l1.get(i);
										for(int i=0;i<l2.size();++i)
											s2 += l2.get(i);
										if(s1.length()<s2.length())
											return -1;
										if(s1.length()>s2.length())
											return 1;
										else 
											return s1.compareTo(s2);
									}
								});
         return cList;
    }
    
    public static int[] createSet(int n) {
    	int[] set = new int[n];
    	for(int i=1;i<=n;++i)
    		set[i-1] = i;
    	return set;
    }
    
    public static void printElements(List<List<Integer>> list) {
    	for(int i=0;i<list.size();++i){
    		for(int j=0;j<list.get(i).size();++j) 
    			System.out.print(list.get(i).get(j) + " ");
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
		printElements(subsets(createSet(3)));
	}
}
