package com.ashvidky.training;

import java.util.Stack;

public class Stacks {

	public static Stack<Integer> sort(Stack<Integer> stack) {

		Stack<Integer> stack2 = new Stack<Integer>();

		while (!stack.empty()) {
			Integer n = stack.pop();

			while(!stack2.isEmpty() && stack2.peek() > n) 
				stack.push(stack2.pop());
			
			stack2.push(n);
		}
		
		return stack2;
	}
}
