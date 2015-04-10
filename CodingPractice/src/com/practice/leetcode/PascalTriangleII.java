package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
	   public List<Integer> getRow(int rowIndex) {
	        List<Integer> cList = new ArrayList<Integer>();
	        cList.add(1);
	        for(int i=1; i<rowIndex/2+1; ++i)
	            cList.add((int)(cList.get(i-1)*((long)(rowIndex-i+1))/i));
	        for(int i=rowIndex/2+1; i<=rowIndex; ++i)
	            cList.add(cList.get(rowIndex-i)) ;
	        return cList;
	   }
	   
	   public static int nCk(int n, int k) {
	        List<Integer> cList = new ArrayList<Integer>();
	        cList.add(1);
	        for(int i=1; i<n/2+1 && i<=k; ++i)
	            cList.add((int)(cList.get(i-1)*((long)(n-i+1))/i));
	        for(int i=n/2+1; i<=n && i<=k; ++i)
	            cList.add(cList.get(n-i)) ;
	        return cList.get(k);
	   }
	   
	   public static void main(String[] args) {
		   System.out.println(nCk(5,3));
	   }
}
