package pp.gu.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class FourDivisors {
	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		// output the sum of divisors of numbers in an array having exactly 4 divisors.

		for (int i = 0; i < a; i++) {
			int len = s.nextInt();
			int[] subsequence = new int[len];
			int key = 0;
			int[] div = new int[len];
			int[] div1 = new int[len];
			int sum = 0;
			for (int j = 0; j < len; j++) {

				subsequence[j] = s.nextInt();
				int d = (int)  Math.sqrt(subsequence[j]);
				if (d * d == subsequence[j])
					continue;
				boolean f = false;
				for (int k = 2; k <= d; k++) {
					if (subsequence[j] % k == 0) {
						if (div1[key] == 0) {
							div1[key] = k;
							div[key] = subsequence[j];
							f = true;
						} else {
							f = false;
							break;

						}
					}

				}
				if (f) {
					key++;
				}

				

			}
			int n = 0;
			for (int k = 0; k < key; k++) {
				n = div[k] / div1[k];
				sum += 1 + div[k] + div1[k] + n;
			}
			System.out.println(sum);

		}

		s.close();

	}

	static int gcd(int a, int b) {
		if (b == 0)
			return b;

		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}