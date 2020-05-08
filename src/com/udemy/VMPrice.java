package com.udemy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class VMPrice {

	public static void code() {
		int n = 25;

		List<Integer> instances = new ArrayList<Integer>();
		instances.add(25);
		instances.add(50);
		instances.add(100);

		List<Float> price = Arrays.asList(new Float[] { 5.0f, 4.0f, 3.0f });

		instances = Arrays.asList(new Integer[] { 10, 25, 50, 100, 500 });

		price = Arrays.asList(new Float[] { 0.0f, 0.0f, 0.0f, 0.0f, 54.25f });

		System.out.println(interpolate(2, instances, price));

		instances = Arrays.asList(new Integer[] { 10, 49, 177, 364, 608, 669, 850, 966, 1025, 1160, 1259, 1399, 1500 });

		price = Arrays.asList(new Float[] { 1.48f, 5.25f, 7.19f, 11.42f, 14.88f, 17.75f, -1.0f, 46.55f, 58.77f, 60.22f,
				61.03f, -1.0f, -1.0f });

		System.out.println(interpolate(1635, instances, price));
		System.out.println(interpolate(1813, instances, price));
		
	}

	public static String interpolate(int n, List<Integer> instances, List<Float> price) {
		// Write your code here

		String result = "";
		int len = instances.size();

		if (price.size() < 2) {
			return String.format("%.2f", price.get(0));
		}

		int index = search(instances, 0, len - 1, n, 0);
		boolean valid = true;
		if (price.get(index) < 0.1 && index < len-1) {
			valid = false;
			while (index < len && price.get(index) < 0.1) {
				index++;
			}
		} else if (price.get(index) < 0.1 && index == len-1 ) {
			valid = false;
			while (index > 0 && price.get(index) < 0.1) {
				index--;
			}
		} else if (price.get(index) < 0.1) {
			valid = false;
			while (index < len && price.get(index) < 0.1) {
				index++;
			}
		}

		if (!valid)
			return String.format("%.2f", price.get(index));

		if (index < len && instances.get(index) == n) {
			return String.format("%.2f", price.get(index));

		} else if (index == len) {
			// value largest
			double m = (price.get(index - 1) - price.get(index - 2))
					/ (instances.get(index - 1) - instances.get(index - 2));
			m = m * (n - instances.get(index - 1));
			m += price.get(index - 1);
			return String.format("%.2f", m);
		} else if (index == 0) {
			double m = (price.get(1) - price.get(0)) / (instances.get(1) - instances.get(0));
			m = m * (n - instances.get(0));
			m += price.get(0);
			return String.format("%.2f", m);
		} else {
			double m = (price.get(index) - price.get(index - 1)) / (instances.get(index) - instances.get(index - 1));
			m = m * (n - instances.get(index - 1));
			m += price.get(index - 1);
			return String.format("%.2f", m);

		}

	}

	public static int search(List<Integer> arr, int l, int r, int key, int ind) {
		if (r >= l) {
			int mid = l + (r - 1) / 2;
			if (mid > arr.size() - 1)
				return ind;
			if (arr.get(mid) == key)
				return mid;
			if (arr.get(mid) > key) {
				ind = l;
				return search(arr, l, mid - 1, key, ind);
			} else {
				ind = mid + 1;
				return search(arr, mid + 1, r, key, ind);
			}
		}

		return ind;
	}

	public static void main(String... args) throws IOException {

		code();

		// bufferedReader.close();
	}
}
