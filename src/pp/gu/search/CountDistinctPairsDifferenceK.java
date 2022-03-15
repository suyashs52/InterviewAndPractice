package pp.gu.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctPairsDifferenceK {
	public static void main(String... strings) {
		// https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1
//https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
		int[] arr = new int[] { 1, 5, 4, 1, 2 };
		int N = 6;
		int X = 0;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));
		arr = new int[] { 1, 5, 5, 3, 4, 2 };
		N = 3;
		X = 2;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));

	}

	static int hasArrayTwoCandidates(int arr[], int n1, int x) {

		Arrays.sort(arr);
		int i = 0;
		int j = i + 1;
		if (arr.length == 1)
			return 0;
		x = Math.abs(x);
		int count = 0;
		while (j < arr.length) {

			if (arr[j] - arr[i] == x) {
				if (arr[i] == arr[j]) {
					int n = (j - i + 1);
					count = (n * (n - 1)) / 2;
					return count;
				} else {
					count++; // distinct count
					int temp = arr[i];
					while (i < arr.length && arr[i] == temp) {
						i++;
					}
					temp = arr[j];
					while (j < arr.length && arr[j] == temp) {
						j++;
					}
					if (j == i) {
						j++;
					}
				}
			}

			else if (arr[j] - arr[i] < x) {
				j++;
			} else {
				if (j == i + 1) {
					i++;
					j++;
				} else {
					i++;
				}
			}

		}

		return count;

	}

	static boolean hasArrayTwoCandidatesByMap(int arr[], int n, int x) {
		boolean has = false; /// 4 4 4 4 5 5 sum: 9, 9-4:5 no value so put 4,1-4,2-4,3-4,4,now 5 so
		// x-y=z check : z+y if yes the found
		Map<Integer, Integer> map = new HashMap<>();

		for (int j : arr) {

			map.put(j, map.getOrDefault(j, 0) + 1);

		}
		boolean found = false;
		for (int j : arr) {
			int check = j + x;
			if (map.containsKey(check)) {
				if (check == j) { // handingl diff is 0 then
					found = map.get(check) > 1;
					if (found)
						break;
				} else
					return true;
			}

		}
		return found;

	}

}
