package pp.m4.bst;

import java.io.IOException;

public class KthSmallestBST {

	public static void main(String[] args) throws IOException {
		// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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
		System.out.println(kthSmallest(t2, 1));

	}

	static int val = -1;
	static int i = 1;

	public static int kthSmallest(TreeNode root, int k) {
		val = -1;
		i = 1;
		smallest(root, k);
		return val;

	}

	private static void smallest(TreeNode root, int k) {
		if(val!=-1) return;
		if(root==null) return;
		smallest(root.left,k);
		
		if(i==k) { //first left most is smallest so we start counter after this
			val=root.val;
		}
		i++;
		smallest(root.right,k);
	}

}
