package com.ashvidky.training;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class StacksTest {

	@Test
	public void sort() {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(6);
		stack.push(2);
		stack.push(10);
		stack.push(3);
		stack.push(3);
		stack.push(1);
		stack.push(8);
		
		Stack<Integer> sorted = Stacks.sort(stack);
		
		sorted.stream().forEach(e->System.out.println(String.valueOf(e)));
	}
}
