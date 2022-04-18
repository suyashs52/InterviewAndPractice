package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RemoveLoopLinkedList {

	public static void main(String[] args) throws IOException {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		l5.next = l2;
		l4.next = l5;
		l3.next = l4;
		l2.next = l3;
		l1.next = l2;
		countNodesinLoop(l1);
		System.out.println(l1);

	}

	static void countNodesinLoop(ListNode head) {

		// Add your code here.
		// when we move two pointer by 1 difference in circle they ll meet at some point
		// a=3,b=4 starting point is 0 and last is 9
		// 0 3 6 9 2 5 8 1 4 7 0
		// 0 4 8 3 7 1 5 9 3 7
		// otherwise they ll escape
		int c = 0;

		ListNode first = head;
		if (first == null)
			return ;
		ListNode sec = head.next;
		boolean found = false;
		while (sec != null && sec.next != null) {
			first = first.next;
			sec = sec.next.next;
			if (first == sec) { // point to same address
				found = true;
				break;
			}

		}

		if (found) {
			ListNode start = head;
			// sec and start will next meet at common node;.
			while (sec.next != start) {
				start = start.next;
				sec = sec.next;
			}
			sec.next = null;
		}

	}
}
