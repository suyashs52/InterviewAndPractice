package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ReverseLinkedList {

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
		System.out.println(reverseList(l1));
		System.out.println(reverseListRec(l1));
	}

	private static ListNode reverseListRec(ListNode l1) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ListNode reverseList(ListNode head) {

		// 1-2-3-4-5
		// let 1-2 already reverse r(3-4-5)
		// so current is at 2 , so temp point to 3
		// 2.next point to 1(prev) ,next curr =3(temp) and prev should be 2 repeat till
		// last
		ListNode temp;
		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;

		}

		return prev; // last curr ll point to null

	}
}
