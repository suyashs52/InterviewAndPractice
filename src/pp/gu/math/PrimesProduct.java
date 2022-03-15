package pp.gu.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class PrimesProduct {
	public static void main(String[] args) throws java.lang.Exception {

//		Given two numbers L and R  (inclusive) find the product of primes within this range. Print the product modulo 
//		10^9+7. If there are no primes in that range you must print 1.
//		1 		≤  T ≤ 10
//		1 ≤ L ≤ R ≤ 10 9
//		0 ≤ R − L ≤ 10 6

//		2
//		1 10
//		2 20
//		
//		210
//		9699690

		// as range is 10^6 so calucalte primes in between
		int n = 1000001;
		boolean[] isprimef = new boolean[n]; // store 0 to 10^6
		isprimef[1] = true;
		isprimef[2] = false; // false means prime
		int countPrime = 0;
		List<Integer> prime = new ArrayList<>();
		for (int i = 2; i < 1001; i++) {// sqrt of 10^6 is 1000
			if (!isprimef[i]) {
				prime.add(i);
				countPrime++;
				for (int j = 1; j * i < n; j++) // multiplication is not prime
					isprimef[j * i] = true;
			}

		}
		for (int i = 1001; i < n; i++) {
			if (!isprimef[i]) {
				prime.add(i);
			}
		}

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		for (int i = 0; i < t; i++) {
			int f = fs.nextInt();
			int l = fs.nextInt() + 1;

			int offset = f;
			boolean[] range = new boolean[l - f]; // 1000-2000 means 1000 store at 0
			int p = 0;
			int j = prime.get(p++);

			while (j * j < l) { // for 90-100 range j value at max 10
				int ceil = (int) Math.ceil(f * 1.0 / j); // for 91 and j=2: ceil=46 we should start from 92
				if (ceil < 2)
					ceil = 2;

				for (int k = ceil; j * k < l; k++) { // 91,92,93-100 k:46,j:2 range[92-91]=range[1]=true;not a prime

					range[j * k - f] = true;
				}
				j = prime.get(p++);
			}
			long ans = 1;
			int mod = (int) Math.pow(10, 9) + 7;
			for (int k = 0; k < range.length; k++) {
				if (!range[k]) { // prime
					ans = ((k + f) * ans) % mod;
				}
			}

			System.out.println(ans);

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