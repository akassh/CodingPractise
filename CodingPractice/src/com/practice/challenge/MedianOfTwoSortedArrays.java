package com.practice.challenge;

public class MedianOfTwoSortedArrays {
	
	public static float getMedianOfArray(int[] A, int l, int h) {
		if((h-l+1)%2!=0)
			return A[l+(h-l+1)/2];
		else
			return (A[l+(h-l)/2] + A[l+(h-l+1)/2])/2.0f;
	}
	
	public static float getMedianBaseCase(int[] A, int l, int h, int med) {
		if(h-l+1==1)
			return (A[l] + med)/2.0f ;
		if((h-l+1)%2==0) {
			int a = A[l+(h-l+1)/2 - 1];
			int b = A[l+(h-l+1)/2];
			return med <= a ? a : (med <= b ? med : b);
		} else {
			int a = A[l+(h-l+1)/2 - 1];
			int b = A[l+(h-l+1)/2];
			int c = A[l+(h-l+1)/2 + 1];
			return med <= a ? (a+b)/2.0f : (med <= c ? (med+b)/2.0f : (b+c)/2.0f);
		}
	}
	
	public static float getMedianBaseCase2(int[] A, int l, int h, int med1, int med2) {
		if((h-l+1)%2==0) {
			int a = (l+(h-l+1)/2 - 2) >= l ? A[l+(h-l+1)/2 - 2] : Integer.MIN_VALUE; 
			int b = A[l+(h-l+1)/2 - 1];
			int c = A[l+(h-l+1)/2];
			int d = l+(h-l+1)/2 + 1 < l+(h-l+1) ? A[l+(h-l+1)/2 + 1] : Integer.MAX_VALUE;  
			if(med2 <= b)
				return (b + Math.max(med2,a))/2.0f;
			else if(med1 <= b)
				return (b + Math.min(med2,c))/2.0f;
			else if(med1>=c)
				return (c + Math.min(med1,d))/2.0f ;
			else if(med2>=c)
				return (c + Math.max(med1,b))/2.0f ;
			return (med1+med2)/2.0f;
		} else {
			int a = A[l+(h-l+1)/2 - 1];
			int b = A[l+(h-l+1)/2];
			int c = A[l+(h-l+1)/2 + 1];
			return med1 >= b ? Math.min(med1,c) : (med2 <= b ? Math.max(a, med2) : b);
		}
	}
	
	public static float medianOfTwoArrays(int[] A, int la, int ha, int[] B, int lb, int hb) {
		if(ha-la+1==0)	
			return getMedianOfArray(B, lb, hb);
		if(hb-lb+1==0)	
			return getMedianOfArray(A, la, ha);
		if(ha-la+1==1)	
			return getMedianBaseCase(B, lb, hb, A[la]);
		if(hb-lb+1==1)	
			return getMedianBaseCase(A, la, ha, B[lb]);
		if(ha-la+1==2)
			return getMedianBaseCase2(B, lb, hb, A[la], A[ha]);
		if(hb-lb+1==2)
			return getMedianBaseCase2(A, la, ha, B[lb], B[hb]);
		float mA = getMedianOfArray(A, la, ha);
		float mB = getMedianOfArray(B, lb, hb);
		int i = (ha-la+1)/2;
		int j = (hb-lb+1)/2;
		if(mA > mB) {
			int k = (((hb-lb+1)%2 == 0) ? Math.min((ha-la+1)-i-1, j-1) : Math.min((ha-la+1)-i-1, j));
			ha = ha-k;
			lb = lb+k;
		} else {
			int k = ((ha-la+1)%2 == 0 ? Math.min(i-1, (hb-lb+1)-j-1) : Math.min(i, (hb-lb+1)-j-1));
			hb = hb-k;
			la = la+k;
		}
		return medianOfTwoArrays(A, la, ha, B, lb, hb);	
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,4,8,9,10};//{900};//
		int[] B = {3,5,6,7};//{5, 8, 10, 20};//
		System.out.println(medianOfTwoArrays(A, 0, A.length-1, B, 0, B.length-1));
		
		int[] C = {5, 8, 10, 20};
		int[] D = {900};
		System.out.println(medianOfTwoArrays(C, 0, C.length-1, D, 0, D.length-1));
		
		int[] E = {2, 3, 4, 5, 6, 7, 8};
		int[] F = {1};
		System.out.println(medianOfTwoArrays(E, 0, E.length-1, F, 0, F.length-1));
		
		int[] G = {6,7,8};
		int[] H = {1,2,3,4,5};
		System.out.println(medianOfTwoArrays(G, 0, G.length-1, H, 0, H.length-1));
		
	}
}
