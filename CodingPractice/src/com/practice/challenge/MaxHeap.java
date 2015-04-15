package com.practice.challenge;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
	
	private List<Integer> heap;
	
	public MaxHeap() {
		this.heap = new ArrayList<Integer>();
	}
	
	public int top() {
		if(heap!=null && heap.size()>0)
			return heap.get(0);
		return Integer.MIN_VALUE;
	}
	
	public int getMax() {
		if(heap!=null && heap.size()>0) {
			int max = heap.get(0);
			heap.set(0, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			moveDown();
			return max;
		}
		return Integer.MIN_VALUE;
	}
	
	public void insert(int x) {
		if(heap==null)
			return;
		heap.add(x);
		moveUp();
	}
	
	//moveUp	
	private void moveUp() {
		int index = heap.size()-1;
		while(index>=0) {
			int parent = (index - 1) < 0 ? -1 : (index-1)/2;
			if(parent<0 || heap.get(parent) > heap.get(index))
				break;
			else {
				int ptemp = heap.get(parent);
				int itemp = heap.get(index);
				heap.remove(parent);
				heap.add(parent, itemp);
				heap.remove(index);
				heap.add(index, ptemp);
				index = parent;
			}	
		}
	}
	
	public int size() {
		return this.heap==null? 0 : heap.size();
	}
	
	//moveDown
	private void moveDown() {
		int index = 0;
		while(index < heap.size()) {
			int maxIndex = -1;
			if(2*index+1<heap.size() && 2*index+2<heap.size())
				maxIndex =  Math.max(heap.get(2*index+1), heap.get(2*index+2)) == heap.get(2*index+1)? 2*index+1  : 2*index+2;
			else if(2*index+1<heap.size())
				maxIndex =  2*index+1;
			else if(2*index+2<heap.size())
				maxIndex =  2*index+2;
			if(maxIndex==-1) 
				break;
			else if(heap.get(index) < heap.get(maxIndex)) {
					int ptemp = heap.get(index);
					int ctemp = heap.get(maxIndex);
					heap.remove(index);
					heap.add(index, ctemp);
					heap.remove(maxIndex);
					heap.add(maxIndex, ptemp);
					index = maxIndex;
				}
			else 
				break;
		}
	}
	
	@Override
	public String toString() {
		return this.heap.toString();
	}
	
	public static void main(String[] args) {
		int[] x = {1, 2, 3 ,4 ,5 ,6 ,7 ,8 , 9};
		MaxHeap maxheap = new MaxHeap(); 
		for (int i : x)
			maxheap.insert(i);
		System.out.println(maxheap);
		for(int i=0;i<x.length;++i)
			System.out.println(maxheap.getMax());
	}
}
