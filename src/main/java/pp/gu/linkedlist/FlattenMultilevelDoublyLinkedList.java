package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FlattenMultilevelDoublyLinkedList {

	public static void main(String[] args) throws IOException {
		// https://leetcode.com/problems/copy-list-with-random-pointer/
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		// l5.next = l2;

		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;

		l5.prev = l4;
		l4.prev = l3;
		l3.prev = l2;
		l2.prev = l1;

		l3.child = l6;
		l6.child = l7;
		l7.next = l8;
		l7.child = l9;
		System.out.println(l1);
		System.out.println(flatten(l1));
		ListNode t=l1;
		while(t.next!=null) {
			System.out.print(t.val);
			t=t.next;
		}
		System.err.println("ffff");
		while(t.prev!=null) {
			System.out.print(t.val);
			t=t.prev;
		}
		System.err.println("ffff");
	}

	public static ListNode flatten(ListNode head) {
		if (head == null)
			return head;

		ListNode first = head;

		while (first != null) {
			if (first.child != null) {
				ListNode temp = first.next;
				first.next = first.child;
				first.child.prev = first;
				ListNode t1 = flatten(first.next); //recursive call to add in next of each child
				if (t1 != null) {
					while (t1.next != null) {
						t1 = t1.next;
					}
					t1.next = temp;
				}

				if (temp != null)
					temp.prev = t1;
				first = temp;
				 
			} else
				first = first.next;
		}
		
		
		first=head;
		while(first!=null) {
			first.child=null;
			first=first.next;
		}
		

		return head;

	}

	private static void merge(ListNode head, ListNode bottom) {
		// TODO Auto-generated method stub

	}

}
