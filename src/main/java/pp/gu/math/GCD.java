package pp.gu.math;

import java.util.*;
import java.lang.*;
import java.io.*;

public class GCD {
	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		Scanner s = new Scanner(System.in);
		Long a = s.nextLong();
		Long b = s.nextLong();

		Long c = gcd(Math.max(a, b), Math.min(a, b));
		Long lcd = a * b / c;

		System.out.println(c + " " + lcd);

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
