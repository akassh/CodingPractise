/**
 * @author Akassh
 */
package com.practice.challenge;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
	
	//O(n^2)
	public static int getSizeOfLongestIncreasingSubsequence(int[] a) {
		int[] lis = new int[a.length];
		int max = 1;
		Arrays.fill(lis, 1);
		for(int i=1; i<a.length; ++i) {
			for(int j=0; j<i; ++j)
				if(a[i] > a[j] && lis[j]+1 > lis[i])
					lis[i] = lis[j] + 1;
			if(max < lis[i])
				max = lis[i];
		}
		return max;
	}
	
	//O(nLog(n))
	public static int[] getSizeOfLongestIncreasingSubsequence2(int[] a) {
		int[] p = new int[a.length]; //predecessor
		int[] m = new int[a.length+1];//
		int l = 0;
		for(int i=0; i < a.length; ++i) {
			int low = 1;
			int high = l;
			while(low <= high) {
				int mid = (int)Math.ceil((low+high)/2);
				if(a[m[mid]] < a[i])
					low = mid + 1;
				else 
					high = mid - 1;
			}
			int newL = low;
			p[i] = m[newL-1];
			m[newL] = i;
			if(newL > l)
				l = newL;
		}

		 int[] s = new int[l];
		 int k = m[l];
		 for(int i=l-1; i>=0; --i) {
			 s[i] = a[k];
			 k = p[k];
		 }
		 return s;
	}
	
	
	public static int ceiling(List<Integer> A, int low, int high, int key) {
		while(high - low > 1) {
			int mid = (low+high)/2;
			if(A.get(mid) >= key)
				high = mid;
			else 
				low = mid;
		}
		return high;
	}
	
	//O(nLog(n)) Wrong
	/**
	 * @author Akassh
	 * 
	 * @return
	 */
	public static List<Integer> longestIncreasingSubsequenceVersion2(int[] A) {
		if(A==null||A.length==0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		list.add(A[0]);
		for(int i=0;i<A.length;++i) {
			if(A[i] < list.get(0)) {
				list.remove(0);
				list.add(0, A[i]);
			}
			else if(A[i] > list.get(list.size()-1))
				list.add(A[i]);
			else {
				int index = ceiling(list, 0, list.size()-1, A[i]);
				list.remove(index);
				list.add(index, A[i]);
			}
				
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		int[] x = {1,2,3,7,9,10};
		System.out.println(longestIncreasingSubsequenceVersion2(x));
		System.out.println();
		
		int[] a = {10, 22, 9, 33, 21, 50, 41, 60};//{1, 2, 3, 1, 4, 5, 2, 3, 6};
		ArraysUtility.printArray(a);
		ArraysUtility.printArray(getSizeOfLongestIncreasingSubsequence2(a));
		System.out.println(longestIncreasingSubsequenceVersion2(a));
		System.out.println(getSizeOfLongestIncreasingSubsequence(a));
		
		/*int b[] = {8,1,4,3,5,2};
		ArraysUtility.printArray(b);
		System.out.println(longestIncreasingSubsequenceVersion2(b));*/
	}
}
