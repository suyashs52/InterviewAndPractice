package pp.gu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PermutationsDuplicate {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/permutations-ii/

//		FastScanner fs = new FastScanner();
//		int t = fs.nextInt();
//		int[] arr = new int[t];
//		for (int i = 0; i < t; i++) {
//			arr[i] = fs.nextInt();
//		}

		System.out.println(permuteUnique(new int[] {0,1,0,0,9}));

	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		permute(nums, 0, nums.length, list);
		return list;
	}

	private static void permute(int[] nums, int i, int n, List<List<Integer>> list) {
		// TODO Auto-generated method stub
		if (i == n) {
			List<Integer> l = new ArrayList<Integer>();
			for (int j : nums) {
				l.add(j);

			}

			list.add(l);
			return;
		}

		int[] dup = new int[22]; // total 21 count -10 to +10
		//
		// 112 so don't swap 1 to 1,
		// 1122 don't take 2 twice as first 2 ll give the same result
		for (int j = i; j < n; j++) {
			if (dup[nums[j] + 10] > 0)
				continue;
			dup[nums[j] + 10] = 1;

			swap(nums, i, j);
			permute(nums, i + 1, n, list);
			swap(nums, j, i);

		}

	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;

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