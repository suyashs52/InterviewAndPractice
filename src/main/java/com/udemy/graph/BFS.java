package com.udemy.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
	int[][] adjacencyMatrix;
	ArrayList<GraphNode> nodelist = new ArrayList<GraphNode>();

	BFS(ArrayList<GraphNode> nodelist) {
		this.nodelist = nodelist;
		adjacencyMatrix = new int[nodelist.size()][nodelist.size()];
	}

	public static void main(String... str) {
		code();
	}

	public static void code() {
		ArrayList<GraphNode> nodelist = new ArrayList<GraphNode>();

		for (int i = 1; i < 11; i++) {
			nodelist.add(new GraphNode("V" + i, i - 1));
		}

		BFS graph = new BFS(nodelist);
		// Add edges in graph
		graph.addUnidirectedEdge(1, 2);
		graph.addUnidirectedEdge(1, 4);
		graph.addUnidirectedEdge(2, 3);
		graph.addUnidirectedEdge(2, 5);
		graph.addUnidirectedEdge(3, 6);
		graph.addUnidirectedEdge(3, 10);
		graph.addUnidirectedEdge(4, 7);
		graph.addUnidirectedEdge(5, 8);
		graph.addUnidirectedEdge(6, 9);
		graph.addUnidirectedEdge(7, 8);
		graph.addUnidirectedEdge(8, 9);
		graph.addUnidirectedEdge(9, 10);

		System.out.println("print bfs from source v1");
		graph.bfs();

		System.out.println("linked list");

		graph.addLinkedUnidirectedEdge(1, 2);
		graph.addLinkedUnidirectedEdge(1, 4);
		graph.addLinkedUnidirectedEdge(2, 3);
		graph.addLinkedUnidirectedEdge(2, 5);
		graph.addLinkedUnidirectedEdge(3, 6);
		graph.addLinkedUnidirectedEdge(3, 10);
		graph.addLinkedUnidirectedEdge(4, 7);
		graph.addLinkedUnidirectedEdge(5, 8);
		graph.addLinkedUnidirectedEdge(6, 9);
		graph.addLinkedUnidirectedEdge(7, 8);
		graph.addLinkedUnidirectedEdge(8, 9);
		graph.addLinkedUnidirectedEdge(9, 10);
		graph.bfsLinked();
	}

	void addUnidirectedEdge(int i, int j) {

		i--;
		j--;
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;

	}

	void addLinkedUnidirectedEdge(int i, int j) {
		GraphNode first = nodelist.get(i - 1);
		GraphNode sec = nodelist.get(j - 1);
		first.setVisited(false);
		sec.setVisited(false);
		first.getNeighbours().add(sec);
		sec.getNeighbours().add(first);

	}

	void bfs() {
		for (GraphNode node : nodelist) {
			if (!node.isVisited()) {
				bfsVisit(node);
			}
		}
	}

	void bfsLinked() {
		for (GraphNode node : nodelist) {
			if (!node.isVisited()) {
				bfsVisitLinked(node);
			}
		}
	}

	private void bfsVisit(GraphNode node) {
		// track all connected node
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode present = queue.remove(0);
			present.setVisited(true);
			System.out.println(present + " ");
			ArrayList<GraphNode> neighbours = getNeighbours(present);
			for (GraphNode gn : neighbours) {
				if (!gn.isVisited()) {
					queue.add(gn);
					gn.setVisited(true);
				}
			}
		}

	}

	private void bfsVisitLinked(GraphNode node) {
		// track all connected node
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			GraphNode present = queue.remove(0);
			present.setVisited(true);
			System.out.println(present + " ");
			ArrayList<GraphNode> neighbours = present.getNeighbours();
			for (GraphNode gn : neighbours) {
				if (!gn.isVisited()) {
					queue.add(gn);
					gn.setVisited(true);
				}
			}
		}

	}

	private ArrayList<GraphNode> getNeighbours(GraphNode node) {
		ArrayList<GraphNode> gn = new ArrayList<GraphNode>();
		int index = node.getIndex();

		for (int i = 0; i < adjacencyMatrix.length; i++) {
			if (adjacencyMatrix[index][i] == 1) {
				gn.add(nodelist.get(i));
			}
		}

		return gn;
	}
}
