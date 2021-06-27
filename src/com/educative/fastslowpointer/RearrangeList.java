package com.educative.fastslowpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeList {

	public static void reorder(ListNode head) {
		// 2 4 6 8 10 12

		// find mid
		ListNode first = head;
		ListNode last = head;

		while (last != null && last.next != null) {
			first = first.next;
			last = last.next.next;
		}

		ListNode mid = first;
		// reverse a list from mid
		ListNode next = mid.next;
		ListNode prev = null;
		ListNode curr = next;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		mid.next = prev;

		// reordering
		ListNode sec = mid.next;
		first=head;
		while (sec != null) { // 2 4 6 8, 12 10 
//			ListNode temp=first.next;
//			ListNode temp1=sec.next;
//			first.next=sec;
//			sec.next=temp;
//			first=temp;
//			sec=temp1;
			
			
			
			ListNode temp=first.next;
			first.next=sec;
			first=temp;
			//since first has temp value
			temp=sec.next;
			sec.next=first;
			sec=temp;
			
		}
		
		mid.next=null; //check here for mid having odd index
		 

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		RearrangeList.reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

}
