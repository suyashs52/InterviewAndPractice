package com.udemy.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
	ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();
	ArrayList<UndirectedEdge> edgelist = new ArrayList<>();

	public Kruskal(ArrayList<WeightedNode> nodelist) {
		this.nodelist = nodelist;
	}

	public static void main(String[] str) {

		ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();
		for (int i = 0; i < 5; i++) {
			nodelist.add(new WeightedNode("" + (char) (65 + i)));

		}

		Kruskal graph = new Kruskal(nodelist);
		// Add A<-> B , weight 10
		graph.addWeightedUndirectedEdge(1, 2, 10);

		// Add A<-> C , weight 20
		graph.addWeightedUndirectedEdge(1, 3, 20);

		graph.addWeightedUndirectedEdge(2, 3, 30);

		graph.addWeightedUndirectedEdge(2, 4, 5);

		graph.addWeightedUndirectedEdge(3, 4, 15);
		graph.addWeightedUndirectedEdge(3, 5, 6);

		graph.addWeightedUndirectedEdge(4, 5, 8);

		// run kruskal on graph
		System.out.println("Running Kruskal's Algo on the graph: ");
		graph.kruskal();

	}

	private void kruskal() {
		// sort the edge
		// make set
		// not combine two set if they are not combine
		// don't have to make isVisited array everytime
		DisjointSet.makeset(nodelist);
		Comparator<UndirectedEdge> comparator;
		comparator = new Comparator<UndirectedEdge>() {

			@Override
			public int compare(UndirectedEdge o1, UndirectedEdge o2) {
				// TODO Auto-generated method stub
				return o1.getWeight() - o2.getWeight();
			}
		};

		Collections.sort(edgelist, comparator);
		int cost = 0;
		for (UndirectedEdge edge : edgelist) {
			WeightedNode first = edge.getFirst();
			WeightedNode sec = edge.getSecond();
			if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(sec))) {
				DisjointSet.union(first, sec);
				cost += edge.getWeight();
				System.out.println("Taken " + edge);

			}
		}

		System.out.println("total cost is : " + cost);

	}

	private void addWeightedUndirectedEdge(int i, int j, int weight) {
		WeightedNode first = nodelist.get(i - 1);
		WeightedNode sec = nodelist.get(j - 1);

		first.getNeighbours().add(sec);
		sec.getNeighbours().add(first);
		first.getWeightMap().put(sec, weight);
		sec.getWeightMap().put(first, weight);
		edgelist.add(new UndirectedEdge(first, sec, weight));

	}

}
