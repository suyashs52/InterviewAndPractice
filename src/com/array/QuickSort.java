package com.array;

public class QuickSort {
	public static void code() {
		int[] arr = { 5, 4, 3, 10, 2, 20, 6 };
		quicksort(arr, 0, arr.length - 1);
		SortWaveForm.print(arr);
		arr = new int[] { 7, 6, 5, 4, 3, 2, 1 };
		quicksort(arr, 0, arr.length - 1);
		SortWaveForm.print(arr);
	}

	public static void quicksort(int[] arr, int l, int h) {
		if (l < h) {
			int pivot = partition(arr, l, h);
			quicksort(arr, l, pivot);
			quicksort(arr, pivot + 2, h);
		}

	}

	static int partition(int[] arr, int l, int h) {
		int pivot = h;// last element because at last i need to swap last with pivot place
		int p = arr[pivot];

		int j = l - 1;
		for (int i = l; i <= h; i++) { // <= cause passing index
			if (arr[i] < p) { // pivot elesment left smaller and right greater than
				int temp = arr[i]; // swap to less element because
				j++; // j will stop at less then pointer ,val greater than pivot
				arr[i] = arr[j]; // next if found small swap next to smaller
				arr[j] = temp;

			}
		}
		int temp = arr[j + 1]; // swap with next bigger then h(pivot)
		arr[j + 1] = arr[h];
		arr[h] = temp;

		return j;

	}
}
