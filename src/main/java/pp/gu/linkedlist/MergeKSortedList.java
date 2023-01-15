package pp.gu.linkedlist;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MergeKSortedList {

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

	}

	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	static ListNode merge(ListNode[] lists, int start, int last) {

		if (start < last) {
			int mid = start + (last - start) / 2;

			// 0-2 -> 01,22->00 11,22 if we do start and mid
			// 0-2 -> 00,12->00,10 12,10 12-->every time mid is 1 so start:1 mid-1:0,and
			// mid=1 and end is 2 wrong
			// now 0-3-> 00,13->00,11,23, again loop infinite
			
			ListNode list1 = merge(lists, start, mid); // mid - 1 if do ll run in infinte loop if 0 ,len-1
			ListNode list2 = merge(lists, mid + 1, last);
			return merge(list1, list2);
		} else if (start == last) {
			return lists[start];
		}

		return null;
	}

	private static ListNode merge(ListNode list1, ListNode list2) {
		// TODO Auto-generated method stub
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;

		ListNode result = null;

		if (list1.val < list2.val) {
			result = list1;
			result.next = merge(list1.next, list2);
		} else {
			result = list2;
			result.next = merge(list1, list2.next);
		}

		return result;
	}

}
