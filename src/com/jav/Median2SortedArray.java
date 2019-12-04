package com.jav;

public class Median2SortedArray {
	public static void code() {
		int[] ar1 = { 7, 10, 12, 15, 20 };
		int[] ar2 = { 1, 2, 3, 4, 5 };
		System.out.println(getMedian(ar1, ar2));
		
		//take out ar1,ar2 median> 3,12 next median can be found ar1m<ar2m ar1..,..ar2 else ..ar1,ar2..
		//n=0,m=2 , n1m1, n1,modd so sum even: n1>mmed n1+mmed ,n1,meven
		//{5,10, 12, 15, 20 }; n1<10,10+12,n1<12 n1+12,n<15 n1+12,n<20,n1+15 so 12+max(10,15,n1)
		//{5,10, 12, 15,16, 20 };n1 so odd, n1<12:12,n1<15 n1,n1<16 15 12,15,n1
		//n2m2-median of 4,n2modd,n2meven, 
		//{5,10, 12, 15, 20 }n2odd sumlenodd,n1n2<12,7 8 >10,7 11>11,11 13>12,13 14 13,13 17 13,
		//	min(15,n2), 12, max(10,n1)
		//n2meven sum even
		//{5,10, 12, 15,16, 20 }n2 even,15,12,max(10,n1), min(n2,16)
		//12,15 
		
	}

	static int getMedian(int[] ar1, int[] ar2) {
		int med = 0;
		int len = ar1.length + ar2.length;
		int k = 0, l = 0;
		if ((len & 1) == 1) { // odd
			len = len / 2;
			for (int i = 0; i <= len; i++) {
				if (k < ar1.length && l< ar2.length) {
					med = ar1[k] > ar2[l] ? ar2[l++] : ar1[k++];
				} else if (k < ar1.length) {
					med = ar1[k++];
				} else {
					med = ar2[l++];
				}

			}
			return med;
		} else {
			// even
			int med2 = 0;
			len = len / 2;
			for (int i = 0; i <= len; i++) {
				med2 = med;
				if (k < ar1.length && l< ar2.length) {
					med = ar1[k] > ar2[l] ? ar2[l++] : ar1[k++];
				} else if (k < ar1.length) {
					med = ar1[k++];
				} else {
					med = ar2[l++];
				}

			}
			return (med + med2) / 2;

		}

	}
}
