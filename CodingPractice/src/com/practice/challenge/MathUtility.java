package com.practice.challenge;

public class MathUtility {
	public static float pow(float x,int y) {
		if(y==0)
			return 1;
		if(y==1)
			return x;
		if(y<0) {
			x = 1/x;
			y *= -1;
		}
		float result = pow(x,y/2);
		if(y%2==0)
			return  result*result;
		else 
			return  x*result*result;
	}
	
	public static int getNextHigherNumberWithSameNumberOfSetBit(int x) {
		int u = (x&-x);
		int v = u+x;
		return v + (((v^x)/u) >> 2);
	}
	
	public static int nextPowerOf2(int n) {
		if(n!=0 && (n&(n-1))==0)
			return n;
		int p = 1;
		while(n>0) {
			n = n >> 1;
			p = p << 1;
		}
		return p;
	}
	
	public static int roundOff(float x) {
		return (int)(x+(x < 0 ? -0.5 : 0.5));
	}
	
	public static int abs(int x) {
		return x < 0 ? x*-1 : x;
	}
	
	public static int getParity(int x) {
		int count = 0;
		while(abs(x)>0) {
			x = x & (x-1);
			++count;
		}
		return count;
	}
	
	public static float sqrt(float n) {
		float x = n;
		float y = 1.0f;
		float e = 0.00001f;
		while(x-y>e) {
			x = (x+y)/2;
			y = n/x;
		}
		return x;
	}
	
	public static void main(String[] args) {
		for(int i=1;i<10;++i) {
			//System.out.println(i + " - > " +MathUtility.pow(2, i));
			//System.out.println(i + " - > " +roundOff(1.7f));
			//System.out.println(i + " - > " +nextPowerOf2(i));
			System.out.println(getNextHigherNumberWithSameNumberOfSetBit(i));
		}
		//System.out.println(sqrt(16));
			
	}
}
