package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import pp.gu.search.KthSmallest.FastScanner;

/* Name of the class has to be "Main" only if the class is public. */
public class MaxConsecutiveOnes {
	public static void main(String[] args) throws java.lang.Exception {

		// https://leetcode.com/problems/max-consecutive-ones-iii/
		System.out.println(longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
		System.out.println(longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
		System.out.println(longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 0));

	}

	public static int longestOnes(int[] nums, int k) {
		int i = 0;

		int co = 0;
		int cone = 0;
		int f = 0;
		int l = 0;

		while (l < nums.length) {
			if (nums[l] == 1) { // if nums is 1

				cone++;
			} else {
				co++;
				if (co > k) {
					while (co > k) {
						if (nums[f] == 0) {
							co--;
							
						}
						f++;
					}
				}
			}
			i = Math.max(i, l - f + 1);
			l++;
		}

		return i;
	}
}