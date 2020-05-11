package com.udemy.graph;

import java.util.ArrayList;

public class BellmanFord {
	ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();

	public BellmanFord(ArrayList<WeightedNode> nodeList2) {
		nodelist = nodeList2;
		for (WeightedNode node : nodeList2) {
			node.setDistance(10000);
		}
	}

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();
		// create 5 nodes: A,B,C,D,E
		for (int i = 0; i < 5; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}
		BellmanFord graph = new BellmanFord(nodeList);

		graph.addWeightedEdge(1, 3, 6); // Add A-> C , weight 6
		graph.addWeightedEdge(2, 1, 3); // Add B-> A , weight 3
		graph.addWeightedEdge(1, 4, 6); // Add A-> D , weight 6
		// graph.addWeightedEdge(1,4,-6); //Add A-> D , weight -6 TEST NEGATIVE WEIGHT
		// HERE
		graph.addWeightedEdge(4, 3, 1); // Add D-> C , weight 1
		graph.addWeightedEdge(3, 4, 2); // Add C-> D , weight 2
		graph.addWeightedEdge(4, 2, 1); // Add D-> B , weight 1
		graph.addWeightedEdge(5, 4, 2); // Add E-> D , weight 2
		graph.addWeightedEdge(5, 2, 4); // Add E-> B , weight 4

		graph.bellmanFord(nodeList.get(4));

	}

	private void bellmanFord(WeightedNode snode) {
		snode.setDistance(0);
		for (int i = 1; i < nodelist.size(); i++) {
			for (WeightedNode node : nodelist) {
				for (WeightedNode neigh : node.getNeighbours()) {
					if (neigh.getDistance() > node.getDistance() + node.getWeightMap().get(neigh)) {
						neigh.setDistance(node.getDistance() + node.getWeightMap().get(neigh));
						neigh.setParent(node);
					}
				}
			}
		}

		System.out.println("Checking for Negative Cycle ...");
		// for each edge check if update possible, if true then negative cycle is there
		// report error
		for (WeightedNode presentNode : nodelist) {
			for (WeightedNode neighbor : presentNode.getNeighbours()) {
				// if distance of neighbor is greater than tentative new path then we have a
				// negative cycle, return from here..
				if (neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.getName());
					System.out.println("Old Distance: " + neighbor.getDistance());
					int newDistance = presentNode.getDistance() + presentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		} // end of loop
		System.out.println("Negative cycle not found !");

		// Print table of node with minimum distance and shortest path from source
		System.out.println("\n\nPrinting Paths now: ");
		for (WeightedNode nodeToCheck : nodelist) {
			if (nodeToCheck.getDistance() != 1000) {
				System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
				pathPrint(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck);
			}
			System.out.println();
		}

	}

	// Printing path
	private static void pathPrint(WeightedNode node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());
			System.out.print("->" + node);
		} else
			System.out.print(node);
	}// end of method

	// add a weighted edge between two nodes
	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodelist.get(i - 1);
		WeightedNode second = nodelist.get(j - 1);
		first.getNeighbours().add(second);
		first.getWeightMap().put(second, d);
	}// end of method

}
