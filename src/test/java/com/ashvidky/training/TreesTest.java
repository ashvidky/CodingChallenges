package com.ashvidky.training;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashvidky.training.Trees.TreeNode;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class TreesTest {

	@Test
	public void print() {
		
		Trees t = new Trees();
		TreeNode root = t.new TreeNode();
		root.value = 5;
		root.left = t.new TreeNode();
		root.left.value = 8;
		root.right = t.new TreeNode();
		root.right.value = 3;
		
		TreeNode r = root.left;
		r.left = t.new TreeNode();
		r.left.value = 1;
		r.right = t.new TreeNode();
		r.right.value = 6;
		
		Trees.printInOrder(root);
	}
	
	@Test
	public void isRoute() {
		
		Trees t = new Trees();
		TreeNode root = t.new TreeNode();
		root.value = 5;
		root.left = t.new TreeNode();
		root.left.value = 8;
		root.right = t.new TreeNode();
		root.right.value = 3;
		
		TreeNode r = root.left;
		r.left = t.new TreeNode();
		r.left.value = 1;
		r.right = t.new TreeNode();
		r.right.value = 6;
		
		r.right.right = root;
		
		assertTrue(Trees.isRoute(r.right, root.right));
	}
	
	@Test
	public void buildTree() {
		
		int[] nodes = {1,2,3,5,7,8,9,12,25};
		
		Trees trees = new Trees();
		TreeNode tree = trees.buildTree(nodes);
		
		Trees.printInOrder(tree);
	}
}
