package com.educative.kwaymerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
	int value;
	ListNode next;

	ListNode(int value) {
		this.value = value;
	}
}

public class MergeKSortedLists {

	public static ListNode merge(ListNode[] lists) {
		ListNode result = null;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.value - n2.value);

		for (ListNode l : lists) {
			if (l != null)
				minHeap.add(l);
		}
		ListNode prev = null;
		while (minHeap.isEmpty() == false) {
			ListNode node = minHeap.poll();
			if (result == null && prev == null) {
				result = node;
				prev = node;
			} else if (node != null) {
				prev.next = node; // 1 7 --1.next =7, l=7ie l=l.next
				prev = prev.next;
			}

			if (prev.next != null) {
				minHeap.add(prev.next);
			}

		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(6);
		l1.next.next = new ListNode(8);

		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);

		ListNode l3 = new ListNode(1);
		l3.next = new ListNode(3);
		l3.next.next = new ListNode(4);

		ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
		System.out.print("Here are the elements form the merged list: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
