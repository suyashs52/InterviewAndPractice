package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ReverseLinkedListK {
	// https://leetcode.com/problems/reverse-linked-list-ii/

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
		System.out.println(reverseBetween(l1, 2, 4));

	}

	public static ListNode reverseBetween(ListNode head, int left, int right) {

		int in = 1;
		ListNode f = head;
		ListNode pf = null; // prev node point to reversed list
		while (in < left) {
			pf = f;
			f = f.next;
			in++;
		}

		ListNode prev = null;
		ListNode curr = f;
		ListNode temp = null;
		while (in <= right) { // 1 2 3 4 5 // null<-1<--2 ---3 4 5 prev is 2, curr is 3
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			in++;
		}

		// at last curr would be pointing to right+1 value //2 3 4

		if (pf != null) {
			//check image 
			if (pf.next != null) {
				pf.next.next = temp; //temp contain next last value

			}

			pf.next = prev;
		} else {
			head.next = temp;
			head = prev;

		}

		return head;

	}
}
