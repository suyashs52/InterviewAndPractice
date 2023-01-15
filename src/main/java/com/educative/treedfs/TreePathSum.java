package com.educative.treedfs;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;

	TreeNode(int x) {
		val = x;
		left = right = next = null;
	}
};

public class TreePathSum {
	static boolean isExist = false;

	static boolean isExist(TreeNode root, int sum) {
		isExist = false;
		dfs(root, sum);
		return isExist;

	}

	public static boolean dfs(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}

		if (root.val == sum) {
			isExist = true;
			return true;

		}
		dfs(root.left, sum - root.val);
		dfs(root.right, sum - root.val);
		return false;
	}

	public static boolean hasPath(TreeNode root, int sum) {
		return isExist(root, sum);
//		if (root == null) {
//			return false;
//		}
//
//		if (sum == root.val) {
//
//			return true;
//		}
//		// false || false || false || true || false .....=true
//		return TreePathSum.hasPath(root.left, sum - root.val) || TreePathSum.hasPath(root.right, sum - root.val);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));

		System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
	}

}
