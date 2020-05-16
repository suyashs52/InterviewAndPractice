package com.udemy.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public Prims(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	public static void main(String[] args) {
		ArrayList<WeightedNode> nodeList = new ArrayList<>();

		// Create 5 nodes: A,B,C,D,E
		for (int i = 0; i < 5; i++) {
			nodeList.add(new WeightedNode("" + (char) (65 + i)));
		}

		Prims graph = new Prims(nodeList);
		graph.addWeightedUndirectedEdge(1, 2, 10); // Add undirected Edge between A-B with Weight 10
		graph.addWeightedUndirectedEdge(1, 3, 20); // Add undirected Edge between A-C with Weight 20
		graph.addWeightedUndirectedEdge(2, 3, 30); // Add undirected Edge between B-C with Weight 30
		graph.addWeightedUndirectedEdge(2, 4, 5); // Add undirected Edge between B-D with Weight 5
		graph.addWeightedUndirectedEdge(3, 4, 15); // Add undirected Edge between C-D with Weight 15
		graph.addWeightedUndirectedEdge(3, 5, 6); // Add undirected Edge between C-E with Weight 6
		graph.addWeightedUndirectedEdge(4, 5, 8); // Add undirected Edge between D-E with Weight 8

		System.out.println("Printing Prim's Algo from source: E");
		graph.prims(nodeList.get(4));

	}

	private void prims(WeightedNode node) {
		// select a node, mark all node distance to infinite
		// create max heap queue, add all node , heap top is minimum node
		// take first node update neighbors distance and so on till queue is empty
		for (WeightedNode n : nodeList) {
			n.setDistance(Integer.MAX_VALUE);
		}
		node.setDistance(0);

		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		queue.addAll(nodeList);
		while (queue.isEmpty() == false) {

			WeightedNode presentNode = queue.remove();

			for (WeightedNode neighbor : presentNode.getNeighbours()) {
				if (queue.contains(neighbor)) {// If vertex is not processed, only then enter in if-else
					// If known weight of this ‘adjacent vertex’ is more than current edge,
					// then update ‘adjacent vertex’s’ distance and parent
					if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						queue.remove(neighbor); // Refresh the priority queue
						queue.add(neighbor);
					} // end of if-else
				} // end of if-else
			}

		}
		// end of for loop

		int cost = 0;
		for (WeightedNode nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: "
					+ nodeToCheck.getParent());
			cost = cost + nodeToCheck.getDistance();
		}

		System.out.println("\nTotal cost of MST: " + cost);
	}

	private void addWeightedUndirectedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode second = nodeList.get(j - 1);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
		first.getWeightMap().put(second, d);
		second.getWeightMap().put(first, d);

	}

}
