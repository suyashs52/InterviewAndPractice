package com.educative.heap;

import java.util.PriorityQueue;
import java.util.Queue;

class Interval {
	int start = 0;
	int end = 0;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class NextInterval {
	MinHeap minHeap = new MinHeap();
	MaxHeap maxHeap = new MaxHeap();

	public static int[] findNextInterval(Interval[] intervals) {
		int[] result = new int[intervals.length];
		// [2,3], [3,4], [5,6]
		// 6 4 3 , 5 3 2
		// sort index
		int n = intervals.length;

		Queue<Integer> start = new PriorityQueue<>((i1, i2) -> intervals[i2].start - intervals[i1].start);
		Queue<Integer> end = new PriorityQueue<>((i1, i2) -> intervals[i2].end - intervals[i1].end);

		for (int i = 0; i < intervals.length; i++) {

			start.offer(i);
			end.offer(i);
		}

		for (int i = 0; i < intervals.length; i++) {
			int j = end.poll();

			if (!start.isEmpty() && intervals[start.peek()].start < intervals[j].end) {
				result[j] = -1;

			} else if (!start.isEmpty()) {
				int ind = -1;
				while (!start.isEmpty() && intervals[start.peek()].start >= intervals[j].end) {
					ind = start.poll();
					// 5 3 2 ,, 6 4 3
					// 2 1 0 ,, -1 2 1
				}
				result[j] = ind;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
		int[] result = NextInterval.findNextInterval(intervals);
		System.out.print("Next interval indices are: ");
		for (int index : result)
			System.out.print(index + " ");
		System.out.println();

		intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
		result = NextInterval.findNextInterval(intervals);
		System.out.print("Next interval indices are: ");
		for (int index : result)
			System.out.print(index + " ");
	}

}
