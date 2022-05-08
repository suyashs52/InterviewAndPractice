package pp.m4.tree;

import java.io.IOException;
import java.util.ArrayList;

import pp.gu.linkedlist.ListNode;

public class MidDistanceBetween2Node {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
		TreeNode t10 = new TreeNode(8, null, null);
		TreeNode t9 = new TreeNode(3, null, null);
		TreeNode t8 = new TreeNode(5, null, t9);

		TreeNode t6 = new TreeNode(7, null, null);
		TreeNode t5 = new TreeNode(2, null, null);

		TreeNode t3 = new TreeNode(10, t6, t5);
		TreeNode t2 = new TreeNode(4, t8, t3);
		ArrayList<Integer> A = new ArrayList<Integer>();
		 
		System.out.println(findDist(t2, 4, 7));
	}

	private static int findDist(TreeNode t2, int i, int j) {
		// TODO Auto-generated method stub
		TreeNode node = lowestCommonNode(t2, i, j);

		if (node == null)
			return -1;

		return finddist(node, i) + finddist(node, j) - 2; // as we are returning 1 if found should be 0

	}

	private static int finddist(TreeNode node, int i) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;
		if (node.val == i)
			return 1;

		int l = finddist(node.left, i);
		int r = finddist(node.right, i);
		if (l > 0)
			return 1 + l;
		else if (r > 0)
			return r + 1;
		return 0;
	}

	private static TreeNode lowestCommonNode(TreeNode t2, int i, int j) {
		if (t2 == null)
			return null;
		if (t2.val == i || t2.val == j)
			return t2; // return the node when matches only

		TreeNode left = lowestCommonNode(t2.left, i, j);
		TreeNode right = lowestCommonNode(t2.right, i, j);

		if (left != null && right != null) { // means i and j is at different branch so return common node means root
			return t2;

		} else if (left != null) {
			return left;// i/j is in left part so return left node
		} else if (right != null) { //// i/j is in left part so return left node
			return right;
		}

		// we are returning node if found otherwise returning null;

		return null;
	}

}
