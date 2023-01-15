package com.educative.treedfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathWithGivenSequence {

	public static boolean findPath(TreeNode root, int[] sequence) {
		if (root == null)
			return false;
		return dfs(root, sequence, 0);
	}

	static boolean dfs(TreeNode root, int[] sequence, int index) {
		if (root == null) {
			return false;
		}
		if (root.val != sequence[index]) {
			return false;
		}

		if (root.val == sequence[index] && index < sequence.length && root.left == null && root.right == null) {
			return true;

		}
		if (index == sequence.length) {
			return true;
		}

		return dfs(root.left, sequence, index + 1) || dfs(root.right, sequence, index + 1);

	}

	static boolean dfs1(TreeNode root, int[] sequence, int index) {
		if (root == null) {
			return false;
		}
		if (root.val != sequence[index]) {
			return false;
		}

		if (root.val == sequence[index] && index < sequence.length) {
			index++;

		}
		if (index == sequence.length) {
			return true;
		}

		return dfs(root.left, sequence, index) || dfs(root.right, sequence, index);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}

}
