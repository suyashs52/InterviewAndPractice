package com.jav.pattern.proxy;

public class RemoteTextFile implements TextFile {

	private final String content;

	RemoteTextFile(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		try {
			Thread.sleep(5000);
		} catch (Exception ex) {

		}
		return content;
	}

}
