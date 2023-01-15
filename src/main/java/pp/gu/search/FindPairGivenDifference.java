package pp.gu.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairGivenDifference {
	public static void main(String... strings) {
		// https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1

		int[] arr = new int[] { 5, 20, 3, 2, 5, 80 };
		int N = 6;
		int X = 78;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));
		arr = new int[] { 5, 20, 3, 2, 5, 80 };
		N = 6;
		X = 0;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));
		arr = new int[] { 90, 70, 20, 80, 50 };
		N = 5;
		X = 15;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));
		arr = new int[] { 1, 2, 6, 3, 4 };
		N = 5;
		X = 0;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));

	}

	static int hasArrayTwoCandidates(int arr[], int n, int x) {
		// x-y=z so min can be 0 , if after sorting take largest difference no value
		// take first 2 difference is diff is < x j++ if diff>x i++ so more value
		// difference would be less

		Arrays.sort(arr);
		int i = 0;
		int j = i + 1;
		if (arr.length == 1)
			return -1;
		x = Math.abs(x);
		// https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
		// positive difference shifting same as negative difference
		// if i,j+1 has lesser negative ie greater value increase i,
		while (j < arr.length) {

			if (arr[j] - arr[i] == x)
				return 1;
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

		return -1;

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
