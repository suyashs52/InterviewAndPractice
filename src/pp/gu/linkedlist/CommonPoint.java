package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CommonPoint {

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

		ListNode l6 = new ListNode(6);
		l6.next = l5;

		System.out.println(intersectPoint(l1, l6));

	}

	static int intersectPoint(ListNode head1, ListNode head2) {
		// code here
		int val = -1;

		// n1:1-2-3-4-5-null
		// n2:6-5-null
		// when n1 4-5-null then both ll move 1 step to come to joint point
		// n1 need to travel 3 step extra to match common node
		// difference in length is 3: so first move n1 to 3 steps not common point ll be
		// answer
		// move next node multiple of lesser length till n-1

//		 while(ptr1!=ptr2){
//	            ptr1=ptr1.next;
//	            ptr2=ptr2.next;
//	            if(ptr1==ptr2){
//	                return ptr1.data;
//	            }
//	             if (ptr1 == null) {
//
//	           ptr1 = head2;
//	       }
//	        if (ptr2== null) {
//
//	           ptr2 = head1;
//	       }
//	        }
//	        return ptr1.data;
//		

		ListNode first = head1;
		ListNode sec = head2;

		// total len diff is if any one reached null then 2nd should again start from
		// that diff from head

		while (first != sec) {
			first = first.next;
			sec = sec.next;
			if (first == sec)
				return first.val;
			if (first == null)
				first = head1;
			if (sec == null)
				sec = head2;
			

		}

		return val;
	}
}
