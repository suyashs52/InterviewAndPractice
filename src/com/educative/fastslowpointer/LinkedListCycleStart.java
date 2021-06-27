package com.educative.fastslowpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkedListCycleStart {

	public static ListNode findCycleStart(ListNode head) {
		ListNode cycle = head;

		// find cycle length
		ListNode f = head;
		ListNode n = head.next;
		int len = 0;
		while (f!= null && n.next != null) {
			f = f.next;
			n = n.next.next;
			if (f == n) {
				n = n.next;
				len++;
				while (f != n) {
					n = n.next;
					len++;
				}
				break;
			}
		}
		n=head;
		while(len>0) {
			n=n.next;
			len--;
		}
		f=head;
		while(f!=n) {
			f=f.next;
			n=n.next;
		}
		
		return f;

	 
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head.next.next.next.next.next.next = head.next.next;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

		head.next.next.next.next.next.next = head.next.next.next;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

		head.next.next.next.next.next.next = head;
		System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
	}

}
