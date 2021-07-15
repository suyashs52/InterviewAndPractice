package com.educative.treedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MaximumPathSum {
	static int max = Integer.MIN_VALUE;

	public static int findMaximumPathSum(TreeNode root) {
		max = 0;
		dfs(root);
		return max;
	}

	private static int dfs(TreeNode root) {

		if (root == null)
			return 0;
		 
		int c1 = dfs(root.left);
		int c2 = dfs(root.right);

		// if negative so ignore
		c1 = Math.max(c1, 0);
		c2 = Math.max(c2, 0);

		max = Math.max(max, c1 + c2 + root.val);

		return Math.max(c1, c2) + root.val;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

		root = new TreeNode(-1);
		root.left = new TreeNode(-3);
		System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

	}

}
