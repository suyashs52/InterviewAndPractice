package com.udemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SelectingStock {

	public static void main(String[] args) throws Exception {
		System.out.println("test");

		test();
	}

	private static void test() {
		int[] currentval = new int[] { 175, 133, 109, 210, 97 };
		int[] futureval = new int[] { 200, 125, 128, 228, 133 };

		int saving = 100;
		code(currentval, futureval, saving);
	}

	private static void code(int[] currentval, int[] futureval, int saving) {
		int[] profit = new int[futureval.length];
		for (int i = 0; i < currentval.length; i++)
			profit[i] = futureval[i] - currentval[i];
		int[] even=new int[futureval.length+1];
		int[] odd=new int[futureval.length+1];
		int[] current;
		int[] prev;
		int count=0;
//		while(true) {
//			count++;
//			if(count%2==1) {
//				current=odd;
//				prev=even;
//			}else {
//				current=even;
//				prev=odd;
//			}
//			int prevdiff=Integer.MIN_VALUE;
//			for(int i=1;i<current.length;i++) {
//				prevdiff=Math.max(prevdiff, prev[i-1]-currentval[i-1]);
//				current[i]=Math.max(current[i-1], prevdiff+currentval[i]);
//			}
//			break;
//		}
//		System.out.println(count%2==1? odd[odd.length-1]:even[even.length-1]); 
//		printval(currentval);
		printval(profit);
	}

	static void printval(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ",");
		System.out.println();
	}

}
