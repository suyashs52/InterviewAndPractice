package com.educative.treedfs;

import java.util.*;

public class FindAllTreePaths {
	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Integer> st = new Stack<Integer>();

		findSumRecursive(result, st, sum, root);
		return result;

	}

	static void findSumRecursive(List<List<Integer>> result, Stack<Integer> stack, int sum, TreeNode root) {

		if (root == null) {
			return;
		}
		stack.push(root.val);
		if (root.val == sum) {
			result.add(new ArrayList<>(stack));
			stack.pop();
			return;
		}
		findSumRecursive(result, stack, sum - root.val, root.left);
		findSumRecursive(result, stack, sum - root.val, root.right);

		stack.pop();

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);
	}

}
