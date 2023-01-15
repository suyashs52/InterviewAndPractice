package pp.gu.math;

import java.util.*;
import java.lang.*;
import java.io.*;

public class LCDPuzzle {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			Long total = s.nextLong();
			Long a = s.nextLong();
			Long b = s.nextLong();
			Long limit = s.nextLong();

			Long c = gcd(Math.max(a, b), Math.min(a, b));
			Long lcd = a * b / c;

			if (limit >= total / a + total / b - (2 * total / lcd)) {
				System.out.println("Win");
			} else {
				System.out.println("Lose");
			}

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
