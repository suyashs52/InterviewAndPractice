package pp.m4.bst;

import java.io.IOException;

public class ValidateBinarySearch {

	public static void main(String[] args) throws IOException {
		// https://leetcode.com/problems/validate-binary-search-tree/
		TreeNode t10 = new TreeNode(8, null, null);
		TreeNode t9 = new TreeNode(3, null, null);
		TreeNode t8 = new TreeNode(5, null, t9);
		TreeNode t7 = new TreeNode(10, t10, null);
		TreeNode t6 = new TreeNode(7, null, null);
		TreeNode t5 = new TreeNode(2, null, null);
		TreeNode t4 = new TreeNode(4, t8, t7);
		TreeNode t3 = new TreeNode(10, t6, t5);
		TreeNode t2 = new TreeNode(4, t4, t3);

		System.out.println(isValidBST(t2));

	}

	static long prev = (long) Integer.MIN_VALUE - 1;
	static boolean isValid = true;

	public static boolean isValidBST(TreeNode root) {
		// if inorder is sorted order then it is valid bst
		prev = (long) Integer.MIN_VALUE - 1;
		isValid = true;
		isValid = inorder(root);
		return isValid;

	}

	class isbst {
		boolean is;
	}

	private static boolean leftrootright(TreeNode root, Integer low, Integer high) {
		// root is greater then left max and lesser then right min
		if (root == null)
			return true;

		// left next min high value is root node
		// right next max min value is root node

		if (low != null && root.val <= low) { // root should be greater
			return false;
		}
		if (high == null && root.val >= high) // root should be smaller
		{
			return false;
		}
		
		return leftrootright(root.left, low, root.val) && leftrootright(root.right, root.val, high);

	}

	private static boolean inorder(TreeNode root) {
		if (isValid == false)
			return isValid;
		if (root == null)
			return isValid;

		inorder(root.left);
		if (root.val < prev) { // node value if lesser than left value so not valid bst /right value less then
								// root
			isValid = false;
			return isValid;
		}
		prev = root.val;
		inorder(root.right);

		return isValid;

	}

}
