package cses.sortsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ModulusSum {
	public static void main(String[] args) throws java.lang.Exception {

		// https://cses.fi/problemset/task/1662/
		// 3
		// 1 1 1
//		5
//		3 1 2 7 4
//		5
//		5 5 2 3 4
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = fs.nextInt();
		}

		System.out.println(imple(arr));

		// System.out.println(implement(new int[] { 3, 1, 2, 7, 4 }));

	}

	static long imple(int[] arr) {
		// 5 5 2 3 4 n=5
		// 0: 5%5=0, got 1 subarray
		// 5 5 2 3 4
		// -------s1 from 0-3
		// ----s2 from 0-1
		// (s1-s2)%n is from 2-3 so if this is 0 we found subarray from 2-3
		// s1%n-s2%n=0=> s1=s2 so if we need to choose 2 same value
		// what is sum found at index 0 s2 is from empty--to 0 s1 is empty
		// so we need 1 extra value that is sum=0, remainder is 0 so s2-s1 means first
		// index
		// leaving ie starting from next index from s1
		// now for negative value we got negative remainder ie nc-k
		// add +n-n => nc-k+n-n= n(c-1)+n-k=>nk'+(n-k) so -k is equivalent to n-k
		// same is positive sum (+4)%5 is equivalent to (+4+5)%5
		// final point taking 2 element from freq array is freqC2 let say if got freq
		// count 1 more
		// it would be freq+1C2: before sum was sum so sum-freqC2+(freq+1)C2=>
		// sum-nC2+(n+1)C2=> sum+((n+1)c2-nC2)
		// n*n+1/2-n*n-1/2=n(n+1-n+1)/2=n=>sum+n only so sum+old freq

		int res = 0;
		long[] freq = new long[arr.length];
		freq[0] = 1; // sum 0 found
		long sum = 0;
		int n = arr.length;
		int prevSum = 0;
		for (int i : arr) {
			prevSum = ((prevSum + i) % n + n) % n;

			sum += freq[prevSum];
			freq[prevSum]++;
		}

		return sum;
	}

	static int implement(int[] arr) {

		int k = 0;
		int n = arr.length;
		int[] prefix = new int[arr.length];
		prefix[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefix[i] = (arr[i] + prefix[i - 1]) % n;
			if (prefix[i] < 0) {

				prefix[i] = (n + prefix[i]) % n;
			} else {
				prefix[i] = prefix[i] % n;
			}

		}

		int[] freq = new int[n + 1];

		for (int i : prefix) {
			freq[i]++;
		}

		int count = freq[0];
		for (int i = 1; i < freq.length; i++) {
			if (i > 1) {

				count += (i * (i - 1)) / 2;
			}
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