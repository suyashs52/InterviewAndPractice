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

public class SonyaQueries {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://codeforces.com/problemset/problem/713/A
		FastScanner fs = new FastScanner();

		int t = fs.nextInt();

		int[] number = new int[10];
		// odd digit should be 1 as question said
		for (int i = 1; i < 10; i += 2) {
			number[i] = 1;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		for (int i = 0; i < t; i++) {
			String s = fs.next();
			String n;
			int num;
			switch (s) {
			case "+":
				n = fs.next();
				num = numberInt(n, number); // convert to decimal number after converting to 0101010 trailing is
				// always represent as 0 so no use
				map.put(num, map.getOrDefault(num, 0) + 1);

				break;

			case "-":
				n = fs.next();
				num = numberInt(n, number);
				map.put(num, map.getOrDefault(num, 0) - 1);
				break;

			case "?":
				n = fs.next();
				int k = 0;
				num = 0;
				// Convert binary to decimal, 000 is of no use
				for (int j = n.length() - 1; j > -1; j--) {
					if (n.charAt(j) == '1') {
						num += (1 << k);
					}
					k++;
				}
				Integer res = map.get(num);
				if (res == null)
					res = 0;
				System.out.println(res);
				break;

			}

		}

	}

	static int numberInt(String n, int[] number) {

		int[] backdigit = new int[n.length()];
		int k = 0;
		int num = 0;
		for (int j = n.length() - 1; j > -1; j--) {
			backdigit[k] = number[n.charAt(j) - '0'];
			if (backdigit[k] == 1) {
				num += 1 << k;
			}
			k++;
		}
		return num;
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
