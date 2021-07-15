package com.educative.treedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TreeDiameter {
	static int max = 0;

	public static int findDiameter(TreeNode root) {
		max = 0;
		dfs(root, 0);
		return max;
	}

	private static int dfs(TreeNode root, int count) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;

		int c1 = dfs(root.left, count + 1);
		int c2 = dfs(root.right, count + 1);
		max = Math.max(c1 + c2 + 1, max); // max diameter
		return Math.max(c1, c2) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
		root.left.left = null;
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.left.right.left = new TreeNode(10);
		root.right.right.left.left = new TreeNode(11);
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
	}

}
