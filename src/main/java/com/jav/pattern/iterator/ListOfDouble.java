package com.jav.pattern.iterator;

public class ListOfDouble implements CollectionOfDouble {
	private double[] elments;
	private int pointer;

	public ListOfDouble(int size) {
		this.elments = new double[size];
		pointer = 0;

	}

	public double getElement(int i) {
		// TODO Auto-generated method stub
		return this.elments[i];
	}

	@Override
	public void add(double x) {
		this.elments[pointer++] = x;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return pointer;
	}

	@Override
	public IteratorOfDouble iterator() {
		return new ListOfDoubleIterator(this);

	}

}
