package com.udemy.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class SSSPBFS {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public SSSPBFS(ArrayList<GraphNode> nodeList) {
		// TODO Auto-generated constructor stub
		this.nodeList = nodeList;
	}

	public static void main(String... args) {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

		for (int i = 0; i < 10; i++) {
			nodeList.add(new GraphNode("V" + i));
		}
		SSSPBFS graph = new SSSPBFS(nodeList);
		graph.addUndirectedEdge(0, 8);
		graph.addUndirectedEdge(8, 2);
		graph.addUndirectedEdge(8, 9);
		graph.addUndirectedEdge(2, 1);
		graph.addUndirectedEdge(9, 1);
		graph.addUndirectedEdge(2, 4);
		graph.addUndirectedEdge(1, 3);
		graph.addUndirectedEdge(1, 7);
		graph.addUndirectedEdge(3, 4);
		graph.addUndirectedEdge(3, 5);
		graph.addUndirectedEdge(7, 6);
		graph.addUndirectedEdge(5, 6);
		System.out.println("Printing BFS from source: 2");
		graph.BFSForSSSP(nodeList.get(2));
		// 0-8 8-2,9 2-1,4 9-1 1-3,7 3-4,5 7-6 5-6
	}

	private void BFSForSSSP(GraphNode graphNode) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(graphNode);
		while (!queue.isEmpty()) {
			GraphNode pre = queue.remove(0);
			pre.setVisited(true);
			System.out.print("Printing path for node " + pre.getName() + ": ");
			pathPrint(pre);
			System.out.println();
			for (GraphNode neigh : pre.getNeighbours()) {

				if (!neigh.isVisited()) {
					queue.add(neigh);
					neigh.setVisited(true);
					neigh.setParent(pre);
				}

			}

		}

	}

	private void pathPrint(GraphNode node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());

		}
		System.out.print(node.getName() + " ");

	}

	private void addUndirectedEdge(int i, int j) {
		// TODO Auto-generated method stub
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);

	}
}
