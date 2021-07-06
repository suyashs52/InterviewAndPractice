package com.educative.reversallinkedlist;

class ListNode {
	int value = 0;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}

public class ReverseLinkedList {

	public static ListNode reverse(ListNode head) {
		// 2 4 6 8 10
		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);

		ListNode result = ReverseLinkedList.reverse(head);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
