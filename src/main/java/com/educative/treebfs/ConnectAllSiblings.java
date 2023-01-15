package com.educative.treebfs;

import java.util.*;

public class ConnectAllSiblings {
	public static void connect(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);
		TreeNode tn = null;
		while (!queue.isEmpty()) {

			int n = queue.size();
			TreeNode p = null;
			TreeNode prev = null;
			for (int i = 0; i < n; i++) {
				p = queue.poll();
				if (prev != null) {
					prev.next = p;
				} else if (tn != null) {
					tn.next = p;
				}
				prev = p;

				if (p.left != null) {
					queue.add(p.left);
				}
				if (p.right != null) {
					queue.add(p.right);
				}

			}

			tn = p;

		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		ConnectAllSiblings.connect(root);

		TreeNode current = root;
		System.out.println("traversing");

		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

}
