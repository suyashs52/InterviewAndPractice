package com.jav.pattern.chain.responsibility;

import java.util.Scanner;

public class ATMDispenseChain {

	public static void code() {

		ATMDispenseChain adc = new ATMDispenseChain();

		System.out.println(adc.func(5, 2));
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			adc.c1.despense(new Currency(amount));
		}
	}

	int func(int x, int y) {
		if (x == 0)
			return y;
		else
			return func(x - 1, x + y);
	}

	DispenseChain c1;

	ATMDispenseChain() {
		c1 = new FiftyRsDispense();
		DispenseChain c2 = new TwentyRsDispense();
		c1.setNextDispenseChain(c2);
		c2.setNextDispenseChain(new TenRsDispense());
	}

}
