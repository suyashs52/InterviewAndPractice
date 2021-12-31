package pp.gu.math;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/* Name of the class has to be "Main" only if the class is public. */
public class CountingPrimes {
	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		// Count the number of prime numbers less than or equal to N
		int maxno=1000000;
		int[] prime = new int[maxno];
		int[] cou = new int[maxno];
		int pkey = 0;
		boolean[] bprime = new boolean[maxno];
		int num = (int) Math.sqrt(maxno);
		for (int i = 2; i <= num; i++) {
			if(i==317) {
				System.out.println("test");
			}
			if (bprime[i] == false) {
				for (int j = i; i * j < maxno; j++) {
					
					bprime[i * j] = true;
				}
			}

		}
		// 499979 -- 41537
		for (int i = 2; i < maxno; i++) {
			 
			if (!bprime[i]) {
				pkey = pkey + 1;
				cou[i] = pkey;
			} else {
				cou[i] = pkey;
			}
		}
		 


		System.out.println(cou[499978]);
		CountPrimes(499978);
		
		System.out.println(cou[499979]);
		CountPrimes(499979);

//		for (int i = 0; i < t; i++) {
//			int l = in.nextInt();
//			System.out.println(cou[l]);
//			CountPrimes(l);
//
//		}

	}

	public static void CountPrimes(int n) {

		if (n == 0) {

			System.out.println(0);

		} else {

			int[] primes = new int[n + 1];

			for (int i = 0; i < primes.length; i++) {

				primes[i] = 1;

			}

			primes[1] = 0;

			for (int i = 2; i <= Math.sqrt(n); i++) {

				if (primes[i] == 1) {

					for (int j = i; i * j < n; j++) {

						primes[i * j] = 0;

					}

				}

			}

			int k = 1;
			int count = 0;

			while (k < primes.length - 1) {

				if (primes[k] == 1) {

					count++;

				}

				k++;

			}

			System.out.println(count);

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