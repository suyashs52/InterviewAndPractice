package com.educative.treebfs;

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

public class LevelOrderTraversal {
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		// queue has records has left and right node
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {

			List<Integer> arr = new ArrayList<Integer>();
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TreeNode j = queue.poll();
				arr.add(j.val);
				if (j.left != null) {
					queue.add(j.left);

				}
				if (j.right != null) {
					queue.add(j.right);
				}

			}

			result.add(arr);

		}

		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = LevelOrderTraversal.traverse(root);
		System.out.println("Level order traversal: " + result);
	}

}
