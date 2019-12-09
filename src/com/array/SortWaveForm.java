package com.array;

public class SortWaveForm {
	public static void code() {
		int[] arr = { 10, 5, 6, 3, 2, 20, 100, 80 };
		sortWave(arr);
		print(arr);

	}

	static void sortWave(int[] a) {
		for (int i = 0; i < a.length; i += 2) {
			// boolean isEven = !((i & 1) == 1);
			if (i + 1 < a.length && a[i] < a[i + 1]) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
			if (i > 0 && a[i - 1] > a[i]) {
				int temp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = temp;
			}
		}
	}

	static void print(int[] a) {
		for (int i : a) {
			System.out.print(i+",");

		}
		System.out.println();
	}
}
