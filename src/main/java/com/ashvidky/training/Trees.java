package com.ashvidky.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Trees {

	
	public class TreeNode{
		
		public Object value;
		
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode() {
		}
		
		public TreeNode(Object value) {
			this.value = value;
		}
		
		public TreeNode(Object value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void printInOrder(TreeNode root) {
		
		if (root.left != null)
			printInOrder(root.left);
		
		log.info(root.value.toString());
		
		if (root.right != null)
			printInOrder(root.right);
	}
	
	public static boolean isBalanced(TreeNode root) {
		
		if (root == null)
			return true;
		
		int max = checkMaxDepth(root);
		int min = checkMinDepth(root);
		
		return (max - min <= 1);
	}
	
	private static int checkMaxDepth(TreeNode node) {
		
		if (node == null)
			return 0;
		
		return 1 + Math.max(checkMaxDepth(node.left), checkMaxDepth(node.right));
	}
	
	private static int checkMinDepth(TreeNode node) {
		
		if (node == null)
			return 0;
		
		return 1 + Math.min(checkMaxDepth(node.left), checkMaxDepth(node.right));
	}
	
	public static boolean isRoute(TreeNode n1, TreeNode n2) {
		
		if (n1 == null || n2 == null)
			return false;
		
		Set<TreeNode> visited = new HashSet<Trees.TreeNode>();
		
		ArrayList<TreeNode> navigate = new ArrayList<>();
		navigate.add(n1);
		while(!navigate.isEmpty()) {
			TreeNode tn = navigate.remove(0);
			if (tn.equals(n2))
				return true;
			
			visited.add(tn);
			if (tn.left != null && !visited.contains(tn.left))
				navigate.add(tn.left);
			if (tn.right != null && !visited.contains(tn.right))
				navigate.add(tn.right);
		}
		
		return false;
	}
	
	public TreeNode buildTree(int[] array){
		
		if (array == null || array.length == 0)
			return null;
		
		if (array.length == 1)
			return new TreeNode(array[0]);
		
		int medium = array.length / 2;
		int currentValue = array[medium];
		
		int[] left = Arrays.copyOfRange(array, 0, medium);
		int[] right = Arrays.copyOfRange(array, medium + 1, array.length);
		
		TreeNode leftChild = buildTree(left);
		TreeNode rightChild = buildTree(right);	
		
		return new TreeNode(currentValue, leftChild, rightChild);
	}
}
