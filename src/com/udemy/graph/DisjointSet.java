package com.udemy.graph;

import java.util.ArrayList;

public class DisjointSet {
	ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();

	public static void main(String... str) {
		ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();
		for (int i = 0; i < 10; i++) {
			nodelist.add(new WeightedNode((char) (65 + i) + ""));
		}
		driver(nodelist);

	}

	private static void driver(ArrayList<WeightedNode> nodelist) {
		makeset(nodelist);

	}

	private static void makeset(ArrayList<WeightedNode> nodelist2) {
		// TODO Auto-generated method stub
		
	}

}
