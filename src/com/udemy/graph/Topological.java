package com.udemy.graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	public Topological(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}

	public static void main(String... strings) {
		ArrayList<GraphNode> nodelist = new ArrayList<GraphNode>();
		for (int i = 1; i < 7; i++) {
			nodelist.add(new GraphNode("V" + i));
		}
		Topological graph = new Topological(nodelist);
		graph.addDirectedEdge(6, 3);
		graph.addDirectedEdge(5, 1);
		graph.addDirectedEdge(5, 2);
		graph.addDirectedEdge(3, 4);
		graph.addDirectedEdge(4, 2);
		graph.sort();

	}

	private void sort() {
		// push into stack all below node recursively stack
		// once all inserted top is first one
		// below it into stack depended on top
		// once all visited print it from first node as it is top element in stack
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode node : nodeList) {
			if (!node.isVisited()) {
				tvisit(node, stack);
			}
		}
		while (stack.isEmpty() == false) {
			System.out.print(stack.pop().getName() + " ");
		}
	}

	private void tvisit(GraphNode node, Stack<GraphNode> stack) {
		for (GraphNode gn : node.getNeighbours()) {
			if (!gn.isVisited())
				tvisit(gn, stack);
		}
		node.setVisited(true);
		stack.push(node);

	}

	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbours().add(second);
	}

}
