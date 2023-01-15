package com.udemy.graph;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
	ArrayList<GraphNode> nodeList;

	DFS(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	public static void main(String... str) {
		code();
	}

	public static void code() {
		ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
		for (int i = 1; i < 11; i++) {
			nodeList.add(new GraphNode("V" + i));
		}
		DFS graph = new DFS(nodeList);
		// add edges following graph in graph.docx
		graph.addUndirectedEdge(1, 2);
		graph.addUndirectedEdge(1, 4);
		graph.addUndirectedEdge(2, 3);
		graph.addUndirectedEdge(2, 5);
		graph.addUndirectedEdge(3, 6);
		graph.addUndirectedEdge(3, 10);
		graph.addUndirectedEdge(4, 7);
		graph.addUndirectedEdge(5, 8);
		graph.addUndirectedEdge(6, 9);
		graph.addUndirectedEdge(7, 8);
		graph.addUndirectedEdge(8, 9);
		graph.addUndirectedEdge(9, 10);

		// dfs from v1
		System.out.println("Printing DFS from source: V1");
		graph.dfs();
	}

	private void dfs() {
		for (GraphNode gn : nodeList) {
			if (!gn.isVisited()) {
				dfsVisitIter(gn);
			}
		}

	}

	private void dfsVisitIter(GraphNode gn) {
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(gn);
		while (!stack.empty()) {
			GraphNode present = stack.pop();
			present.setVisited(true);
			System.out.print(present.getName()+" ");
			for (GraphNode node : present.getNeighbours()) {
				if (!node.isVisited()) {
					stack.add(node);
					node.setVisited(true);
				}

			}

		}

	}

	private void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);

	}
}
