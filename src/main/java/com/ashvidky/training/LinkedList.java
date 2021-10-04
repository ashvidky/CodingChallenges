package com.ashvidky.training;

public class LinkedList {

	Node head; // head of the list
	int size = 0;

	class Node {
		int data;
		Node next;
		Node(int d){

			data = d;
			next = null;
		}
	}
	
	public void add(int e) {
		Node node = new Node(e);
		
		if (head == null)
			head = node;
		else {
			node.next = head;
			head = node;
		}
		
		size++;
	}
	
	public void add(Node node) {
		
		if (node == null)
			return;
		
		if (head == null)
			head = node;
		else {
			node.next = head;
			head = node;
		}
		
		size++;
	}
	
	static int i = 1;
	public Node nthToLastRecursive(Node head, int n) {
		
		if (head == null)
			return null;
		
		Node node = nthToLastRecursive(head.next, n);
		
		if (i++ == n)
			return head;
			
		return node;
	}
	
	/*
	 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node
	 *	EXAMPLE
	 *	Input: the node ‘c’ from the linked list a->b->c->d->e
	 *	Result: nothing is returned, but the new linked list looks like a->b->d->e
	 */
	public void deleteCurrentNode(Node n) {
		
		if (n == null)
			return;
		
		// cannot delete last node
		if (n.next == null)
			n.data = -1;
		
		// copy data
		n.data = n.next.data;
		
		// remove next node
		n.next = n.next.next;
		
		size--;
	}

	public int size() {
		return size;
	}

	public boolean isExist(int v){
		
		Node c = head;
		while (c != null) {
			
			if (c.data == v)
				return true;
			else
				c = c.next;
		}
		
		return false;
	}
	
	/*
	 * You have two numbers represented by a linked list, where each node contains a single digit 
	 * The digits are stored in reverse order, such that the 1’s digit is at the head of the 
	 * list Write a function that adds the two numbers and returns the sum as a linked list
	 * EXAMPLE
	 * Input: (3 -> 1 -> 5), (5 -> 9 -> 2) Output: 8 -> 0 -> 8
	 */
	public static LinkedList sumNumbers(LinkedList l1, LinkedList l2) {
		
		int n1 = listToNumber(l1.head);
		int n2 = listToNumber(l2.head);
		
		int result = n1 + n2;
		
		LinkedList resultList = new LinkedList();
		char[] digitArray = String.valueOf(result).toCharArray();
		for (int i = digitArray.length -1; i >= 0; i--) {
			
			resultList.add(Character.getNumericValue(digitArray[i]));
		}
		
		return resultList;
	}

	public static int listToNumber(Node n) {
		
		if (n == null)
			return 0;
		
		int result = listToNumber(n.next);
		
		return result * 10 + n.data;
	}
}
