package com.jav.pattern.chain.responsibility;

//Chain the receiving objects and pass the request along the chain until an object handles it.
//used in java.util.logging.Logger#log(), javax.servlet.Filter#doFilter()
// an exception occurs in a try block, the first catch block tries to handle it. If it cannot handle that type of exception, the next catch block tries to handle it, and the same mechanism is followed until the exception is handled properly by handlers (catch blocks). If the last catch block in your application is unable to handle it, 
public class Currency {
	private int amount;

	public Currency(int amt) {
		this.amount = amt;
	}

	public int getAmount() {
		return this.amount;
	}

}
