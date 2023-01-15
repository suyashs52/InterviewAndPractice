package com.educative.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ReplacingOnes {
	public static int findLength(int[] arr, int k) {
		int len = 0;

		int one = 0;
		int start = 0;
		int maxOne = 0;
		//get max 1 until condition not failed
		//if got max then shift window 
		//if got 0 more than limit shift window
		//we can replace k 0 only otherwise shift
		for (int end = 0; end < arr.length; end++) {
			if (arr[end] == 1) {
				one++;
				maxOne = Math.max(one, maxOne);
			}  

			if (end - start + 1 - maxOne > k) {
				// shift //in between 1 is loss so remove 1
				if (arr[start] == 1) {
					one--;
				
				}
				start++;
			}
			len = Math.max(len, end - start + 1);
		}
		return len;
	}

	public static void main(String[] args) {
		TreeMap<String,String> map=new TreeMap<String,String>();
		map.put("test",null);
		
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
		System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

	}

}
