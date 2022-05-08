package pp.m4.tree;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import pp.gu.linkedlist.ListNode;

public class InorderLevelOrder {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/make-binary-tree/1
		ListNode l1 = new ListNode(36);
		ListNode l2 = new ListNode(30, l1);
		ListNode l3 = new ListNode(25, l2);
		ListNode l4 = new ListNode(15, l3);
		ListNode l5 = new ListNode(12, l4);
		ListNode l6 = new ListNode(10, l5);
		TreeNode node = null;

		System.out.println(buildTree(new int[] { 3, 1, 4, 0, 5, 2, 6 }, new int[] { 0, 1, 2, 3, 4, 5, 6 }));

	}

	static TreeNode buildTree(int inord[], int level[]) {
		// your code here

		TreeNode head = null;
		;
		TreeNode f = head;
		// level order first put node having less level
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < level.length; i++) {
			map.put(level[i], i);
		}
		head = buildTreeNode(0, inord.length - 1, map, inord);
		return head;
	}

	static TreeNode buildTreeNode(int f, int s, Map<Integer, Integer> map, int[] inord) {
		if (f > s)
			return null;
		if (s == f) {
			return new TreeNode(inord[s]);
		}

		// in all index who comes first so level wise
		int min = 10006;
		int index = -1;
		for (int i = f; i <= s; i++) { // inord: 3, 1, 4, 0, 5, lvel:0, 1, 2, 3, 4
			if (map.get(inord[i]) < min) {
				min = map.get(inord[i]);
				index = i;

			}

		}

		TreeNode n = new TreeNode(inord[index]);

		n.left = buildTreeNode(f, index - 1, map, inord);
		n.right = buildTreeNode(index + 1, s, map, inord);

		return n;

	}

}
