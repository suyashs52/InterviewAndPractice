package com.array;

public class Stack {
	private int[] a;
	private int top;
	private int size;

	public Stack() {
		this.size = size;
		a = new int[size];
		for (int i = 0; i < size; i++)
			a[i] = 0;
		top = -1;
	}

	public boolean push(int k) {
		if (top < size - 1) {
			a[++top] = k;
			return true;
		}
		return false;

	}

	public boolean pop() {
		if (top == -1)
			return false;
		top--;
		return true;
	}

	public int getSize() {
		return size;
	}

	public int getTop() {
		return top;
	}

	public int peak() {
		return a[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void print() {
		char[] line = new char[top + 1];
		for (int i = 0; i <= top; i++) {
			line[i] = (char) (a[i] + '0');
		}
		System.out.println(line);
	}
}
