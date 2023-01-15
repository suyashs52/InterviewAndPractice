package pp.m4.tree;

import java.io.IOException;
import java.util.ArrayList;

import pp.gu.linkedlist.ListNode;

public class SerializeDeseraializeData {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
		TreeNode t10 = new TreeNode(8, null, null);
		TreeNode t9 = new TreeNode(3, null, null);
		TreeNode t8 = new TreeNode(5, null, t9);
		TreeNode t7 = new TreeNode(10, t10, null);
		TreeNode t6 = new TreeNode(7, null, null);
		TreeNode t5 = new TreeNode(2, null, null);
		TreeNode t4 = new TreeNode(4, t8, t7);
		TreeNode t3 = new TreeNode(10, t6, t5);
		TreeNode t2 = new TreeNode(4, t4, t3);
		ArrayList<Integer> A = new ArrayList<Integer>();
		System.out.println(t2);
		serialize(t2, A);

		System.out.println(deSerialize(A));
	}

	public static void serialize(TreeNode root, ArrayList<Integer> A) {
		// code here
		if (root == null) {
			A.add(null);
			return;
		}

		// preorder
		A.add(root.val);
		serialize(root.left, A);
		serialize(root.right, A);

	}

	public static TreeNode deSerialize(ArrayList<Integer> A) {
		// code here
		TreeNode head = null;
		index.index=0;
		head = decode(A);
		return head;
	}

	static class index {
		static Integer index;
	}

	static TreeNode decode(ArrayList<Integer> A) {
		if (index.index > A.size() - 1)
			return null;
		//System.out.println(index.index);
		if (A.get(index.index) == null) {
			//index.index++;
			return null;
		}

		TreeNode head = new TreeNode(A.get(index.index));
		if (head != null) {
			index.index++;
			head.left = decode(A);
			
			index.index++;
			head.right = decode(A);

		}

		return head;

	}

}
