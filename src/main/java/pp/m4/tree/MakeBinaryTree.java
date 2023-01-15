package pp.m4.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import pp.gu.linkedlist.ListNode;

public class MakeBinaryTree {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/make-binary-tree/1
		ListNode l1 = new ListNode(36);
		ListNode l2 = new ListNode(30, l1);
		ListNode l3 = new ListNode(25, l2);
		ListNode l4 = new ListNode(15, l3);
		ListNode l5 = new ListNode(12, l4);
		ListNode l6 = new ListNode(10, l5);
		TreeNode node = null;

		System.out.println(convert(l6, node));

	}

	public static TreeNode convert(ListNode head, TreeNode node) {
		if (head != null)
			node = new TreeNode(head.val);

		ListNode f = head;
		ListNode s = f.next;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		while (q.isEmpty() == false) {
			TreeNode n = q.poll();
			if (s != null) {
				n.left = new TreeNode(s.val);
				s = s.next;
				q.add(n.left);
			}
			if (s != null) {
				n.right = new TreeNode(s.val);
				s = s.next;
				q.add(n.right);
			}

		}
		return node;

	}

}
