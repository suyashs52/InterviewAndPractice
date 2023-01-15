package pp.m6.dp;

/* package codechef; // don't place package name! */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class LCIS {

	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		FastScanner in = new FastScanner();

		// https://leetcode.com/problems/longest-continuous-increasing-subsequence/

		System.out.println(findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));

	}

	public static int findLengthOfLCIS(int[] nums) {

		int max = 1;
		// need to find subarray

		int[] dp = new int[nums.length];
		dp[0] = 1;// as 0th has nothing greater

		for (int i = 1; i < nums.length; i++) {

			int c = 1;

			if (nums[i - 1] < nums[i]) {
				dp[i] = dp[i - 1] + 1;

			} else {
				dp[i] = 1;
			}
			max = Math.max(dp[i], max);

		}

		return max;

	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine().trim());
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