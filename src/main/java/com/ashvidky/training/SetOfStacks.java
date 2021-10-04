package com.ashvidky.training;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<E> {

	private int capacity;
	
	private ArrayList<Stack<E>> listOfStacks = new ArrayList<>();

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	
	public void push(E e) {
		if (e != null) {
			Stack<E> stack = listOfStacks.get(0);
			if (stack == null || stack.size() >= capacity) {
				stack = new Stack<E>();
				listOfStacks.add(stack);
			}
			stack.push(e);
		}
	}
	
	public E pop() {
		E value = null;
		Stack<E> stack = listOfStacks.get(0);
		if (stack != null) {
			value = stack.pop();
			if (stack.size() == 0)
				listOfStacks.remove(0);
		}
		return value;
	}
	
	public E peek() {
		E value = null;
		Stack<E> stack = listOfStacks.get(0);
		if (stack != null) 
			value = stack.peek();
		
		return value;
	}
	
	public E popAt(int index) {
		
		if (index >= listOfStacks.size())
			throw new IndexOutOfBoundsException("Out of bound:" + index);
		
		Stack<E> stack = listOfStacks.get(index);
		E value = stack.pop();
		if (stack.size() == 0)
			listOfStacks.remove(index);
		
		return value;
	}
}
