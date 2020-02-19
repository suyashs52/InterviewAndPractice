package com.jav.pattern.proxy;

public class AccessLimitingTextFile implements TextFile {

	public static final String ADMIN_USER = "admin";
	public final TextFile textFile;
	private final String user;

	public AccessLimitingTextFile(TextFile textFile, String user) {
		this.textFile = textFile;
		this.user = user;

	}

	@Override
	public String getContent() {
		if (ADMIN_USER.equals(this.user)) {
			return textFile.getContent();
		}
		return "must be " + ADMIN_USER + " user to access file";
	}

}
