/**
 * @author Akassh
 */
package com.practice.challenge;

class ListNode<E> {
	
	E val;
	ListNode<E> next;
	
	public ListNode(E val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return "ListNode [val=" + val + "]";
	}
}

public class LinkedList<T> {
	private ListNode<T> head;
	private ListNode<T> last;
	
	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public LinkedList() {
		
	}
	
	public LinkedList(ListNode<T> list) {
		if(list!=null) {
			for(ListNode<T> temp = list;temp!=null;temp = temp.next)
				this.insertNodeInBeginning(temp.val);
		}
	}
	
	public ListNode<T> insertNodeInBeginning(T val) {
		ListNode<T> t = new ListNode<T>(val);
		if(this.head==null) {
			head = t;
			last = t;
		}
		else {
			t.next = head;
			head = t;
		}
		return head;
	}
	
	public ListNode<T> insertNodeInEnd(T val) {
		ListNode<T> t = new ListNode<T>(val);
		if(this.head==null) {
			head = t;
			last = t;
		}
		else {
			last.next = t;
			last = last.next;
		}
		return head;
	}
	
	public static ListNode<?> getMiddleNode(ListNode<?> head) {
		if(head==null || head.next==null)
			return head;
		ListNode<?> curr = head;
		ListNode<?> mrkr = head.next;
		while(mrkr!=null&&mrkr.next!=null) {
			curr = curr.next;
			mrkr = mrkr.next.next;
		}
		return curr;
	}
	
	public static int getNumberOfNodes(ListNode<?> head) {
		int count = 0;
		for(ListNode<?> curr = head;curr!=null;curr = curr.next,++count);
		return count;
	}
	
	public static ListNode<?> getPreviousOfMiddleNode(ListNode<?> head) {
		if(head==null || head.next==null)
			return head;
		ListNode<?> prev = null;
		ListNode<?> curr = head;
		ListNode<?> mrkr = head.next;
		while(mrkr!=null&&mrkr.next!=null) {
			prev = curr;
			curr = curr.next;
			mrkr = mrkr.next.next;
		}
		return prev;
	}
	
	public void segregateEvenAndOdd() {
		if(this.head==null || this.head.next==null)
			return;
		ListNode<T> end = this.head;
		int count = 0;
		while(end.next!=null) {
			++count;
			end = end.next;
		}
		while((Integer)this.head.val%2!=0 && count!=0) {
			end.next = head;
			head = head.next;
			end = end.next;
			end.next = null;
			--count;
		}
			
		ListNode<T> start = head;
		while(count!=0 && start.next!=null) {
			if((Integer)start.next.val%2!=0) {
				end.next = start.next;
				start.next = start.next.next;
				end = end.next;
				end.next = null;
				--count;
			}
			else 
				start = start.next;
		}	
	}
	
	public void reverseList(int k) {
		if(head==null || head.next==null)
			return;
		ListNode<T> prev = null;
		ListNode<T> curr = head;
		ListNode<T> nxt  = head.next;
		while(curr!=null && k > 0) {
			curr.next = prev;
			prev = curr;
			curr = nxt;
			if(nxt!=null)
				nxt  = nxt.next;
			--k;
		}
		head.next = curr;
		this.head = prev;
	}
	
	public void reverseList() {
		if(head==null || head.next==null)
			return;
		ListNode<T> prev = null;
		ListNode<T> curr = head;
		ListNode<T> nxt  = head.next;
		while(curr!=null) {
			curr.next = prev;
			prev = curr;
			curr = nxt;
			if(nxt!=null)
				nxt  = nxt.next;
		}
		head.next = curr;
		this.head = prev;
	}

	public void deleteIfGreaterNodeOnRight() {
		if(this.head==null || this.head.next==null)
			return;
		this.reverseList();
		while(head.next!=null && (Integer)head.next.val > (Integer)head.val)
			head = head.next;
		ListNode<T> p = head;
		ListNode<T> c = head.next;
		while(c!=null) {
			if((Integer)p.val > (Integer)c.val) {
				p.next = c.next;
				c = c.next;
			}
			else { 
				p = c;
				c = c.next;
			}
		}
		this.reverseList();
	}
	
	@Override
	public String toString() {
		String s = "LinkedList [ ";
		if(this.head==null)
			s += null + " ";
		else {
			ListNode<T> t = head;
			while(t!=null) {
				s += t.val + " ";
				t = t.next;
			}
		}
		s += "]";
		return s;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<10;++i)
			list.insertNodeInEnd(i);
		System.out.println(list);
		
		list.segregateEvenAndOdd();
		System.out.println(list);
		list.reverseList(5);
		System.out.println(list);
		list.deleteIfGreaterNodeOnRight();
		System.out.println(list);
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		int[] a = {12,15,10,11,5,6,2,3};
		for (int i : a)
			list2.insertNodeInEnd(i);
		System.out.println(list2);
		list2.deleteIfGreaterNodeOnRight();
		System.out.println(list2);
	}

}

