package com.jav.pattern.chain.responsibility;

public interface DispenseChain {
	void setNextDispenseChain(DispenseChain dispenseChain);

	void despense(Currency cur);
}
