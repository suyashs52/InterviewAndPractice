package com.jav.pattern.iterator;
///can traverse a container to access its elements without knowing how these data are stored internally

// traverse different kinds of collection objects in a standard and uniform way

public class IteratorDemo {
	public static void code() {
		double[] value = { 1.0, 5.5, 3.2, 1.3, 2.3, 9.8 };

		CollectionOfDouble cd = new ListOfDouble(10);

		for (double d : value) {
			cd.add(d);
		}

		System.out.println("Elements : ");

		IteratorOfDouble iterator = cd.iterator();

		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println();
	}
}
