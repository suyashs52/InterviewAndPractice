package com.educative.heap;
 
public class SlidingWindowMedian {
	MinHeap minHeap = new MinHeap();
	MaxHeap maxHeap = new MaxHeap();

	public double[] findSlidingWindowMedian(int[] nums, int k) {

		double[] result = new double[nums.length - k + 1];

		for (int i = 0; i < nums.length; i++) {
			// put max heap value greater than peek value so navigate to median value
			if (maxHeap.size == 0 || maxHeap.first() >= nums[i]) {
				maxHeap.insert(nums[i]);
			} else {
				minHeap.insert(nums[i]);
			}

			// if size differentiate -- balance
			if (maxHeap.size > minHeap.size + 1) {
				minHeap.insert(maxHeap.pop());
			} else if (minHeap.size > maxHeap.size) {
				maxHeap.insert(minHeap.pop());
			}

			if (i >= k-1 ) { //if k=2,operate on when i=1
				// if odd number
				if (maxHeap.size != minHeap.size) {
					result[i - k + 1] = maxHeap.first();
				} else {
					result[i - k + 1] = maxHeap.first() / 2.0 + minHeap.first() / 2.0;
				}

				int rem = nums[i - k + 1]; // first index of window

				if (rem <= maxHeap.first()) { // insertion logic
					maxHeap.removeElem(rem);

				} else {
					minHeap.removeElem(rem);
				}

				if (maxHeap.size > minHeap.size + 1) {
					minHeap.insert(maxHeap.pop());
				} else if (minHeap.size > maxHeap.size ) {
					maxHeap.insert(minHeap.pop());
				}


			}

		}

		return result;
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
		SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
		double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
		System.out.println();

		slidingWindowMedian = new SlidingWindowMedian();
		result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
		System.out.print("Sliding window medians are: ");
		for (double num : result)
			System.out.print(num + " ");
	}

}
 
interface t{
	void test();
}
abstract class test implements t{
	public void test(){
		//logic
	}
	
}