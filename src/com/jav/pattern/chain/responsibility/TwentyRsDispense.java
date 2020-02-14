package com.jav.pattern.chain.responsibility;

public class TwentyRsDispense implements DispenseChain {

	private DispenseChain dispenseChain;
	private static int filter = 20;

	@Override
	public void setNextDispenseChain(DispenseChain dispenseChain) {
		this.dispenseChain = dispenseChain;
	}

	@Override
	public void despense(Currency cur) {
		if (cur.getAmount() >= filter) {
			int num = cur.getAmount() / filter;
			int remainder = cur.getAmount() % filter;
			System.out.println(filter+ " dispencing " + num + " rs notes");
			if (remainder != 0)
				this.dispenseChain.despense(new Currency(remainder));
		} else {
			this.dispenseChain.despense(cur);
		}
	}

}
