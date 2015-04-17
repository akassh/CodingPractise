package com.practice.challenge;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

class Interval implements Comparable<Interval> {
	private int start;
	private int end;
	
	public int getStart() {
		return this.start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getEnd() {
		return this.end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Interval) {
			Interval o = (Interval) obj;
			if(this.start==o.start && this.end==o.end)
				return true;
		}
		return false;
	}
	
	@Override
	public int compareTo(Interval o) {
		return Integer.compare(this.start, o.start);
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", this.start, this.end);
	}
}

public class MergeOverlappingInterval {
	public static List<Interval> mergeInterval(Interval[] interval) {
		if(interval==null||interval.length==0||interval[0]==null)
			throw new IllegalArgumentException("Given Input Parameter: Interval Array is null or empty or first element is null.");
		for (Interval interval2 : interval)
			if(interval2==null)
				throw new IllegalArgumentException("Given Input Parameter: Element in the Interval Array is null");
		Arrays.sort(interval);
		Stack<Interval> s = new Stack<Interval>();
		s.push(interval[0]);
		for(int i=1;i<interval.length;++i) {
				Interval temp = s.peek();
				if(temp.getEnd() >= interval[i].getStart()) {
					temp.setEnd(Math.max(interval[i].getEnd(),temp.getEnd()));
					s.pop();
					s.push(temp);
				} else 
					s.push(interval[i]);
		}
		List<Interval> mergedInterval = new ArrayList<Interval>();
		while(!s.isEmpty())
			mergedInterval.add(s.pop());
		return mergedInterval;
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIfArrayIsNull() {
		MergeOverlappingInterval.mergeInterval(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIfArrayIsEmpty() {
		Interval[] interval = new Interval[0];
		MergeOverlappingInterval.mergeInterval(interval);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIfArrayElementIsNull() {
		Interval[] interval = new Interval[1];
		MergeOverlappingInterval.mergeInterval(interval);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIfArrayElementIsNull2() {
		Interval[] interval = new Interval[4];
		interval[0] = new Interval(6, 8);
		interval[1] = new Interval(1, 9);
		interval[2] = null;
		interval[3] = new Interval(4, 7);
		MergeOverlappingInterval.mergeInterval(interval);
	}
	
	@Test
	public void testCase1WithInput() {
		Interval[] interval = new Interval[4];
		interval[0] = new Interval(6, 8);
		interval[1] = new Interval(1, 9);
		interval[2] = new Interval(2, 4);
		interval[3] = new Interval(4, 7);
		assertEquals(new Interval(1,9), MergeOverlappingInterval.mergeInterval(interval).get(0));
	}
	
	@Test
	public void testCase2WithInput() {
		Interval[] interval = new Interval[4];
		interval[0] = new Interval(1, 3);
		interval[1] = new Interval(7, 9);
		interval[2] = new Interval(4, 6);
		interval[3] = new Interval(10, 13);
		List<Interval> result = MergeOverlappingInterval.mergeInterval(interval);
		Collections.reverse(result);
		assertArrayEquals(result.toArray(), interval);
	}
	
	@Test
	public void testCase3WithInput() {
		Interval[] interval = new Interval[4];
		interval[0] = new Interval(6, 8);
		interval[1] = new Interval(1, 3);
		interval[2] = new Interval(2, 4);
		interval[3] = new Interval(4, 7);
		MergeOverlappingInterval.mergeInterval(interval);
		assertEquals(new Interval(1,8), MergeOverlappingInterval.mergeInterval(interval).get(0));
	}
}

