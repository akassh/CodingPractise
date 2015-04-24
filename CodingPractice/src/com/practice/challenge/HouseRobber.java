package com.practice.challenge;

public class HouseRobber {
	
	  public int max3(int a, int b, int c) {
	        return Math.max(a, Math.max(b, c));
	    }
		
		public int max4(int a, int b, int c, int d) {
	        return Math.max(Math.max(a, b), Math.max(c, d));
	    }
		
		public int rob(int[] num) {
	        if(num.length==0)
	            return 0;
	        if(num.length==1)
	            return num[0];
	        if(num.length==2)
	            return Math.max(num[0],num[1]);
	        int[] m = new int [num.length];
	        for(int i=0;i<2;i++)
	            m[i] = num[i];
	        for(int i=2;i<num.length;i++)    
	                if(i-3 >= 0)
	                    m[i] = max4(m[i], m[i-1], num[i] + m[i-2], num[i] + m[i-3]);
	                else if(i-2>=0)
	                	m[i] = max3(m[i], m[i-1], num[i] + m[i-2]);
	        return m[m.length-1];
	    }
	
	public static void main(String[] args) {
		int[] num = {2,1,1,2};//{1,2,1,0};//{1,1,1};//
		System.out.println(new HouseRobber().rob(num));
	}
}
