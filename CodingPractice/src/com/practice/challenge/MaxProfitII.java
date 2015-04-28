package com.practice.challenge;

import java.util.Arrays;

public class MaxProfitII {
	static int kadaneAlgorithm(int[] A, int low, int high) {
        int sum = A[low];
        int max = A[low];
        for(int i=low+1;i<=high;++i) {
            if(sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if(max < sum)
                max = sum;
        }
        return max < 0 ? 0 : max;
    }
    
    static int getMaxDifference(int[] A, int low, int high) {
        if(high==low)
            return 0;
        int[] newA = new int[high-low];
        for(int i=low;i<high;++i)
            newA[i-low] = A[i+1] - A[i];
        return kadaneAlgorithm(newA, 0, high-low-1);
    }
    
    static int getMaxDifferenceOptimized(int[] A, int low, int high) {
        if(high==low)
            return 0;
        int minTillNow = Integer.MAX_VALUE;
        int maxDiff = 0;
        for(int i=low;i<=high;++i)
            if(A[i]<minTillNow)
            	minTillNow = A[i];
            else
            	if(maxDiff < (A[i] - minTillNow))
            		maxDiff = A[i] - minTillNow;
        return maxDiff;
    }
    
    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int[] profit = new int[prices.length];
        for(int i=0;i<prices.length-1;++i) {
            if(i==0||i+1==prices.length-1)
                profit[i] = getMaxDifferenceOptimized(prices,0,prices.length-1);
            else 
                profit[i] = getMaxDifferenceOptimized(prices,0,i) + getMaxDifferenceOptimized(prices,i+1,prices.length-1);
        }
        int max = 0;
        for(int i=0;i<profit.length;++i)
            max = Math.max(profit[i],max);
        return max;
    }
    
    public static void main(String[] args) {
		int[] A = {2, 30, 15, 10, 8, 25, 80};//{1,2,4};//{10, 22, 5, 75, 65, 80};
		System.out.println(Arrays.toString(A));
		System.out.println(maxProfit(A));
	}
}
