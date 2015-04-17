/**
 * 
 * @author Akassh
 * 
 */
package com.akassh.datastructure;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class TreeNode<E> {
	E val;
	TreeNode<E> left;
	TreeNode<E> right;
	TreeNode<E> next;
	TreeNode(E val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return val.toString() + " ";
	}
}

public class TreeList<T> {
	
	
	TreeNode<T> root;
	
	private TreeNode<T> getNextNode(TreeNode<T> p) {
		if(p==null)
			return p;
		TreeNode<T> t = p.next;
		while(t!=null) {
			if(t.left!=null)
				return t.left;
			else if (t.right!=null)
				return t.right;
			t = t.next;
		}
		return null;
	}
	
	public void connectTheLevelUsingNextReference() {
		if(this.root==null)
			return;
		TreeNode<T> p = this.root;
		p.next = null;
		while(p!=null) {
			for(TreeNode<T> q = p; q!=null; q = q.next) {
				if(q.left!=null)
					q.left.next = q.right!=null ? q.right : getNextNode(q); 
				if(p.right!=null)
					q.right.next = getNextNode(q);
			}
			if(p.left!=null)
				p = p.left;
			else if(p.right!=null)
				p = p.right;
			else 
				p = getNextNode(p);
		}
	}
	
	
	//head needs to be outside for reference
	private ListNode<T> head = null;
	public void sortedLinkedListToBinarySearchTree(ListNode<T> head) {
		int n = LinkedList.getNumberOfNodes(head);
		if(n==0)
			return;
		this.head = head;
		this.root = sortedLinkedListToBinarySearchTree(n);
	}
	
	private TreeNode<T> sortedLinkedListToBinarySearchTree(int n) {
		if(n<=0)
			return null;
		TreeNode<T> left = sortedLinkedListToBinarySearchTree(n/2);
		TreeNode<T> root = new TreeNode<T>(head.val);
		root.left = left;
		head = head.next;
		root.right = sortedLinkedListToBinarySearchTree(n-n/2-1);
		return root;
	}
	
	public void sortedArraysToBinarySearchTree(T[] a) {
		this.root = sortedArraysToBinarySearchTree(a, 0, a.length-1);
	}
	
	private TreeNode<T> sortedArraysToBinarySearchTree(T[] a, int low, int high) {
		if(high < low || low < 0 || high >= a.length)
			return null;
		if(high == low)
			return new TreeNode<T>(a[low]);
		int mid = (low + high)/2;
		TreeNode<T> t = new TreeNode<T>(a[mid]);
		t.left  = sortedArraysToBinarySearchTree(a, low, mid-1);
		t.right = sortedArraysToBinarySearchTree(a, mid+1, high);
		return t;
	}
	
	public String morrisTraversal() {
		if(this.root==null)
			return "";
		String s = "";
		TreeNode<T> current = this.root;
		while(current!=null) {
			if(current.left==null) {
				s += current.val.toString() + " ";
				current = current.right;
			} else {
				TreeNode<T> rightMostOfLeft = current.left;
				while(rightMostOfLeft.right!=null && rightMostOfLeft.right != current)
					rightMostOfLeft = rightMostOfLeft.right;
				if(rightMostOfLeft.right==null) {
					rightMostOfLeft.right = current;
					current = current.left;
				}
				else {
					rightMostOfLeft.right = null;
					s += current.val.toString() + " ";
					current = current.right;
				}
 			}
		}
		return s;
	}
	
	public static <T> void join(TreeNode<T> aList, TreeNode<T> bList) {
		aList.right = bList;
		bList.left = aList;
	}
	
	public static <T> TreeNode<T> append(TreeNode<T> aList, TreeNode<T> bList) {
		if(aList==null)
			return bList;
		if(bList==null)
			return aList;
		
		TreeNode<T> aLast = aList.left;
		TreeNode<T> bLast = bList.left;
	
		join(aLast,bList);
		join(bLast,aList);
			
		return aList;
	}
	
	public static <T> TreeNode<T> flatteningToDoublyLinkList(TreeNode<T> root) {
		if(root==null) 
			return null;
		TreeNode<T> aList = flatteningToDoublyLinkList(root.left);
		TreeNode<T> bList = flatteningToDoublyLinkList(root.right);
		root.left = root;
		root.right = root;
		aList = append(aList,root);
		aList = append(aList,bList);
		return aList;
	}
	
	public static <T> void flatteningToLinkList(TreeNode<T> root) {
		if(root==null)
			return;
		else if(root.left==null)
			flatteningToLinkList(root.right);
		else {
			TreeNode<T> r = root.right;
			root.right = root.left;
			root.left = null;
			TreeNode<T> temp = root.right;
			while(temp.right!=null)
				temp=temp.right;
			temp.right = r;
			flatteningToLinkList(root.right);
		}
	}
	
	public static TreeNode<Integer> linkListToLevelOrderBinaryTree(ListNode<Integer> head) {
		if(head==null)
			return null;
		TreeNode<Integer> root = new TreeNode<Integer>(head.val);
		ListNode<Integer> curr = head.next;
		Queue<TreeNode<Integer>> q = new ArrayDeque<TreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> p = q.poll();
			if(curr!=null){
				p.left = new TreeNode<Integer>(curr.val);
				q.add(p.left);
				curr = curr.next;
				if(curr!=null){
					p.right = new TreeNode<Integer>(curr.val);
					q.add(p.right);
					curr = curr.next;
				}
			}
		}
		return root;
	}
	
	public void printLevelOrderUsingNext() {
		if(this.root==null)
			return;
		TreeNode<T> p = this.root;
		while(p!=null) {
			for(TreeNode<T> q = p; q!=null; q = q.next)
				System.out.print(q + "-->");
			System.out.println();
			if(p.left!=null)
				p = p.left;
			else if(p.right!=null)
				p = p.right;
			else 
				p = getNextNode(p);
		}
	}
	
	@Override
	public String toString() {
		if(this.root==null)
			return "";
		String s = "";
		Queue<TreeNode<T>> q = new ArrayDeque<TreeNode<T>>();
		TreeNode<T> marker = new TreeNode<T>(null);
		q.add(this.root);
		q.add(marker);
		while(true) {
			TreeNode<T> t = q.remove();
			if(t==marker) {
				if(q.isEmpty())
					break;
				s += "\n";
				q.add(marker);
			} else {
				s += t.val.toString() + " ";
				if(t.left!=null)
					q.add(t.left);
				if(t.right!=null)
					q.add(t.right);
			}
		}
		return s + "\n" + this.morrisTraversal();
	}
	
	public static<T> void printCircularDoublyLinkList(TreeNode<T> root) {
		if(root==null)
			return;
		TreeNode<T> t = root;
		do {
			System.out.println(t.val);
			t = t.next;
		} while(t!=null&&t!=root);
		
	}
	
	public static void main(String[] args) {
		Integer[] a = {-8, -2, -4,10,7};
		LinkedList<Integer> llist = new LinkedList<Integer>(Arrays.asList(a));
		System.out.println(llist);
		TreeList<Integer> list = new TreeList<Integer>();
		list.root = linkListToLevelOrderBinaryTree(llist.getHead());
		System.out.println(list);
		flatteningToDoublyLinkList(list.root);
		printCircularDoublyLinkList(list.root);
		/*
		list.sortedArraysToBinarySearchTree(a);*/
		//System.out.println(list);
		//list.flatteningToLinkList(list.root);
		//list.flatteningToDoublyLinkList(list.root);
		//printCircularDoublyLinkList(list.root);
		/*List<Integer> cList = new ArrayList<Integer>();;
		System.out.println(list.maxSumOfRootToLeafPath(cList));
		System.out.println(cList);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for(int i=1;i<10;++i)
			linkedList.insertNodeInEnd(i);
		System.out.println(linkedList);
		TreeList<Integer> treeList = new TreeList<Integer>();
		treeList.sortedLinkedListToBinarySearchTree(linkedList.getHead());
		
		
		System.out.println(treeList);
		System.out.println();
		treeList.connectTheLevelUsingNextReference();
		System.out.println();
		treeList.printLevelOrderUsingNext();*/
	}
	
}
