package com.jav.pattern.iterator;

public class ListOfDoubleIterator implements IteratorOfDouble {

	private ListOfDouble list;
	int index;

	public ListOfDoubleIterator(ListOfDouble list) {
		this.list = list;
		index = 0;
	}

	@Override
	public double next() {
		// TODO Auto-generated method stub
		return list.getElement(index++);
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index < list.size();
	}

}
