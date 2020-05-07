package com.udemy;

import java.io.IOException;

class VMPrice {

	public static void code() {
		int n = 25;
		int[] instances = new int[] { 25, 50, 100 };
		double[] price = new double[] { 5.0, 4.0, 3.0 };
		System.out.println(selectVm(150, instances, price));
		System.out.println(selectVm(75, instances, price));
		System.out.println(selectVm(10, instances, price));
 
		n = 25;
		instances = new int[] { 10, 25, 50, 100, 500 };
		price = new double[] { 2.46, 2.58, 2.0, 2.25, 3.0 };
		System.out.println(selectVm(25, instances, price));

	}

	public static String selectVm(int n, int[] instances, double[] price) {
		String result = "";
		int len = instances.length;

		int index = search(instances, 0, len - 1, n, 0);

		if (index < len && instances[index] == n) {
			return price[index] + "";
		} else if (index == len) {
			// value largest
			double m = (price[len - 1] - price[len - 2]) / (instances[len - 1] - instances[len - 2]);
			m = m * (n - instances[len - 1]);
			m += price[len - 1];
			return String.format("%.2f", m);
		} else if (index == 0) {
			double m = (price[1] - price[0]) / (instances[1] - instances[0]);
			m = m * (n - instances[0]);
			m += price[0];
			return String.format("%.2f", m);
		} else {
			double m = (price[index] - price[index - 1]) / (instances[index] - instances[index - 1]);
			m = m * (n - instances[index - 1]);
			m += price[index - 1];
			return String.format("%.2f", m);

		}
		 
		 
	}

	public static int search(int[] arr, int l, int r, int key, int ind) {
		if (r >= l) {
			int mid = l + (r - 1) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key) {
				ind = l;
				return search(arr, l, mid - 1, key, ind);
			} else {
				ind = mid + 1;
				return search(arr, mid + 1, r, key, ind);
			}
		}

		return ind;
	}

	public static void main(String[] args) throws IOException {

		code();

		// bufferedReader.close();
	}
}
