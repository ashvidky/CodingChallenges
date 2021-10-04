package com.ashvidky.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashvidky.training.LinkedList.Node;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class LinkedListTest {

	@Test
	public void nthToLast() {
		
		LinkedList ll = new LinkedList();
		ll.add(20);
		ll.add(4);
		ll.add(15);
		ll.add(35);
		
		Node nthToLast = ll.nthToLastRecursive(ll.head, 2);
		assertEquals(4, nthToLast.data);
	}
	
	@Test
	public void deleteNodeInTheMiddle() {
		
		LinkedList ll = new LinkedList();
		ll.add(20);		
		
		Node n = ll.new Node(4);
		ll.add(n);
		ll.add(15);
		ll.add(35);
		
		ll.deleteCurrentNode(n);
		
		assertEquals(3, ll.size());
		assertFalse(ll.isExist(4));
	}
		
	@Test
	public void sumNumbers() {
		
		LinkedList l1 = new LinkedList();
		l1.add(5);
		l1.add(1);
		l1.add(3);
		
		LinkedList l2 = new LinkedList();
		l2.add(2);
		l2.add(9);
		l2.add(5);
		
		LinkedList sumNumbers = LinkedList.sumNumbers(l1, l2);
		
		assertEquals(808, LinkedList.listToNumber(sumNumbers.head));
	}
}
