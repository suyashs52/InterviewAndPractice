package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SegmentTree {

	public static void main(String... strings) {
		int[] input = { 0, 3, 4, 2, 1, 6, -1 };
		SegmentTree st = new SegmentTree();
		st.createSegmentTree(input);
		int[] input1 = { -1, 2, 4, 0 };
		st.createSegmentTree(input1);

	}

	int[] createSegmentTree(int[] input) {

		int len = nextPowerof2(input.length);
		System.out.println(len);
		int[] segment = new int[len * 2 - 1];

		for (int i = 0; i < segment.length; i++) {
			segment[i] = Integer.MAX_VALUE;
		}
		constructMinSegmentTree(segment, input, 0, input.length - 1, 0);
		for (int i : segment) {
			System.out.print(i + ",");
		}
		return segment;

	}

	void constructMinSegmentTree(int[] segment, int[] input, int start, int end, int pos) {
		// -1 2 4 0 segment : -1 -1 0 -1 2 4 0
		// 0 1 2 3 0 1 2 3 4 5 6
		// when 00 pos:3,11 pos:4 next pos:1 have value of pos 3,4
		// first pass 0,3 mid: 3/2=1,03 0--> 01 2*0+1=1 pos should be independent
		// 2nd pass 0 1 1,mid: 0 --> 0 0 2*1+1=3, 003 got 3 and input index 0 so put now
		// segment[3]=input[0]
		// return first pass,3rd pass 2nd line 1 1 2*1+2=4, 114 , seg[4]=input[1]
		// return first pass, seg[1] = seg(min (2*1+1,2*1+2))

		if (start == end) {
			segment[pos] = input[start];
			return;
		}
		int mid = (start + end) / 2;
		constructMinSegmentTree(segment, input, start, mid, 2 * pos + 1);
		constructMinSegmentTree(segment, input, mid + 1, end, 2 * pos + 2);
		segment[pos] = Math.min(segment[2 * pos + 1], segment[2 * pos + 2]);
	}

	static int nextPowerof2(int n) { // power of 2 and less 1 is always 0
		if ((n & (n - 1)) == 0)
			return n;
		while ((n & (n - 1)) > 0) {
			n = n & (n - 1);
		}
		return n << 1;

	}

	public int rangeMinQuery(int[] segment, int qstart, int qend, int len) {
		return rangeMinQuery(segment, 0, len - 1, qstart, qend, 0);
	}

	private int rangeMinQuery(int[] segment, int low, int high, int qstart, int qend, int pos) { // qstart ,qend given
																									// range
		if (qstart <= low && qend >= high) { // total overlap means we need to find between 2-3 and we know between 0-4
												// value
			return segment[pos];
		}

		if (low > qend || high < qstart) { // no overlap we know 2-4 , but got 5-6 / 0-1
			return Integer.MAX_VALUE; // return max so min would be next
		}

		int mid = (low + high) / 2;
		// qstart: 1 , qend: 3
		//low high -pos 03-0/01-1/00 -3 no overlap return max value/line2-11-4 (right side next) 11 is overlap as qstart is 1
		// so return segment[4]
		//line 2 for 03-- 23-2 overlap so it reutrun seg[2] 
		// final last line is min of seg[2],seg[4]
		return Math.min(rangeMinQuery(segment, low, mid, qstart, qend, pos * 2 + 1),    //qstart, qend remain const 
				rangeMinQuery(segment, mid + 1, high, qstart, qend, pos * 2 + 2));

	}
}
