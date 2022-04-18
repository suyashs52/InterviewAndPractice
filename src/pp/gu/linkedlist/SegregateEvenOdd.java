package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SegregateEvenOdd {

	public static void main(String[] args) throws IOException {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		// l5.next = l2;
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;

		System.out.println(divide(5, l1));

	}

	static ListNode divide(int N, ListNode head) {
		// code here
		ListNode even = new ListNode(-1);
		ListNode odd = new ListNode(-1);
		ListNode e = even;
		ListNode o = odd;

		while (head != null) {
			if ((head.val & 1) == 1) { // odd value
				odd.next = head;
				odd = odd.next;
			} else {
				even.next = head;
				even = even.next;
			}
			head = head.next;
		}

		if (e.next == null)
			return o.next;
		else {
			even.next = o.next;
			// in gfg not compile if
			odd.next = null;
			o = null;
			// e.next = o.next;
		}

		return e.next;
	}
}
