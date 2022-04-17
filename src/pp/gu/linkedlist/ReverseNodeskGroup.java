package pp.gu.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ReverseNodeskGroup {
	// https://leetcode.com/problems/reverse-nodes-in-k-group/

	public static void main(String[] args) throws IOException {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);

		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;

		System.out.println(l1);
		System.out.println(reverseKGroup(l1, 1));

	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		if(k==1) return head;
		if(head.next==null) return head;

		int size = 1;

		ListNode ncurr = head;

		while (ncurr != null && size <= k) {
			ncurr = ncurr.next;
			size++;
		}

		if (size <= k) {
			return head;
		}

		size = 1;
		//ncurr point to next node
		ListNode prev = null;
		ListNode cu = head;
		ListNode temp = null;
		while (size <= k) { // null 1->2->3
			temp = cu.next;
			cu.next = prev;
			prev = cu;
			cu = temp;
			size++;
		}
		ListNode pcurr = head; // 1
		head.next = ncurr; // 1.next=3
		head = prev; // head=2

		// iterate from next
		while (ncurr != null) {
			size = 1;
			 ListNode start=pcurr.next;
			while (ncurr != null && size <= k) {
				ncurr = ncurr.next;
				size++;
			}
			if (size <= k) {
				return head;
			}

			size = 1;
			 
			prev = null;
			cu = start;
			temp = null;
			while (size <= k) { // null 1->2->3
				temp = cu.next;
				cu.next = prev;
				prev = cu;
				cu = temp;
				size++;
			}
			 
			pcurr.next=prev; //2->1 (pcurr) -->4 
			pcurr=start;   //next pcurr is 3
			start.next=ncurr;
			
		}

		return head;
	}
}
