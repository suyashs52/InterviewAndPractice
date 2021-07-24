package com.educative.treedfs;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {
	static int found = 0;

	public static int countPaths(TreeNode root, int S) {
		List<TreeNode> node = new ArrayList<TreeNode>();
		return dfs(root, S, node);

	}

	public static int dfs(TreeNode root, int s, List<TreeNode> node) {
		if (root == null)
			return 0;
		node.add(root);

		ListIterator<TreeNode> n = node.listIterator(node.size());
		int rootcount = 0;
		int count = 0;
		while (n.hasPrevious()) {
			rootcount += n.previous().val;
			if (rootcount == s) {
				count++;
				break;
			}
		}
		//count below node
		count += dfs(root.left, s, node);
		count += dfs(root.right, s, node);

		node.remove(node.size() - 1);
		return count;

	}

	public static int countPathss(TreeNode root, int S) {
		found = 0;
		dfss(root, S, 0);
		return found;
	}

	public static int dfss(TreeNode root, int s, int count) {
		if (root == null)
			return found;

		if (root.val == s) {
			found++;
			return found;
		}
		dfss(root.left, s - root.val, count);

		dfss(root.right, s - root.val, count);
		dfss(root.left, s, count);

		dfss(root.right, s, count);
		return found;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));

		root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(3);
		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 12));

	}

}
