package com.educative.reversallinkedlist;

public class ReverseKSubList {

	public static ListNode reverse(ListNode head, int k) {
		// 1 2 3 4 5 6 7 8
		// 3 2 1 6 5 4 8 7
		ListNode curr = head;
		ListNode prev = null;
		while (true) {
			ListNode prevLast = prev; // null for head,1 for 4,5,6
			ListNode first = curr;

			// reversing
			prev = null;
			for (int i = 0; i < k && curr != null; i++) {
				ListNode temp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp;
			}

			// setting prevElement next pointer
			if (prevLast == null) {
				head = prev;

			} else {
				prevLast.next = prev;
			}

			if (curr == null)
				break;

			prev = first;

		}

		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = ReverseKSubList.reverse(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
