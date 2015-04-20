package com.practice.challenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class MaximumLengthChainFormed  {
	
	static class Chain implements Comparable<Chain>{
		int start;
		int end;
		
		Chain(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		Chain(Chain c) {
			this.start = c.start;
			this.end = c.end;
		}
		
		public int getStart() {
			return this.start;
		}
		
		public int getEnd() {
			return this.end;
		}

		@Override
		public int compareTo(Chain o) {
			return Integer.compare(this.getStart(), o.getStart());
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d)", start, end); 
		}
	}
	
	public static List<Chain> getLongestChain(List<Chain> list) {
		if(list==null||list.isEmpty())
			throw new IllegalArgumentException("Invalid Input list null or Empty.");
		Collections.sort(list);
		int[] lis = new int[list.size()];
		int[] index = new int[list.size()];
		lis[0] = 1;
		index[0] = -1;
		for(int i=1;i<list.size();++i)
			for(int j=0;j<i;++j) {
				if(list.get(i).getStart() > list.get(j).getEnd())
					if(lis[i] < lis[j]+1) {
						lis[i] = lis[j]+1;
						index[i] = j;
					}
				else {
					lis[i] = 1;
					index[i] = -1;
				}
			}
		int max = 0;
		for(int i=1;i<lis.length;++i)
			if(lis[i] > lis[max])
				max = i;
		List<Chain> r = new ArrayList<Chain>();
		while(max!=-1) {
			r.add(list.get(max));
			max = index[max];
		}
		Collections.reverse(r);
		return r;
	}
	
	public static void main(String[] args) {
		List<Chain> cList = new ArrayList<Chain>();
		cList.add(new Chain(5,24));
		cList.add(new Chain(39,60));
		cList.add(new Chain(15,28));
		cList.add(new Chain(27,40));
		cList.add(new Chain(50,90));
		System.out.println(cList);
		System.out.println(getLongestChain(cList));
		
		
		
	}
}

