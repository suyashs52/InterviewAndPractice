package pp.gu.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ReorderList {
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
		reorderList(l1);
		System.out.println(l1);

	}

	public static void reorderList(ListNode head) {

		// find middle
		ListNode curr = head;
		ListNode next = head;
		while (next != null && next.next != null) {
			curr = curr.next;
			next = next.next.next;
		}

		ListNode newNode = curr.next;
		curr.next = null;

		// reverse new node list

		ListNode prev = null;
		ListNode cr = newNode;

		while (cr != null) {
			ListNode temp = cr.next;
			cr.next = prev;
			prev = cr;
			cr = temp;
		}
		newNode = prev; // 4->null
		// add now
		cr = head; // 1->2->3->null
		while (newNode != null) {
			ListNode temp = cr.next; // 2->3->null
			cr.next = newNode; // 1->4
			cr = temp; // cr=2->3
			temp = newNode.next; // temp=4->null
			newNode.next = cr; // 4->2
			newNode = temp; // newNode=null

		}

	}
}
