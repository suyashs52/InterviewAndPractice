package com;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Parser {
	final static private int BUFFER_SIZE = 1 << 16;

	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, byteRead;

	public Parser(InputStream in) {
		din = new DataInputStream(in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = byteRead = 0;
	}

	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = c == '-';
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		if (neg)
			return -ret;
		return ret;
	}

	public int nextInt() throws Exception {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = c == '-';
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
			c = read();
		} while (c > ' ');
		if (neg)
			return -ret;
		return ret;
	}

	public String next() throws IOException {
		StringBuilder ret = new StringBuilder();
		byte c = read();
		while (c <= ' ')
			c = read();
		do {
			ret = ret.append((char) c);
			c = read();
		} while (c > ' ');
		return ret.toString();
	}

	private void fillBuffer() throws IOException {
		byteRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (byteRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == byteRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public static void main(String... args) throws Exception {
		System.out.println(BUFFER_SIZE);
		Parser in=new Parser(System.in);
		String s=in.next();
		int i=in.nextInt();
	}

}
