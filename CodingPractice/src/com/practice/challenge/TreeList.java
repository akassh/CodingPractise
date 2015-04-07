package com.practice.challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeList<T> {
	private class TreeNode<E> {
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
	
	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5,6,7,8,9,10,11};
		TreeList<Integer> list = new TreeList<Integer>();
		list.sortedArraysToBinarySearchTree(a);
		System.out.println(list);
		System.out.println();
		list.printLevelOrderUsingNext();
		list.connectTheLevelUsingNextReference();
		System.out.println();
		list.printLevelOrderUsingNext();
	}
	
}
