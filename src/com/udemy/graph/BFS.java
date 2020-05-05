package com.udemy.graph;

import java.util.ArrayList;

public class BFS {

	public static void code() {
		ArrayList<GraphNode> nodelist = new ArrayList<GraphNode>();
		for (int i = 1; i < 11; i++) {
			nodelist.add(new GraphNode("V" + i, i - 1));
		}
	}
}
