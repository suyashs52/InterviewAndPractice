package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import pp.gu.search.KthSmallest.FastScanner;

/* Name of the class has to be "Main" only if the class is public. */
public class AllocateBooks {
	public static void main(String[] args) throws java.lang.Exception {

//		You are given N number of books. Every ith  book has A[i] number of pages. You have to allocate contagious books to 
//		M number of students. There can be many ways or permutations to do so. In each permutation, one of the 
//		M		 students will be allocated the maximum number of pages. Out of all these permutations, the task is
//		to find that particular permutation in which the maximum number of pages allocated to a student is 
//		minimum of those in all the other permutations and print this minimum value.
//
//		Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
//
//		Note: Answer always exists and allotment should be in contiguous order (see the explanation for better understanding)
//		
//		Sample Input 0
//
//		4
//		12 34 67 90
//		2
//
//		Sample Output 0
//
//		113
//
//		Explanation
//
//		Allocation can be done in following ways
//		(12) and (34,67,90) Maximum Pages = 		191
//		(12,34) and (67,90) Maximum Pages = 157
//		(12	,	34	,	67	)	 and 		(90) Maximum Pages = 113	Therefore, the minimum of these cases is 	113
//		

		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		Integer[] arr = new Integer[t];
		int min = -1;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
			min = Math.max(min, arr[i]); //min this much size must allotated
			max += arr[i];
		}
		int needed = fs.nextInt();

		System.out.println(bsfr(arr, needed, min, max));

	}

	static int bsfr(Integer[] arr, int studnts, int low, int high) {
		if (studnts > arr.length)
			return 0;

		if (arr.length == 1)
			return arr[0];

		if (studnts == 1)
			return high;

		while (low <= high) { // logn
			int mid = low + (high - low) / 2;
			int maxbooks=bookPageCal(arr, mid, studnts);
			if (maxbooks == -1) { // n
				// if can't put for mid can possible put for lower value
				// then higher value only possible
				low = mid + 1;
			} else {
				int m=maxbooks;
				maxbooks=bookPageCal(arr, mid-1, studnts);
				if (maxbooks == -1) { // if just -1 not possible than m is the anser
					return mid;
				} else {
					high = mid - 1; // mid-1 if possible than we can have another lowest value
				}
			}
		}
		// distance
		return low;

	}

	static int bookPageCal(Integer[] arr, int mdist, int student) {
		// if student is greater than no of books means invalid distribution
		// if all books exahust and student remaining can be valid as no of student is
		// lesser than books
		// so take some books from prev student and give it to remaining student
		int c = 0;
		int count = 1;
		int max=-1;
		for (int i = arr.length-1; i >-1; i--) {
			if (c  + arr[i]<= mdist) {
				c += arr[i];

			} else {
				max=Math.max(max, c);
				c = arr[i];
				count++;
				if (count > student)
					break;
			}
		}
		max=Math.max(max, c);
		if (count > student)
			return -1;
		return max;

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