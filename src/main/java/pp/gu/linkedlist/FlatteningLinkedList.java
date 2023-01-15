package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FlatteningLinkedList {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
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
		l2.bottom = l6;
		l6.bottom = l7;

		System.out.println(flatten(l1));
		System.out.println(l1);
	}

	static ListNode flatten(ListNode root) {

		if (root.next == null)
			return root;
		ListNode s = root;
		// flattening should be done bottom wise
		// root and root.next two list merge them to single list
		// using recursion
		ListNode s1 = flatten(root.next);

		// now we have last 2 valid list for each call
		// merge this to root

		s = merge(s, s1);

		return s;
	}

	static ListNode merge(ListNode s, ListNode s1) {
		if (s == null)
			return s1;
		if (s1 == null)
			return s;

		ListNode result;

		if (s.val < s1.val) {
			result = s;
			result.bottom = merge(s.bottom, s1);
		} else {
			result = s1;
			result.bottom = merge(s, s1.bottom);
		}

		result.next = null;
		return result;

	}
}
