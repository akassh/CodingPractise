package com.practice.leetcode;

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
	
	public static void main(String[] args) {
		int[] A = {1,2};//{3,2,1,0,4};
		System.out.println(jump(A));
	}
}
