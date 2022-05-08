package pp.m4.bst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1/#
		 
		TreeNode t4 = new TreeNode(2, null, null);
		TreeNode t3 = new TreeNode(5, null, null);
		TreeNode t2 = new TreeNode(14, t4, t3);

		System.out.println(binaryTreeToBST(t2));

	}

	static TreeNode binaryTreeToBST(TreeNode root) {

		// tree is not sorted binary tree is inorder sorted
		// add all element in priority queue or in array and sort it

		ArrayList<Integer> list = new ArrayList<>();
		inorder(root, list);
		Collections.sort(list);
		i = 0;
		makeTree(root, list);
		return root;
	}

	private static void inorder(TreeNode root, ArrayList<Integer> list) {

		if (root == null)
			return;

		inorder(root.left, list);
		
		list.add(root.val);
		inorder(root.right, list);
	}

	static int i = 0;

	static void makeTree(TreeNode root, ArrayList<Integer> list) {

		if (root == null)
			return;

		makeTree(root.left, list);

		root.val = list.get(i++);

		makeTree(root.right, list);
	}

}
