package com.practice.challenge;

public class CountTotalNumberOfSetBits {
	
	private static int getSetBit(int n) {
		int c = 0;
		while(n>0) {
			n = n&(n-1);
			++c;	
		}
		return c;
	}
	
	private static int getLeftMostSetBit(int n) {
		int count = 0;
		for(int i=1;i<=n; i<<=1)
			++count;
		return count-1;
	}
	
	public static int getTotalNumberOfSetBitOneToN(int n) {
		if(n==0)
			return 0;
		int b = getSetBit(n);
		if((n&(n+1))==0)
			return (int) (b*Math.pow( 2, b-1));
		int m = n - (1 << getLeftMostSetBit(n)) + 1 ;
		return m + getTotalNumberOfSetBitOneToN(n-m) + getTotalNumberOfSetBitOneToN(m-1);
	}
	
	public static void main(String[] args) {
		System.out.println(getTotalNumberOfSetBitOneToN(2));
		System.out.println(getTotalNumberOfSetBitOneToN(6));
		System.out.println(getTotalNumberOfSetBitOneToN(17));
		System.out.println(getTotalNumberOfSetBitOneToN(11));
	}
}
