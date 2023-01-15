package pp.gu.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PalindromeLinkedList {
	// https://leetcode.com/problems/reverse-nodes-in-k-group/

	public static void main(String[] args) throws IOException {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);

		//l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;

		System.out.println(isPalindrome(l1));

	}

	public static boolean isPalindrome(ListNode head) {

		// find middle
		ListNode curr = head;
		ListNode next = head;
		while (next != null && next.next != null) {
			curr = curr.next;
			next = next.next.next;
		}

		// curr always point to next mid element

		ListNode mcurr = curr;
		ListNode prev = null;

		while (mcurr != null) {
			ListNode temp = mcurr.next;
			mcurr.next = prev;
			prev = mcurr;
			mcurr = temp;

		}

		mcurr = prev;

		while (mcurr != null) {
			if (mcurr.val != head.val) {
				return false;
			}
			mcurr = mcurr.next;
			head = head.next;
		}

		return true;
	}

}
