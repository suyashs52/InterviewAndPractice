package pp.m2.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SingleNumber2 {
	FastScanner fs = new FastScanner();

	public static void main(String... strings) {

		// https://leetcode.com/problems/single-number-ii/
		System.out.println(singleNumber(new int[] { 2, 2, 3, 2 }));
		System.out.println(singleNumber(new int[] { 30000, 500, 100, 30000, 100, 30000, 100 }));
		System.out.println(singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
		// using hashset
		// 3×(a+b+c)−(a+a+a+b+b+b+c)=2c
		// hashmap count of 1
		//
		// 2nd method tricky
		//
		singleNumberImp(new int[] { 1, 2, 1 });
	}

	public static int singleNumber(int[] nums) {

		int sum = 0;
		// if a bit comes odd number of tims adding 1 (up bit of single time number)
		// will make it even and if 1 is even it contribute
		// the answer
		//  mask ll add into sum

		long mask = (long) 1 << 31;

		while (mask > 0) {
			int count = 0;
			for (int i : nums) {
				if ((i & mask) == mask) {
					count++;
				}

			}
			if (count % 3 == 0) { // multiple of 3 so don't do

			} else {
				sum += mask;
			}
			mask >>= 1;
		}

		return sum;

	}

	public static int singleNumberImp(int[] nums) {
		int seenOnce = 0, seenTwice = 0;

		for (int num : nums) {
			// first appearence:
			// add num to seen_once
			// don't add to seen_twice because of presence in seen_once

			// second appearance:
			// remove num from seen_once
			// add num to seen_twice

			// third appearance:
			// don't add to seen_once because of presence in seen_twice
			// remove num from seen_twice
			seenOnce = ~seenTwice & (seenOnce ^ num);
			seenTwice = ~seenOnce & (seenTwice ^ num);

			// lets select x=2
			// 00010
			// first has xor: 0010^0000: 0010
			// 2nd ll have 0
			// let next time again 2 come first ll have 0 and 2nd have first
			// first: first^x: 0000, sec: sec^x:0010
			// now 3rd time if x come first should be 0 and 2nd should be 0
			// we have mess
			// now think
			// how can first be x when included with x
			// f^x s:0 if we take ~s:111 , f^x & ~s = f^x=x
			// in next statement s=x, f^x^x=0 so first take s so s=0 ~s:1111 f^x^x:000
			// exp:000
			// in 3rd when s:x (2) f^x^x^x:x,~s ie ~x&x=0
			// so we see in last 2 f is always 0 so we are right
			// f= ~s&(f^x)
			// 2nd first time should be 0; we have f=x,~f=~x and s^x=x ~x&x:0 :: ~f&(s^x):0
			// in next f=0, s^x:x ~f&(s^x)=x as
			// little trickty but possible
		}

		return seenOnce;
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
