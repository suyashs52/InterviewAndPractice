package pp.m4.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SubArraySumEqualsK {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/subarray-sum-equals-k/
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySumLeet(new int[] { 1, 1, 1 }, 2));

		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
		System.out.println(subarraySumLeet(new int[] { 1, 2, 3 }, 3));

		System.out.println("-----");
		System.out.println(subarraySum(new int[] { 1, -1, 0, 0 }, 0));
		System.out.println(subarraySumLeet(new int[] { 1, -1, 0, 0 }, 0));
		System.out.println("-----");
		System.out.println(subarraySum(new int[] { 0, 0 }, 0));
		System.out.println(subarraySumLeet(new int[] { 0, 0 }, 0));

		System.out.println(subarraySum(new int[] { 1, 1, 1, 0, 0 }, 2));
		System.out.println(subarraySumLeet(new int[] { 1, 1, 1, 0, 0 }, 2));

	}

	public static int subarraySum(int[] nums, int k) {
		 Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum=0;
		 
		int count = 0;
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum+= nums[i];

			if (map.containsKey(sum - k)) {
				int c = map.get(sum - k);
				// count = count - (c * (c - 1) / 2)+((c+1)*c/2); //+n+1c2-nc2=n
//				if (prefix[i] == k) {
//					count++; // from index =0 it ll repeat only once as next time value is in
//								// map.containsKey(prefix[i] - k)
//				}
				count += c;
				c++;
				//modifying the index
				map.put(sum , map.getOrDefault(sum, 0)+1);
				

			}

			else if (map.containsKey(sum) == false) {
				map.put(sum, 1);
//				if (prefix[i] == k) {
//					count++; // from index =0 it ll repeat only once as next time value is in
//								// map.containsKey(prefix[i] - k)
//				}
			}
			
		
		}

		return count;

	}

	public static int subarraySumLeet(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
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
