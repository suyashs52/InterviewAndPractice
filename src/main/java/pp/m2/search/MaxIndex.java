package pp.m2.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MaxIndex {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1
		System.out.println(maxIndexDiffUsingMinMaxL(new int[] { 34, 8, 10, 3, 2, 80, 30, 33, 1 }, 9));
		System.out.println(maxIndexDiffUsingMap(new int[] { 34, 8, 10, 3, 2, 80, 30, 33, 1 }, 9));

		System.out.println(maxIndexDiffUsingMinMaxL(new int[] { 82, 63, 44, 74, 82, 99, 82 }, 7));

	}

	static int maxIndexDiffUsingMap(int arr[], int n) {
		// add all value index in a map
		// suppose 1 is at last index that is least value no greater element is present
		// next to it
		// 2 next greater is 3 which is lesser then 2 index so good ll get next (j-i)
		// higher value
		// for 3 we know 33-2 is lesser than 33-3 same for 10 and 8 too
		// after 10 min is (10th-8th index) next max can found in 80th-8th

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// assuming no repeatative element if yes we take min value

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		Arrays.sort(arr);
		int minIndex = n;
		int max = -1;
		for (int i = 0; i < n; i++) {
			int index = map.get(arr[i]);
			if (minIndex > index) {
				minIndex = index;
			}
			max = Math.max(max, index - minIndex);
		}
		return max;
	}

	static int maxIndexDiffUsingMinMaxL(int arr[], int n) {
		// what we want arr[j]>arr[i] if j>i
		// if k<i and a[k]>a[i] don't needed if k>i then needed
		// till i minimum and from ito j greater element difference is constraint and
		// taking max of it

		int[] minleft = new int[n];
		minleft[0] = arr[0];
		for (int i = 1; i < n; i++) {
			minleft[i] = Math.min(arr[i], minleft[i - 1]);
		}
		int[] maxright = new int[n];

		maxright[n - 1] = arr[n - 1];
		for (int i = n - 2; i > -1; i--) {
			maxright[i] = Math.max(arr[i], maxright[i + 1]);
		}
		// for 34, 8, 10, 3, 2, 80, 30, 33, 1
		// minl 34 8 8 3 2 2 2 2 1
		// max 80 80 80 80 80 80 33 33 1

		int i = 0;
		int j = 0;
		int max = -1;
		while (i < n) {
			if (j < n && maxright[j] >= minleft[i]) {
				// we have max value
				max = Math.max(j - i, max);
				j++;

			} else {
				// will first move to 8 when arr[j] is 33 now find min who is lesser than max
				i++;

			}

		}
		return max;
	}

	static int maxIndexDiffUsingMin(int arr[], int n) {
		//can be done only from min left iterate from right only

		return 0;
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
