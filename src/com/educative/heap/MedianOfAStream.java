package com.educative.heap;

public class MedianOfAStream {
	MinHeap minHeap = new MinHeap();
	MaxHeap maxHeap = new MaxHeap();

	public void insertNum(int num) {
		// insert min value in max heap, max value in min heap
		// choose max heap as priority
		if (maxHeap.size == 0 || maxHeap.first() >= num) {
			maxHeap.insert(num);
		} else {
			minHeap.insert(num); // larger no
		}

		if (maxHeap.size > minHeap.size + 1) {
			minHeap.insert(maxHeap.pop());
		} else if (maxHeap.size < minHeap.size) {
			// max heap has lesser value
			maxHeap.insert(minHeap.pop());
		}

	}

	public double findMedian() {

		if (maxHeap.size == minHeap.size) {
			// both are equivalent
			// even no
			return maxHeap.first() / 2.0 + minHeap.first() / 2.0;
		}

		return maxHeap.first();

	}

	public static void main(String[] args) {
		MedianOfAStream medianOfAStream = new MedianOfAStream();
		medianOfAStream.insertNum(3);
		medianOfAStream.insertNum(1);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(5);
		System.out.println("The median is: " + medianOfAStream.findMedian());
		medianOfAStream.insertNum(4);
		System.out.println("The median is: " + medianOfAStream.findMedian());
	}

}
