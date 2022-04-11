package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class LongestConsecutiveSequence {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// leetcode.com/problems/longest-consecutive-sequence/
		 
		System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
		System.out.println(longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));

	}

	public static int longestConsecutive(int[] nums) {
		boolean[] visited = new boolean[nums.length];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);

		}
		int maxcount = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {

			if (visited[i] == true)
				continue;
			if (map.containsKey(nums[i] - 1)) {
				continue;
			}
			// starting point
			count = 1;
			int num = nums[i];
			visited[i] = true;
			num++;
			while (map.containsKey(num)) {
				count++;
				visited[map.get(num)] = true;
				num++;
			} // till next sequence exists
			maxcount = Math.max(maxcount, count);
		}

		return maxcount;

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
