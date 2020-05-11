package com.udemy.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkshtra {
	ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();

	Dijkshtra(ArrayList<WeightedNode> nodelist) {
		this.nodelist = nodelist;
	}

	public static void main(String[] args) {

		ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();
		for (int i = 0; i < 5; i++) {
			nodelist.add(new WeightedNode("" + (char) (65 + i)));
		}

		Dijkshtra graph = new Dijkshtra(nodelist);
		graph.addWeightedEdge(1, 3, 6); // Add A-> C , weight 6
		graph.addWeightedEdge(1, 4, 3); // Add A-> D , weight 3
		graph.addWeightedEdge(2, 1, 3); // Add B-> A , weight 3
		graph.addWeightedEdge(3, 4, 2); // Add C-> D , weight 2
		graph.addWeightedEdge(4, 3, 1); // Add D-> C , weight 1
		graph.addWeightedEdge(4, 2, 1); // Add D-> B , weight 1
		graph.addWeightedEdge(5, 2, 4); // Add E-> B , weight 4
		graph.addWeightedEdge(5, 4, 2); // Add E-> D , weight 2

		System.out.println("Printing Dijkstra from source: E");
		graph.dijkstra(nodelist.get(4));

	}

	private void dijkstra(WeightedNode node) {
		//take source, prior que for heap min implementatino 
		// take next connected node with min weight 
		//update min weight
		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		node.setDistance(0);
		queue.addAll(nodelist);
		while (queue.isEmpty() == false) {
			WeightedNode pres = queue.remove();
			for (WeightedNode neigh : pres.getNeighbours()) {
				if (queue.contains(neigh)) {

					if (neigh.getDistance() > pres.getDistance() + pres.getWeightMap().get(neigh)) {
						neigh.setDistance(pres.getDistance() + pres.getWeightMap().get(neigh));
						neigh.setParent(pres);
						// reset heap
						queue.remove(neigh);
						queue.add(neigh);
					}

				}
			}
		}

		for (WeightedNode nodeCheck : nodelist) {

			System.out.print("Node " + nodeCheck + " ,distance: " + nodeCheck.getDistance() + " Path: ");
			printPath(nodeCheck);
			System.out.println();

		}

	}

	private void printPath(WeightedNode node) {
		// TODO Auto-generated method stub
		if (node.getParent() != null) {
			printPath(node.getParent());
			System.out.print("->" + node);
		} else
			System.out.print(node);
	}

	private void addWeightedEdge(int i, int j, int k) {
		WeightedNode first = nodelist.get(i - 1);
		WeightedNode second = nodelist.get(j - 1);
		first.getNeighbours().add(second);
		first.getWeightMap().put(second, k);

	}

}
