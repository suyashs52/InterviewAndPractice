package com.educative.heap;

import java.util.PriorityQueue;

public class MaximizeCapital {
	MinHeap minHeap = new MinHeap();
	MaxHeap maxHeap = new MaxHeap();

	public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		int current = -1;

		// capital given, so find max profit from given capital

		PriorityQueue<Integer> cap = new PriorityQueue<Integer>(capital.length, (i1, i2) -> capital[i1] - capital[i2]);

		PriorityQueue<Integer> prof = new PriorityQueue<Integer>(profits.length, (i1, i2) -> profits[i2] - profits[i1]);

		// sort capital desc and put index of it
		for (int i : capital) {
			cap.add(i);
		}

		for (int i = 0; i < numberOfProjects; i++) {

			while (!cap.isEmpty() && capital[cap.peek()] <= initialCapital) {
				prof.add(cap.poll()); // add profit
			}

			if (prof.isEmpty())
				break;
			
			//if cap is empty and prof is not , and proj is less ,add remaining cause above we check <= intialcap
			initialCapital += profits[prof.poll()];
		}

		return initialCapital;

	}

	public static void main(String[] args) {
		int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
		System.out.println("Maximum capital: " + result);
		result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
		System.out.println("Maximum capital: " + result);
	}

}
