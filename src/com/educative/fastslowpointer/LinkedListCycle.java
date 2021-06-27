package com.educative.fastslowpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
	int value = 0;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}

public class LinkedListCycle {

	public static boolean hasCycle(ListNode head) {
		 
		ListNode node = head;
		ListNode next = head.next;
		while (next.next != null) {
			node = node.next;
			next = next.next.next;

			if (node == next)
				return true;
		}

		return false;
	}

	public static void main(String[] arg) throws InterruptedException {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

	}

}
