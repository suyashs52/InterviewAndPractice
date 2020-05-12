package com.udemy.graph;

import java.util.ArrayList;

public class FloydWarshall {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public FloydWarshall(ArrayList<WeightedNode> nodeList2) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList2;
	}

	public static void main(String... strings) {

		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// Create 4 Vertices: A,B,C,D
		for (int i = 0; i < 4; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		FloydWarshall graph = new FloydWarshall(nodeList);
		graph.addWeightedEdge(1, 4, 1);// Add A-> D , weight 1
		graph.addWeightedEdge(1, 2, 8);// Add A-> B , weight 8
		graph.addWeightedEdge(2, 3, 1);// Add B-> C , weight 1
		graph.addWeightedEdge(3, 1, 4);// Add C-> A , weight 4
		graph.addWeightedEdge(4, 2, 2);// Add D-> B , weight 2
		graph.addWeightedEdge(4, 3, 9);// Add D-> C , weight 9

		System.out.println("Printing Floyd-Warshall from each source:");
		graph.floydWarshall();
	}

	private void floydWarshall() {
		int size = nodeList.size();
		int[][] v = new int[size][size];
		for (int i = 0; i < size; i++) {
			WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode sec = nodeList.get(j);
				if (i == j) {
					v[i][j] = 0;
				} else if (first.getWeightMap().containsKey(sec)) {
					v[i][j] = first.getWeightMap().get(sec);
				} else {
					v[i][j] = 1000;// large value
				}
			}
		}
		// there exist a path via a node for all i,j
		// if present and weight is greater than replace it with path weight
		for (int k = 0; k < nodeList.size(); k++) {
			for (int i = 0; i < nodeList.size(); i++) {
				for (int j = 0; j < nodeList.size(); j++) {
					if (v[i][j] > v[i][k] + v[k][j]) {
						v[i][j] = v[i][k] + v[k][j];
					}
				}
			}
		}

		// Print table of node with minimum distance and shortest path from each source
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
			for (int j = 0; j < size; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

	}

	private void addWeightedEdge(int i, int j, int k) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode sec = nodeList.get(j - 1);
		first.getNeighbours().add(sec);
		first.getWeightMap().put(sec, k);

	}

}
