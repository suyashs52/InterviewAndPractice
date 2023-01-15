package com.jav.pattern.chain.responsibility;

public class FiftyRsDispense implements DispenseChain {
	private DispenseChain dispenseChain;

	@Override
	public void setNextDispenseChain(DispenseChain dispenseChain) {
		this.dispenseChain = dispenseChain;
	}

	@Override
	public void despense(Currency cur) {
		if (cur.getAmount() >= 50) {
			int num = cur.getAmount() / 50;
			int remainder = cur.getAmount() % 50;
			System.out.println("dispencing 50 " + num + " rs notes");
			if (remainder != 0)
				this.dispenseChain.despense(new Currency(remainder));
		} else {
			this.dispenseChain.despense(cur);
		}
	}

}
