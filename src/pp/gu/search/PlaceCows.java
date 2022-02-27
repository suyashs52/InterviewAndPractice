package pp.gu.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import pp.gu.search.KthSmallest.FastScanner;

/* Name of the class has to be "Main" only if the class is public. */
public class PlaceCows {
	public static void main(String[] args) throws java.lang.Exception {

//		Farmer John has built a new long barn, with 
//		N
//		 stalls. The stalls are located along a straight line at positions 
//		x1....xN.His C cows dont like this barn layout and become aggressive towards each other once put 
		// into a stall. To prevent the cows from hurting each other, Farmer John wants
		// to assign the cows
		// to the stalls, such that the minimum distance between any two of them is as
		// large as possible.
		// What is the largest minimum distance?
//		
//		5
//		1 2 8 4 9
//		1
//		3
//		
//		3
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		Integer[] arr = new Integer[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = fs.nextInt();
		}
		int needed = fs.nextInt();

		int[] test = new int[needed];
		for (int i = 0; i < test.length; i++) {
			test[i] = fs.nextInt();
		}

		for (int i = 0; i < test.length; i++) {
			System.out.println(bsfr(arr, test[i]));
		}

	}

	static int bsfr(Integer[] arr, int value) {
		if (value > arr.length)
			return 0;

		if (arr.length == 1)
			return arr[0];

		Arrays.sort(arr); //nlogn

		int low = 0;
		int high = arr[arr.length - 1] - arr[0];

		while (low <= high) { //logn
			int mid = low + (high - low) / 2;
			
			if(distanceCal(arr, mid, value)==false) { //n 
				//if can't put for mid can possible put for lower value
				high=mid-1;
			}else {
				if(distanceCal(arr, mid+1, value)==false) {
					return mid; //largest distance as after this not possible to put cow with m distance
				}else {
					low=mid+1;
				}
			}
		}
		// distance
		return 0;

	}

	static boolean distanceCal(Integer[] arr, int mdist, int cow) {

		int c = arr[0];
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (c + mdist <= arr[i]) {
				count++; // increment cow as it put
				c = arr[i];// now cow is place so start from that index
				if (count >= cow)
					return true;
			}  
		}

		return false;

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