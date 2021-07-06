package com.educative.reversallinkedlist;

public class RotateList {

	public static ListNode reverse(ListNode head, int k) {
		// 1, 2, 3, 4, 5,
		// 4, 5, 1, 2, 3

		// k can be more than node value

		int len = 0;

		ListNode first = head;
		ListNode last = head;
		while (last.next != null) {
			last = last.next;
			len++;
		}
		len += 1;// including null

		int skip = k % len;
		last.next = head;

		for (int i = 0; i < skip-1; i++) {
			first = first.next;
		}
		head = first.next;
		first.next = null;
		
		// first.next = null;

		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode result = RotateList.reverse(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
