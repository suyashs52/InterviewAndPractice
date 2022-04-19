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
		l6.bottom=l7;

		System.out.println(flatten(l1));

	}

	static ListNode flatten(ListNode root) {

		ListNode s = root;
		// flat means bootom come in next so do it singlewise
		while (s != null) {
			ListNode temp = s.next;

			if (s.bottom != null) {
				s.next = s.bottom;
				s.bottom.next = temp;
			}
			s = s.next;
		}

		return root;
	}
}
