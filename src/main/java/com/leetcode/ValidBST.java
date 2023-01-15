package com.leetcode;

public class ValidBST {
	long value = Long.MIN_VALUE;
//is binary search valid
	boolean isValidBST(TreeNode node) {
		if (node == null)
			return true;
		boolean l = isValidBST(node.left);

		if (value >= node.val)
			return false;
		value = node.val;
		boolean r = isValidBST(node.right);
		return l && r;

	}

	boolean bstHelper(TreeNode node, Integer minVal, Integer maxVal) {
		if (node == null)
			return true;

		if (minVal != null && minVal >= node.val)
			return false;

		if (maxVal != null && maxVal <= node.val)
			return false;

		boolean left = bstHelper(node.left, minVal, node.val); //left has min value from current
		boolean right = bstHelper(node.right, node.val, maxVal); //right has max value from current

		return left && right;

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}