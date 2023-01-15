package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MagicFormulas {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://codeforces.com/contest/424/problem/C

		FastScanner fs = new FastScanner();
		int size = fs.nextInt();
		int[] arr = new int[size];
		int xordigit = 0;
		for (int i = 0; i < size; i++) {
			arr[i] = fs.nextInt();
			xordigit ^= arr[i];
		}

		// q1=p1^ (1mod1)^(1mod2)^(1mod3)....^(1modn)
		// q2=p2^(2mod1)^(2mod2)^(2mod3)....^(2modn)
		// .
		// qn=pn^(nmod1)^(nmod2).............(nmodn)
		// column wise we can is we always take 1modi to nmodi
		// so take xor for 1..n till 1..n
		// 1modi..2modi..(i-1)modi imodi (i+1)modi...2i-1modi 2imodi
		// ....kimodi..(1modi..nmodi)
		// 1modi..imodi is repeated and and last we have nmodi
		// like n=8,i=4: 12301230 xor repeated 2 times 8/4 so xor is 0
		// n=10,i=4 1230123012 10%4=2 is extra rest is repeated even time so in this
		// case prefixxor[n%i]
		// n=10, i=6 1234501234 in this case fi-1 ll repeat odd time so take 1 xor with
		// n%i too
		// fi-1 means xor of 12345 ^ f[n%i](1234) ll result in xor of 4,5 that is our
		// answer

		int[] prefix = new int[size + 1];

		for (int i = 1; i < prefix.length; i++) {
			prefix[i] = i ^ prefix[i - 1];
		}

		int ans = 0;

		for (int i = 1; i < prefix.length; i++) {
			int times = size / i;
			int remaining = size % i;

			ans ^= prefix[remaining];
			if ((times & 1) == 1) { // odd include all single time let if i=8 then xor of 12345670
				ans ^= prefix[i - 1];

			}
		}

		System.out.println(ans ^ xordigit);

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
