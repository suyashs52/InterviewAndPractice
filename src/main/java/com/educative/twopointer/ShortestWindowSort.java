package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestWindowSort {

	public static int sort(int[] arr) {
		// what if array length is sorted
		// what if array length is reverse sorted
		//optimization
		// if you take left index to 1,2 5,3 at 1 not at 2 when sorted list you can save one iteration
		//don't have to put left -1 
		if (arr.length <= 1)
			return 0;

		int count = 0;

		int left = 0;
///1, 2, 5, 3, 7, 10, 9, 12
		for (int i = 1; i < arr.length; i++) { /// 5,3
			if (arr[i - 1] >= arr[i]) {
				left = i - 1;
				break;
			}
		}

		 
		int right = 0;

		for (int i = arr.length - 1; i > 0; i--) { // 5,3
			if (arr[i - 1] >= arr[i]) {
				right = i;
				break;
			}
		}

		if(left==right) return 0; //array is sorted 
		if(right==arr.length-1) return arr.length; //array reverse sorted
		int minEle = Integer.MAX_VALUE;
		int maxEle = Integer.MIN_VALUE;

		for (int i = left; i <= right; i++) {
			minEle = Math.min(minEle, arr[i]);
			maxEle = Math.max(maxEle, arr[i]);
		}

		for (int i = left - 1; i > -1; i--) {
			if (arr[i] > minEle)
				left--;
		}
		for (int i = right + 1; i < arr.length; i++) {
			if (arr[i] < maxEle)
				right++;
		}
		return right - left + 1;

	}

	public static void main(String[] arg) throws InterruptedException {

		System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
		System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
		System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
		System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));

	}

}
