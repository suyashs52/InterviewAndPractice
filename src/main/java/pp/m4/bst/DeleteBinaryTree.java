package pp.m4.bst;

import java.io.IOException;

public class DeleteBinaryTree {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
		TreeNode t10 = new TreeNode(8, null, null);
		TreeNode t9 = new TreeNode(3, null, null);
		TreeNode t8 = new TreeNode(5, null, t9);
		TreeNode t7 = new TreeNode(10, t10, null);
		TreeNode t6 = new TreeNode(7, null, null);
		TreeNode t5 = new TreeNode(2, null, null);
		TreeNode t4 = new TreeNode(4, t8, t7);
		TreeNode t3 = new TreeNode(10, t6, t5);
		TreeNode t2 = new TreeNode(4, t4, t3);
		// TreeNode t1 = new TreeNode(4, t2, t3);

		//
		// System.out.println(bToDLL(t2));
		System.out.println(bToDLL1(t2));

	}

	static TreeNode head = null;
	static TreeNode prev = null;

	static TreeNode bToDLL(TreeNode root) {

		// Your code here
		head = null;

		ctdll(root);
		return head;
	}

	static TreeNode bToDLL1(TreeNode root) {

		// Your code here
		head = null;
		prev = null;
		inorder(root);
		return head;
	}

	static TreeNode inorder(TreeNode root) { 
		//we are changing last left node pointer left value , we won't visit that left in future
		//same prev right too that can't visit next 
		
		if (root == null)
			return root;

		inorder(root.left);
		if (head == null && root != null) { // first not null left node
			head = root;
			root.left = prev;
			prev = root;
		} else if (root != null) {
			root.left = prev;
			if (prev != null) {
				prev.right = root;
				prev = prev.right;
			} else {
				prev = root;
			}

		}

		inorder(root.right);

		return root;
	}

	static TreeNode ctdll(TreeNode root) {

		if (root == null)
			return root;
		if (root.left == null && root.right == null) {
			TreeNode n = new TreeNode(root.val);

			return n;
		}
		TreeNode center = new TreeNode(root.val);
		TreeNode left = ctdll(root.left);
		if (left != null) {
			while (left.right != null) {

				left = left.right;
			}
			left.right = center;
			// left.left = null;
		}

		center.left = left;
		TreeNode right = ctdll(root.right);
		if (right != null) {
			while (right != null && right.left != null) {

				right = right.left;
			}
			right.left = center;
			// right.right = null;

		}
		center.right = right;

		if (right == null)
			right = center;

		while (right != null && right.left != null) {

			right = right.left;
		}

		if (head == null) {
			head = right;
		}

		return right;

	}

}
