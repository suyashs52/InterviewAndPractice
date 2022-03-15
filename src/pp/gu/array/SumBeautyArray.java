package pp.gu.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SumBeautyArray {
	public static void main(String[] args) throws java.lang.Exception {
		// You are given an array A of N numbers, output the count of pairs in the array
		// whose sum is divisible by 4

		Scanner s = new Scanner(System.in);
		int test = s.nextInt();
		while (test > 0) {

			int t = s.nextInt();

			if(t==1){
				System.out.println(0);
				test--;
				continue;
			}
			
			int[] arr = new int[t];

			for (int i = 0; i < t; i++) {
				arr[i] = s.nextInt();
			}

			// divisible pair as m=4 means we can make arary of size 4 (0 1 2 3)
			// if m>10^6 array size is more-- can prefer O(n^2)
			long[] res = new long[4]; // (a+b)%m=(a%m+b%m)%m (r1+r2)%m both r1 and r2=0
			// r=1r2=3,r1=2sor2=2 here we cant repeat pair in r=0/2 case anser+= countC2
			// 1and3 case count1*count3
			// if m=5 we don't have r1=r2 except 0

			for (int i = 0; i < t; i++) {
				res[arr[i] % 4]++;
			}

			int loop = 4 / 2 - 1; // avoid repeatation
			long sum = 0;
			if (res[0] > 1) {
				sum = (res[0] * (res[0] - 1)) / 2; // nc2]
			} else {
				sum = res[0];
			}

			for (int i = 1; i <= loop; i++) {
				sum += res[i] * res[4 - i];
			}

			if (4 % 2 == 0) { // if it is even 2=2 /odd 5 then compare multiply arr[2]*arr[3]
				if (res[2] < 1) {
					sum += res[2];
				} else {
					sum += (res[2] * (res[2] - 1)) / 2;
				}
			}

			System.out.println(sum);
			test--;
		}

		s.close();

	}

	static Long gcd(Long a, Long b) {
		if (b == 0)
			return b;

		if (a % b == 0)
			return b;
		Long a1 = Math.max(a, b);
		Long b1 = Math.min(a, b);

		return gcd(b1, a1 % b1);
	}

}
