package com.practice.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpGame {
	public static boolean canJump(int[] A) {
        int[] jump = new int[A.length];
        jump[jump.length-1] = 0;
        for(int i=jump.length-2; i>=0;i--) {
            if(A[i]==0)
                jump[i] = Integer.MAX_VALUE;
            else if(A[i] >= jump.length-1-i)
                jump[i] = 1;
            else {
                int min = Integer.MAX_VALUE;
                for(int j=i+1;j<jump.length && j <= A[i]+i;j++) 
                    if(min > jump[j])
                        min = jump[j];
                jump[i] = min == Integer.MAX_VALUE ? min : min+1;
            }
        }
        return jump[0]!=Integer.MAX_VALUE;
    }
	
	 public static int jump(int[] A) {
	        if(A.length==1)
	            return 0;
	        if(A.length==0||A[0]==0)
	            return Integer.MAX_VALUE;
	            
	        int[] jumps = new int[A.length];
	        jumps[0] = 0;
	        for(int i=1;i<jumps.length;i++) {
	            jumps[i] = Integer.MAX_VALUE;
	            for(int j=0;j<i;j++)
	                if(i <= j+A[j] && jumps[j] != Integer.MAX_VALUE) {
	                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
	                    break;
	                }
	        }
	        return jumps[jumps.length-1];
	 }
	 
	 public static boolean jumpOptimized(int[] A) {
        if(A==null)
		    throw new IllegalArgumentException("Input array is null.");
		if(A.length==1)
            return true;
		if(A.length==0||A[0]==0)
	        return false;
        int currPos = 0; 	//Tracking the Best Jump Point.
        int currMax = 0; 	//Tracking How far can it Jump.
        int tempMax = A[0]; //Temporary tracking the working set.
        List<Integer> position = new ArrayList<Integer>(); // Track solution.
        position.add(0);
        for(int i=0;i<A.length;++i) {
        	int max = i+A[i]; 	//Maximum reach represented by this position.
        	if(max > currMax) {	//If this is the biggest jump in the working set.
        		currMax = max; 	//remember the jump.
        		currPos = i;	//remember the position.
        	}
        	if(i==tempMax) {			//If we exhausted the working set
        		tempMax = currMax; 		//Best jump found in the working set. 
        		position.add(currPos); 	//remember the position of the jump.
        		currMax = 0;			//reset Jump and Position
        		currPos = 0;
        	}
        	if(tempMax >= A.length-1)	//Bail out if we found the solution.
        		return true;
	    }
	    return false;
	}
	 
	 public static List<Integer> getjumpPosition(int[] A) {
	        if(A==null)
			    throw new IllegalArgumentException("Input array is null.");
			if(A.length==1)
				return new ArrayList<Integer>(Arrays.asList(0));
			if(A.length==0||A[0]==0)
				return null;
	        int currPos = 0; 	//Tracking the Best Jump Point.
	        int currMax = 0; 	//Tracking How far can it Jump.
	        int tempMax = A[0]; //Temporary tracking the working set.
	        List<Integer> position = new ArrayList<Integer>(); // Track solution.
	        position.add(0);
	        for(int i=0;i<A.length;++i) {
	        	int max = i+A[i]; 	//Maximum reach represented by this position.
	        	if(max > currMax) {	//If this is the biggest jump in the working set.
	        		currMax = max; 	//remember the jump.
	        		currPos = i;	//remember the position.
	        	}
	        	if(i==tempMax) {			//If we exhausted the working set
	        		tempMax = currMax; 		//Best jump found in the working set. 
	        		position.add(currPos); 	//remember the position of the jump.
	        		currMax = 0;			//reset Jump and Position
	        		currPos = 0;
	        	}
	        	if(tempMax >= A.length-1)	//Bail out if we found the solution.
	        		return position;
		    }
	        return null;
		}
	 
	public static void main(String[] args) {
		int[] A = {2,0};//{3,2,1,0,4};
		System.out.println(jumpOptimized(A));
	}
}
