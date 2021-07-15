package com.educative.treedfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfPathNumbers {

	public static int findSumOfPathNumbers(TreeNode root) {
		int num = dfs(root, 0);
		return num;

	}

	static int dfs(TreeNode root, int num) {
		if (root == null) {
			return 0;
		}

		num = num * 10 + root.val;
		if (root.left == null && root.right == null) {
			return num;
		}
		return dfs(root.left, num) + dfs(root.right, num); // sum each leaf node

	}

	 
	public static void main(String[] arg) {
		 
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));

	}

}
