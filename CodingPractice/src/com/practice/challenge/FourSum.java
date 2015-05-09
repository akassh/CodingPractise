package com.practice.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FourSum {
	
	   public static List<List<Integer>> fourSum(int[] num, int target) {
	        List<List<Integer>> cList = new ArrayList<List<Integer>>();
	        List<Integer> pList = new ArrayList<Integer>();
	        int k = 0;
	        int[] sum2 = new int[num.length*(num.length-1)/2];
	        int[] index1 = new int[num.length*(num.length-1)/2];
	        int[] index2 = new int[num.length*(num.length-1)/2];
	        for(int i=0;i<num.length-1;i++)
	            for(int j=i+1;j<num.length;j++) {
	                sum2[k] = num[i] + num[j];
	                index1[k] = i;
	                index2[k++] = j;
	            }
	        Map<Integer,Integer> m = new HashMap<Integer,Integer>();
	        for(int i=0;i<sum2.length;++i) 
	        	if(m.containsKey(sum2[i])) {
	        			pList.add(num[index1[m.get(sum2[i])]]);
		        		pList.add(num[index2[m.get(sum2[i])]]);
		        		pList.add(num[index1[i]]);
		        		pList.add(num[index2[i]]);
		        		Collections.sort(pList);
		        		if(!cList.contains(pList))
		        			cList.add(pList);
		        		pList = new ArrayList<Integer>();
	        	} else 
	        		m.put(target-sum2[i], i);
	        return cList;
	    }
	   
	   public static void main(String[] args) {
		   int[] A = {1,0,-1,0,-2,2};
		   System.out.println(fourSum( A, 0));
	   }
}
