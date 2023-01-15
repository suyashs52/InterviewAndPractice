package com.educative.kwaymerge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

class Element {
	int key;
	int index;

	Element(int key, int index) {
		this.key = key;
		this.index = index;
	}
}

public class SmallestRange {

	public static int[] findSmallestRange(List<Integer[]> lists) {
		int[] range = new int[2];

		PriorityQueue<Element> min = new PriorityQueue<Element>(
				(n1, n2) -> lists.get(n1.key)[n1.index] - lists.get(n2.key)[n2.index]);

		int max = -1;
		for (int i = 0; i < lists.size(); i++) {
			min.add(new Element(i, 0));
			max = Math.max(max, lists.get(i)[0]);
		}

		int diff = 1000;
		int end=-1;
		int start=-1;
		while (min.size() == lists.size()) { // needed at least element for each array, if not got the value
			Element ele = min.poll(); // take the min
			if (max - lists.get(ele.key)[ele.index] < diff) {
				diff = max - lists.get(ele.key)[ele.index];
				start = lists.get(ele.key)[ele.index];
				end =max;
			}
			ele.index++;
			// put next of min value in heap
			if (lists.get(ele.key).length > ele.index) {
				 
				max = Math.max(max, lists.get(ele.key)[ele.index]);
				min.add(new Element(ele.key, ele.index));
			}

		}

		return new int[] { start, end };
	}

	public static void main(String[] args) {
		Integer[] l1 = new Integer[] { 1, 5, 8 };
		Integer[] l2 = new Integer[] { 4, 12 };
		Integer[] l3 = new Integer[] { 7, 8, 10 };
		List<Integer[]> lists = new ArrayList<Integer[]>();
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		int[] result = SmallestRange.findSmallestRange(lists);
		System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
	}

}
