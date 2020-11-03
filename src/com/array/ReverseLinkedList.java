package com.array;

import org.w3c.dom.NodeList;

class ReverseLinkedList {
	public static void main(String... str) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		SingleLinkedList list = new SingleLinkedList(arr);
		list.reverse();

		System.out.println(list);
	}

	static class ListNode {
		public int val;
		public ListNode next;

		public ListNode() {
			next = null;
		}

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	private ListNode head;
	private int size;

	public ListNode getHead() {
		return head;
	}

	public SingleLinkedList() {
		head = new ListNode(); // dummy node
	}

	public SingleLinkedList(int[] data) {
		this();
		if (data == null || data.length == 0) {
			return;
		}
		ListNode ptr = head;
		for (int datum : data) {
			ptr.next = new ListNode(datum);
			ptr = ptr.next;
			size++;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode ptr = head.next;
		while (ptr != null) {
			builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
			ptr = ptr.next;
		}
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof SingleLinkedList)) {
			return false;
		}

		SingleLinkedList otherList = (SingleLinkedList) obj;

		if (this.size != otherList.size) {
			return false;
		}
		ListNode n1 = head.next;
		ListNode n2 = otherList.head.next;
		while (n1 != null && n2 != null) {
			if (n1.val != n2.val) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		return (n1 == null && n2 == null);
	}

	public int getSize() {
		return size;
	}

	// reverse the linked list RECURSIVELY
	public void reverse() {
		// homework
		if (head == null) {

		}
		reverse(head, null);
	}

	public ListNode reverse(ListNode curr, ListNode prev) {
		if (curr.next == null) {
			head = curr;
			curr.next = prev;
			return head;
		}

		ListNode next1 = curr.next;
		curr.next = prev;
		reverse(next1, curr);
		return head;
	}

}
