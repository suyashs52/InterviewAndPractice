package com.educative.twopointer;

import java.util.ArrayList;
import java.util.List;

public class TripletSumToZero {

	public static Integer[] makeSquares(Integer[] arr) {
		Integer[] next = new Integer[arr.length];
		if (arr.length == 0)
			return next;
		int start = 0;
		int end = arr.length - 1;
		int count = end;
		while (start <= end) {
			int s = arr[start] * arr[start];
			int e = arr[end] * arr[end];

			if (s >= e) {
				next[count--] = s;
				start++;
			} else {
				next[count--
				     ] = e;
				end--;
			}
		}

		return next;

	}

	public static void main(String[] arg) throws InterruptedException {
		List<Integer> a=new ArrayList<>();
		a.add(1, 10);
		String s2="";
		s2.wait();
		 

		System.out.println(TripletSumToZero.makeSquares(new Integer[] { -2, -1, 0, 2, 3 }));
		System.out.println(TripletSumToZero.makeSquares(new Integer[] { -3, -1, 0, 1, 2 }));

	}

}
