package com.chef;

public class NOKIA {

	public static void code() {
		permute(3);
	}

	public static void permute(int n) {

		while (n > 0) {
			System.out.print(n);
			permute(--n);
		}
		System.out.println();

	}
}
