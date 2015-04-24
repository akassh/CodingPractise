package com.practice.challenge;

public class MedianOfArrays {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        if(A.length<=B.length)
            return findMedianSortedArrays(A, 0, A.length, B, 0, B.length);
        else 
            return findMedianSortedArrays(B, 0, B.length, A, 0, A.length);
    }

    double findMedianSortedArrays(int[] A, int aLow, int aHigh, int[] B, int bLow, int bHigh) {
        if(aHigh < aLow && bHigh < bLow)
            return -1;
        
        /*if(aHigh == aLow)
            return getMedianOfSortedArray( B, bLow, bHigh);*/
            
        if(aHigh - aLow == 1 || aHigh == aLow) {
            if(bHigh - bLow == 1)
                return medianOfTwo( A[aLow], B[bLow]);
            int bMid = (bLow+bHigh)/2;
            if((bHigh - bLow)%2==1)
                return medianOfTwo( B[bMid], medianOfThree(A[aLow], B[bMid - 1], B[bMid + 1]));
            else
                return medianOfThree( A[aLow], B[bMid], B[bMid-1]);
        }
        
        else if(aHigh - aLow == 2) {
            int bMid = (bLow+bHigh)/2; 
            if(bHigh - bLow == 2)
                return medianOfFour( A[aLow], B[bLow], A[aLow+1], B[bLow+1]);
            else if((bHigh - bLow)%2==1)
                return medianOfThree( B[bMid], Math.max( A[aLow],B[bMid-1]), Math.min( A[aLow+1],B[bMid+1]));
            else 
                return medianOfFour( B[bMid], B[bMid-1], Math.max(A[aLow], B[bMid-2]), Math.min(B[bMid+1], A[aLow+1]));
        }
            
        double aMed = getMedianOfSortedArray(A, aLow, aHigh);  
        double bMed = getMedianOfSortedArray(B, bLow, bHigh);  
        int aMid = (aLow+aHigh)/2;
        int bMid = (bLow+bHigh)/2;  
        if(aMed == bMed)
            return aMed;
        else if(aMed < bMed)
            if((aHigh - aMid-1) < (bMid-1 - bLow))
                return findMedianSortedArrays( A, aMid+1, aHigh, B, bLow, bMid-1);
            else 
                return findMedianSortedArrays( B, bLow, bMid-1, A, aMid+1, aHigh);
        else
            if((aMid-1 - aLow) < (bHigh - bMid-1))
                return findMedianSortedArrays( A, aLow, aMid-1, B, bMid+1, bHigh);
            else 
                return findMedianSortedArrays( B, bMid+1, bHigh, A, aLow, aMid-1);
    }
    
    double medianOfTwo(double a, double b) {
        return (a + b)/2.0;
    }
    
    double medianOfThree(double a, double b, double c) {
        return a + b + c -Math.max(a, Math.max(b, c)) -Math.min(a, Math.min(b, c));
    }
    
    double medianOfFour(double a, double b, double c, double d){
        return (a + b + c + d -Math.max(a, Math.max(b, Math.max(c, d))) -Math.min(a, Math.min(b, Math.min(c, d))))/2.0;
    }
    
    double getMedianOfSortedArray(int[] a, int low, int high) {
        if((high-low)%2==0)
            return medianOfTwo(a[(low+high)/2-1],a[(low+high)/2]);
        else
            return a[(low+high)/2];
    }

    public static void main(String[] args) {
    	//[1,2,3], [4,5,6,7]
		int[] A = {1,2,3};
		int[] B = {4,5,6};
		System.out.println(new MedianOfArrays().findMedianSortedArrays(A, B));
	}
}
