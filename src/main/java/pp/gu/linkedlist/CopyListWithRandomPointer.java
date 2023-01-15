package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CopyListWithRandomPointer {

	public static void main(String[] args) throws IOException {
		// https://leetcode.com/problems/copy-list-with-random-pointer/
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		// l5.next = l2;
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		l2.random = l6;
		l6.random = l7;
		System.out.println(l1);
		System.out.println(copyRandomList(l1));

	}

	public static ListNode copyRandomList(ListNode node) {
		// don't use extra space

		// we can avoid using extra space by tweaking the orginal node
		// we interweave the nodes of list and copied list
		if (node == null)
			return node;

		ListNode first = node;
		while (first != null) { // a->a'->b->b'->null

			ListNode newl = new ListNode(first.val);
			ListNode temp = first.next;
			first.next = newl;
			newl.next = temp;
			first = temp;
		}
		first = node;

		while (first.next != null && first.next.next != null) {

			if (first.random != null) // random point to elemen, so next value must point to random next
				first.next.random = first.random.next;
			first = first.next.next;
		}

		if (first.next != null && first.random != null) { // last node
			first.next.random = first.random.next;
		}
		 
		first = node;
		ListNode fn = first.next;
		ListNode head = node.next;
		while (fn != null && fn.next != null) { // a->a'->b->b'->null
			ListNode temp=first.next;
			first.next=temp.next;
			fn.next=first.next.next;
			first=first.next;
			fn=fn.next;
		}

		first.next=null; //last node should point to null
		return head;

	}

}
