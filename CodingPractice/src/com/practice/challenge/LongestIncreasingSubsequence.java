/**
 * @author Akassh
 */
package com.practice.challenge;
import java.util.Arrays;

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
	
	public static void printArray(int[] a) {
		for (int i : a)
			System.out.print( i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {10, 22, 9, 33, 21, 50, 41, 60};//{1, 2, 3, 1, 4, 5, 2, 3, 6};
		printArray(a);
		printArray(getSizeOfLongestIncreasingSubsequence2(a));
		//System.out.println(getSizeOfLongestIncreasingSubsequence(a));
	}
}
