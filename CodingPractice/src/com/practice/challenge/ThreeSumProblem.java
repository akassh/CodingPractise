package com.practice.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(n^2)
public class ThreeSumProblem {
	public static int[] threeSumProblemBySorting(int[] A, int sum) {
		if(A==null||A.length==0)
			return null;
		Arrays.sort(A);
		for(int i=0;i<A.length-2;++i) {
			for(int l=i+1,r=A.length-1;l<r;)
				if(A[l] + A[r] == sum - A[i]) {
					int[] result = new int[3];
					result[0] = A[i];
					result[1] = A[l];
					result[2] = A[r];
					return result;
				} else if(A[l] + A[r] < sum - A[i])
					++l;
				else 
					--r;
		}
		return null;
	}
	
	public static List<List<Integer>> threeSum(int[] num) {
        if(num==null||num.length==0)
            return null;
        List<List<Integer>> cList = new ArrayList<List<Integer>>();
        int sum = 0;
        List<Integer> pList = new ArrayList<Integer>();
        Arrays.sort(num);
        for(int i=0;i<num.length-2;++i)
            for(int l=i+1,r=num.length-1;l<r;) {
                if(num[l] + num[r] + num[i] == sum && num[r] != num[r-1]) {
                    pList.add(num[i]);
                    pList.add(num[l]);
                    pList.add(num[r]);
                    if(!cList.contains(pList))
                    	cList.add(pList);
                    pList = new ArrayList<Integer>();
                    break;
                } else if(num[l] + num[r] + num[i] < sum )
                    ++l;
                else 
                    --r;
            }
        return cList;
    }
	
	public static void main(String[] args) {
		int[] A = {12, 3, 4, 1, 6, 9};
		ArraysUtility.printArray(A);
		ArraysUtility.printArray(threeSumProblemBySorting(A, 24));
		int[] B = {0, 0, 0, 0};
		ArraysUtility.printArray(B);
		System.out.println(threeSum(B));
	}
}
