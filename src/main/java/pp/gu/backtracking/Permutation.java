package pp.gu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Permutation {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/permutations/
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(permute(nums));

	}

	public static List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		allnum(nums, list, 0);
		return list;

	}

	private static void allnum(int[] nums, List<List<Integer>> list, int i) {
//N x N!
		if (i == nums.length) {
			List<Integer> l = new ArrayList<>();
			for (int j : nums) //order of N
				l.add(j);
			list.add(l);
		}
		//	abc
		//a__	b__	c__   if fix 1st position remaiing can be filled either b,c from a__F
		for (int j = i; j < nums.length; j++) {
			swap(nums, i, j); 
			allnum(nums, list, i + 1);
			swap(nums, j, i);
		}

	}

	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int t = nums[j];
		nums[j] = nums[i];
		nums[i] = t;

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