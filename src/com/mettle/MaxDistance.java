package com.mettle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MaxDistance {
	public static void code() {
		findMaxNumber("123456", 2);
		findMaxNumber("112456", 1);
		findMaxNumber("11123", 1);
		findMaxNumber("11123", 2);
		int[][] arr = { { 1, 0 }, { -1, 0 }, { -2, 1 }, { 13, 2 } };

		double maxDistance = -1.0;
		int f = -1;
		int s = -1;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				double dis = Math
						.sqrt((Math.pow((arr[i][0] - arr[j][0]), 2.0) + Math.pow((arr[i][1] - arr[j][1]), 2.0)));
				System.out.println(dis);
				if (dis > maxDistance) {
					maxDistance = dis;
					f = i;
					s = j;
				}

			}
		}

		System.out.println("i,j)-" + f + "," + s);

		System.out.println(maxDistance);

		System.out.println(BigDecimal.valueOf(maxDistance).setScale(6, RoundingMode.HALF_UP).doubleValue());

	}

	static void findMaxNumber(String str, int swap) {

		if (swap == 0)
			return;
		String maxValue = "";
		for (int i = 0; i < str.length(); i++) {
			int index = 0;
			int max = Integer.MIN_VALUE;

			int limit = (swap + i) > str.length() ? str.length() : swap + i;

			for (int j = i; j <= limit; j++) {
				if ((str.charAt(j) - '0') > (max)) {
					max = str.charAt(j) - '0';
					index = j;
				}
			}
			swap -= (index - i);

			for (int k = index; k > i; k--) {
				StringBuilder sb = new StringBuilder(str);
				sb.setCharAt(k - 1, str.charAt(k));
				sb.setCharAt(k, str.charAt(k - 1));
				str = sb.toString();
				if (str.compareTo(maxValue) > 0) {
					maxValue = str;

				}
			}
			if (swap == 0) {
				break;
			}

		}

		System.out.println(maxValue);

	}

}
