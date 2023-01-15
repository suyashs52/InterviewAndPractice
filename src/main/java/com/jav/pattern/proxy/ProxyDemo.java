package com.jav.pattern.proxy;

public class ProxyDemo {
	public static void code() {
		TextFile tf = new CachedTextFile(new RemoteTextFile("test proxy content"));
		// First file fetch will be slow, as a remote file has to be accessed.

		printContent(tf);
		// After fetching the file once, the second attempt will be quick, as file
		// contents will be cached inside the
		// proxy
		printContent(tf);
		// File can be further wrapped in other proxies, to add additional checks.

		printContent(new AccessLimitingTextFile(tf, "admin"));
		printContent(new AccessLimitingTextFile(tf, "user"));
	}

	private static void printContent(TextFile tf) {
		System.out.println("getting file content..");
		long start = System.currentTimeMillis();
		String content = tf.getContent();
		long duration = System.currentTimeMillis() - start;
		System.out.println("Got file content in " + duration + " ms. content is : " + content);
	}
}
