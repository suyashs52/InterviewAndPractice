package com.jav.pattern.iterator;

public class IteratorGenerics {
	public <T> void forLoop(T[] array) {
		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i] + " ");
		}
	}

	public <T> void forEach(T[] array) {
		for (T val : array) {
			System.out.println(val + " ");
		}
	}
}
