package com.dp;

public class DecodingDigit {

	public static void code() {
		String inp = "1226";
//		 1 2 2 6
//		 12 2 6
//		 12 26
//		 1 22 6
//		 1 2 26  5
		if (inp.charAt(0) == '0') // no alpha digit has 0 before
			System.out.println(0);
		char[] digit = inp.toCharArray();
		System.out.println(countdecode(digit, digit.length));
	}

	static int countdecode(char[] digit, int n) {
		int count = 0;

		if (n == 0 || n == 1)
			return 1;
		System.out.println("line 1, count,digit(" + count + "," + digit[n - 1] + ")");
		if (digit[n - 1] > '0')
			count = countdecode(digit, n - 1);
		System.out.println("line 2, count,digit(" + count + "," + digit[n - 2] + ")");

		if (digit[n - 2] == '1' || (digit[n - 2] == '2' && digit[n - 2] < '7'))
			count += countdecode(digit, n - 2);
		System.out.println("line 3, count,digit(" + count + "," + digit[n - 2] + ")");

		// if(digit[n])
		return count;

	}

	static int counterDigitLoop(char[] digits) {
		int a = 1;
		int b = 1;
		int count = 0;
		for (int i = 2; i < digits.length; i++) {

		}
		return count;
	}

	
}
