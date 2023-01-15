package com.educative.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumCloseToTarget {

	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();

		if (arr.length < 3)
			return triplets;
		Arrays.sort(arr);
		// -3,-2,-1,0,1, 1,2,3, 8
		for (int i = 0; i < arr.length - 2; i++) { // need to find triplet
			int a = arr[i];
 
			int start = i + 1;
			int end = arr.length - 1;

			while (start <= end) {
				if (arr[start] + arr[end] == -a) { // if found
					triplets.add(Arrays.asList(a, arr[start], arr[end]));
					start++;
					end--;
					while (start< end && arr[start] == arr[start - 1]) // duplicate records
						start++;
					while (start< end && arr[end + 1] == arr[end])
						end--;
				}

				if (arr[start] + arr[end] + a > 0)
					end--;// need positive number
				else
					start++; // need positive

			}

		}

		return triplets;

	}

	public static void main(String[] arg) throws InterruptedException {

		System.out.println(TripletSumCloseToTarget.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
		System.out.println(TripletSumCloseToTarget.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));

	}

}
