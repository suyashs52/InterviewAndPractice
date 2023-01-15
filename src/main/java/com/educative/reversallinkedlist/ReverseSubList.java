package com.educative.reversallinkedlist;

public class ReverseSubList {

	public static ListNode reverse(ListNode head, int p, int q) {
		// two positions ‘p’ and ‘q’
		if (p == q) {
			return head;
		}
		p--;
		q--;

		ListNode prev = head;
		for (int i = 0; i < p - 1; i++) {
			prev = prev.next;
		}

		ListNode fStartPreNode = prev; // add refer to p
		ListNode fStarNode = prev.next;
		ListNode curr = fStarNode;

		ListNode next = null;
		 
		for (int i = p; i < q+1; i++) { //1-- 2,3,4--5
			next = curr.next; //next=3
			curr.next=prev;//assign curr=2.next=1
			prev=curr; //prev=2
			curr = next;//curr=3

		}

		fStartPreNode.next=prev;
		fStarNode.next=curr;
		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = ReverseSubList.reverse(head, 2, 4);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
