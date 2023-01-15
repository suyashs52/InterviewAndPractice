package com.educative.fastslowpointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromicLinkedList {

	public static boolean isPalindrome(ListNode head) {

		boolean ispalin = false;

		if (head == null)
			return true;
		if (head.next == null)
			return true;

		ListNode first = head;
		ListNode sec = head;

		while (sec != null && sec.next != null) {
			first = first.next;
			sec = sec.next.next;
		}

		ListNode mid = first;

		// reversing the list from mid
		ListNode node = mid.next;
		ListNode prev = null;
		ListNode curr = node;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		mid.next=prev;
		ListNode secondHalf = prev;

		first = head;
		while (first != null && secondHalf != null) {
			if (first.value != secondHalf.value) {
				ispalin = false;
				break;
			}
			first = first.next;
			secondHalf = secondHalf.next;
		}

		if (first == mid && secondHalf == null)
			ispalin = true;
		else
			ispalin = false;

		// reversing the list from mid
		node = mid.next;
		prev = null;
		curr = node;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		mid.next=prev;

		return ispalin;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
	}

}
