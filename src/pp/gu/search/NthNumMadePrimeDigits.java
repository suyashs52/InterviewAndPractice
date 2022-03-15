package pp.gu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthNumMadePrimeDigits {
	public static void main(String... strings) {
		// https://www.geeksforgeeks.org/finding-n-th-number-made-prime-digits/
		int[] D = { 2, 3, 5 };
		int n = 7;

		System.out.println(solve(D, n));
		System.out.println(solve(D, 50));

	}

	static int solve(int[] a, int n) {
		int diff = Integer.MAX_VALUE;

		// as there are 3 number so
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int count = 0;
		int[] arr = new int[n];
		arr[0] = 1; // as 2^0+3^0+5^0=1

		int i = 0;
		int k1 = 0;
		int k2 = 0;
		int k3 = 0;
		int min = Integer.MAX_VALUE;
		while (i < n) {
			k1 = arr[i1] * a[0];
			k2 = arr[i2] * a[1];
			k3 = arr[i3] * a[2];

			min = Math.min(k1, Math.min(k2, k3)); // next ith natural number;
			// let say arr is [1,2,3,4,5....] first 5 natural number
			// k1=2,k2=1,k3=1-->2*arr[2]=3, 3*2=6,
			// and arr[k2] is 2, 2*3=6 both has same value so increment k1 and k2 both to
			// avoid duplicate
			// or increment any one and compare with last value if equal only increment:
			// next value would be
			// 2*4:8,3*3:9,5*2:10--min is 8
			if (min == k1) {
				i1++;
			}
			if (min == k2) {
				i2++;
			}
			if (min == k3) {
				i3++;
			}
			i++;
			if (i < n)
				arr[i] = min;

		}
		return arr[n - 1];
	}

}
