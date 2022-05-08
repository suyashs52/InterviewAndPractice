package pp.m4.bst;

import java.io.IOException;

public class LargestBST {

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

		System.out.println(largestBst(t2));

	}

	static class bst {
		boolean isBST = true;
		int min = 10000007;
		int max = -1;
		int count = 0;
		TreeNode node;
	}

	static int largestBst(TreeNode root) {
		// Write your code here
		if (root == null)
			return 0;
		bst b = calcTree(root);

		return b.count;

	}

	static bst calcTree(TreeNode root) {

		if (root == null) {
			bst b = new bst();
			b.node = null;
			return b;
		}

		bst l = calcTree(root.left);

		bst r = calcTree(root.right);

		if (l.isBST && r.isBST) {

			bst b = new bst();
			if (root.val > l.max && root.val < r.min) { //root value should be greater than largest
				b.count = 1 + l.count + r.count;
				b.min = Math.min(root.val,l.min); //min of a node is min of left 
				b.max = Math.max(root.val,r.max); // max of a node is max of right val
				return b;
			} else {
				b.isBST = false;
				b.count = Math.max(l.count, r.count);
				return b;
			}

		} else {
			bst b = new bst();
			b.isBST = false;
			b.count = Math.max(l.count, r.count);
			return b;
		}

	}

}
