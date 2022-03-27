package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class RotateArray {
	public static void main(String[] args) throws java.lang.Exception {
		// https://leetcode.com/problems/rotate-array/

		FastScanner fs = new FastScanner();

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate(arr, 4);
		arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate2(arr, 4);// check faster execution
		print(arr);

		arr = new int[] { -1, -100, 3, 99 };
		rotate(arr, 3);
		print(arr);
	}

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();

	}

	public static int[] rotate(int[] nums, int k) {
		// if k= nums.length same array ll be answer
		k = k % nums.length;
		if (k == 0)
			return nums;

		// 1 2 3 4----- 5 6 7 k=3
		// 5 6 7-----1 2 3 4
		// so 5 and 4 should swap this can only be achieve by
		// reverse 5 6 7-->7 6 5
		// reverse 1234-->4 3 2 1
		// 4 3 2 1----- 7 6 5
		// swap each elemnt
		// 5 3 2 1----- 7 6 4
		// 5 6 2 1----- 7 3 4
		// 5 6 7 1----- 2 3 4 this is our answer

		// 7-3=4 (index)
		int n = (nums.length - k) + k / 2;
		int s = nums.length - 1;
		int nm = nums.length - 1;
		for (int i = nums.length - k; i < n; i++) {
			int ind = nm--;
			int t = nums[ind];// nums[i];
			nums[ind] = nums[i];
			nums[i] = t;

		}

		// reversing till n-k element
		n = nums.length - k;
		for (int i = 0; i < n / 2; i++) {
			int t = nums[i];
			nums[i] = nums[n - 1 - i];
			nums[n - 1 - i] = t;
		}

		// swap till n/2 from starting
		n = nums.length;
		for (int i = 0; i < n / 2; i++) {
			int t = nums[i];
			nums[i] = nums[n - 1 - i];
			nums[n - 1 - i] = t;
		}

		return nums;
	}

	public static void rotate2(int[] nums, int k) {
		// in rotate func we swap after rotating
		// it means last comes first,2nd last come sec
		// if we reverse array means it already swap
		// reverse again n-k,0-k
		// ll give the answer
		k = k % nums.length;
		if (k == 0)
			return ;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private static void reverse(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {
			int t = nums[i];
			nums[i] = nums[j];
			nums[j] = t;
			i++;
			j--;
		}

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
