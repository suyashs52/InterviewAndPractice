package pp.gu.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
public class LCMChallenge {
	public static void main(String[] args) throws java.lang.Exception {

		// your code goes here
		Scanner s = new Scanner(System.in);
		Long n = s.nextLong();
		// 3 no where each of them are less than or equal to N and their LCM is maximum.
		if (n % 2 != 0) { // not a even no gcd is 1 of any of 2
			System.out.println(n * (n - 1) * (n - 2));
		} else {
			// even n,n-2 is even check n n-3 if no common value
			if (gcd(n, n - 3) == 1) {
				System.out.println(n * (n - 1) * (n - 3));
			} else {
				// if gcd found for n , n-3
				// next max lcm found for next odd value
				n = n - 1;
				System.out.println(n * (n - 1) * (n - 2));
			}
		}
		s.close();

	}

	static long gcd(long a, long b) {
		if (b == 0)
			return b;

		if (a % b == 0)
			return b;
		return gcd(b, a % b);
	}
}