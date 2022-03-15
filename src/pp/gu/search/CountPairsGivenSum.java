package pp.gu.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairsGivenSum {
	public static void main(String... strings) {
		// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#
		int[] arr = new int[] { 1, 5, 7, 1 };
		int N = 4;
		int X = 6;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));
		arr = new int[] { 1, 1, 1, 1 };
		N = 4;
		X = 2;
		System.out.println(hasArrayTwoCandidates(arr, N, X));
		System.out.println(hasArrayTwoCandidatesByMap(arr, N, X));

	}

	static int hasArrayTwoCandidates(int arr[], int n, int x) {
		boolean has = false;

		// brute force --for loop 1: i-n 2nd:i+1-n a[i]+a[j] =x n^2
		// binarry search: a[i] element , next element would be x-a[i], search it from
		// i+1-n nlogn
		// two pointer
		// since array is not sorted 2pointer or binary search ll apply only on sorted
		// so sort it first
		Arrays.sort(arr);
		int count = 0;
		int i = 0;
		int j = arr.length - 1;

		while (i < j) { // O(n)
			int sum = arr[i] + arr[j];
			if (sum == x) {
				if (arr[i] == arr[j]) {
					int num = j - i + 1;
					count += (num * (num - 1)) / 2; // nC2

					break;
				} else {
					int i1 = 0;
					int in = arr[i];
					while (arr[i] == in) {
						i++;
						i1++;
					}
					int j1 = 0;
					in = arr[j];
					while (arr[j] == in) {
						j1++;
						j--; // i*j//(1,1) (2,2) total 2*2 set
					}
					count += i1 * j1;
				}
			} else if (sum < x) {
				i++;
			} else {
				j--;
			}
		}

		return count;

	}

	static int hasArrayTwoCandidatesByMap(int arr[], int n, int x) {
		boolean has = false; /// 4 4 4 4 5 5 sum: 9, 9-4:5 no value so put 4,1-4,2-4,3-4,4,now 5 so
		int i = 0; // 4 is available has 4 frequence so 5 ll make set with all 4:count+=4,next is
					// 5:count+=4 total : 8,
					// 1 1 1 1 1 sum: 2, 2-1=1 1notavailable so put : 1,1, next is 1 it ll make set
					// with 1: so count+=1,
					// not 1:2, again 1 it ll make set with other 2, so count+=2, next is 1 it ll
					// make with other 3 count+=3
					// in short : count=0+1+2+3..(n-1)=n*n-1/2 : nc2
		Map<Integer, Integer> map = new HashMap<>();

		for (int j : arr) {
			int check = x - j;
			if (map.containsKey(check)) {
				i += map.get(check);
			}
			map.putIfAbsent(j, 0);
			map.put(j, map.get(j) + 1);
		}
		return i;

	}

}
