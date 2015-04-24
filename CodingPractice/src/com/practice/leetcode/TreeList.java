package com.practice.leetcode;

class Node {
    int data;
    Node small;
    Node large;
    
    public Node(int data) {
        this.data = data;
        small = null;
        large = null;
    }
}

public class TreeList {
   	
   public static void join(Node a, Node b) {
       a.large = b;
       b.small = a;
   }

   public static Node append(Node a, Node b) {
       if (a==null) return(b);
       if (b==null) return(a);
   
       Node aLast = a.small;
       Node bLast = b.small;
       
       join(aLast, b);
       join(bLast, a);
       
       return(a);
   }

   public static Node treeToList(Node root) {
       if (root==null) return(null);
       
       Node aList = treeToList(root.small);
       Node bList = treeToList(root.large);
       
       root.small = root;
       root.large = root;
       
       aList = append(aList, root);
       aList = append(aList, bList);
       
       return(aList);
   }

   public static void treeInsert(Node root, int newData) {
       if (newData<=root.data) {
           if (root.small!=null) treeInsert(root.small, newData);
           else root.small = new Node(newData);
       }
       else {
           if (root.large!=null) treeInsert(root.large, newData);
           else root.large = new Node(newData);
       }
   }
   
   public static void printTree(Node root) {
       if (root==null) return;
       printTree(root.small);
       System.out.print(Integer.toString(root.data) + " ");
       printTree(root.large);
   }
   
   public static void printList(Node head) {
       Node current = head;
       
       while (current != null) {
           System.out.print(Integer.toString(current.data) + " ");
           current = current.large;
           if (current == head) break;
       }
       
       System.out.println();
   }
           
   public static void main(String[] args) {
       Node root = new Node(4);
       treeInsert(root, 2);
       treeInsert(root, 1);
       treeInsert(root, 3);
       treeInsert(root, 5);
       
       System.out.println("tree:");
       printTree(root);   // 1 2 3 4 5
       System.out.println();
       
       System.out.println("list:");
       Node head = treeToList(root);
       printList(head);   // 1 2 3 4 5   yay!
   }
}

