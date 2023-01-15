package com.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CHEFTMA {

	public static void code() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());

		for (int i = 0; i < test; i++) {
			String[] inp1 = br.readLine().split(" ");
			int total = Integer.parseInt(inp1[0]);
			int days = Integer.parseInt(inp1[1]);
			int wb = Integer.parseInt(inp1[2]);
			int[] plantask = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] compltask = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//reduce the plan task, when plantask>white
			int[] white = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			//increase the completed task, black<task
			int[] black = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//			1
//			4 2 2 
//			5 7 6 1	planed
//			3 3 1 1	comple
//			6 3	white
//			1 4 bl	plan>=comple
			//2 4 5 0  , 1 3  4 6
			// 5 4 2 0 , 6 4 3 1
			//find the next min / equal to diffelement
			
			

		}

	}

}
