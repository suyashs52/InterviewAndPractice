package com.array;

import org.w3c.dom.NodeList;

class SingleLinkedList {
	public static void main(String... str) {
		int[] arr = new int[] { 4,5,6,1 ,10,20};
		SingleLinkedList list = new SingleLinkedList(arr);
		list.reverse();
		System.out.println(list);
		ListNode head1 = head;
		
		list.sortList(head1);

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

	private static ListNode head;
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
		if (head.next != null) {
			head = head.next;
			reverse(head, null);
			ListNode n = new ListNode();
			n.next = head;
			head = n;
		}

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

	private static final int SENTRY = Integer.MAX_VALUE;
	// DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

	// DO NOT CHANGE ANYTHING IN THIS FUNCTION
	public static ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode mid = findMidAndBreak(head);
		return mergeLists(sortList(head), sortList(mid));
	}

	public static ListNode findMidAndBreak(ListNode head) {
		// homework
		if (head == null)
			return head;
		ListNode first = head, sec = head;

		while (sec.next != null && sec.next.next != null) {
			first = first.next;
			sec = sec.next.next;
		}
		head=first.next;
		ListNode midne=first.next;
		first.next=null;
		
		return midne;
	}

	public static ListNode mergeLists(ListNode list1, ListNode list2) {
		// homework
		ListNode result = null;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		
		if(list1.val<list2.val) {
			result=list1;
			result.next=mergeLists(list1.next, list2);
			
		}else {
			result=list2;
			result.next=mergeLists(list1, list2.next);
			
		}
		return result;
	}

}
