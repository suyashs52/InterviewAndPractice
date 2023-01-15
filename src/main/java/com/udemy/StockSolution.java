package com.udemy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gautam R Patankar on 2020-04-28
 */

class Result {

	/*
	 * Complete the 'selectStock' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER saving 2. INTEGER_ARRAY currentValue 3. INTEGER_ARRAY
	 * futureValue
	 */

	public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
	
		int[] currentVal = currentValue.stream().mapToInt(Integer::intValue).toArray();
		int[] futureVal = futureValue.stream().mapToInt(Integer::intValue).toArray();
		int[] profitVal = new int[currentVal.length];
		int profit;

		for (int i = 0; i < currentVal.length; i++) {
			profitVal[i] = futureVal[i] - currentVal[i];
		}

		// Sort the array in descending order

		for (int i = 0; i < currentVal.length; i++) {
			for (int j = i + 1; j < profitVal.length; j++) {
				if (profitVal[i] < profitVal[j]) {
					profit = profitVal[i];
					profitVal[i] = profitVal[j];
					profitVal[j] = profit;

					profit = currentVal[i];
					currentVal[i] = currentVal[j];
					currentVal[j] = profit;

					profit = futureVal[i];
					futureVal[i] = futureVal[j];
					futureVal[j] = profit;
				}
			}
		}

		profit = 0;
		for (int i = 0; i < currentVal.length; i++) {
			if (profitVal[i] > 0 && saving >= currentVal[i]) {
				profit = profit + profitVal[i];
				saving = saving - currentVal[i];
			}
		}

		return profit;
	}

}

public class StockSolution {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//		int saving = Integer.parseInt(bufferedReader.readLine().trim());
//
//		int currentValueCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//		List<Integer> currentValue = new ArrayList<>();
//
//		for (int i = 0; i < currentValueCount; i++) {
//			int currentValueItem = Integer.parseInt(bufferedReader.readLine().trim());
//			currentValue.add(currentValueItem);
//		}
//
//		int futureValueCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//		List<Integer> futureValue = new ArrayList<>();
//
//		for (int i = 0; i < futureValueCount; i++) {
//			int futureValueItem = Integer.parseInt(bufferedReader.readLine().trim());
//			futureValue.add(futureValueItem);
//		}
		List<Integer> cv = new ArrayList<Integer>() {
			{
				add(1);
				add(1);
				add(1);
				add(28);
			}
		};
		List<Integer> fv = new ArrayList<Integer>() {
			{
				add(9);
				add(9);
				add(9);
				add(40);
			}
		};
		int saving=28;
		int result = Result.selectStock(saving, cv, fv);
		System.out.println(result);
		//bufferedReader.close();
	}
}
