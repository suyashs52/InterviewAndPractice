package com.udemy.graph;

import java.util.ArrayList;

public class DisjointSet {
	ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();

	public static void main(String... str) {
		ArrayList<WeightedNode> nodelist = new ArrayList<WeightedNode>();
		for (int i = 0; i < 10; i++) {
			nodelist.add(new WeightedNode((char) (65 + i) + ""));
		}
		driver(nodelist);

	}

	private static void driver(ArrayList<WeightedNode> nodelist) {
		makeset(nodelist);

		for (int i = 0; i < nodelist.size() - 1; i++) {
			WeightedNode fnode = nodelist.get(i);
			WeightedNode snode = nodelist.get(i + 1);
			System.out.println("\nFirst set name is: " + fnode.getName());
			fnode.getSet().printNodeSet();
			System.out.println("\nSecond set name is: " + snode.getName());
			snode.getSet().printNodeSet();
			if (!findSet(fnode).equals(findSet(snode))) {
				System.out.println("\nMaking union " + fnode + " and " + snode);
				DisjointSet union = union(fnode, snode);
				union.printNodeSet();

			}
			System.out.println("\n**************************************\n");
		}

	}

	private static DisjointSet union(WeightedNode fnode, WeightedNode snode) {
		DisjointSet d1 = fnode.getSet();
		DisjointSet d2 = snode.getSet();

		if (d1.getNode().size() > d2.getNode().size()) {
			ArrayList<WeightedNode> nn = d2.getNode();
			for (WeightedNode n : nn) {
				n.setSet(d1);
				d1.getNode().add(n);
			}
			return d1;
		} else {
			ArrayList<WeightedNode> nn = d1.getNode();
			for (WeightedNode n : nn) {
				n.setSet(d2);
				d2.getNode().add(n);
			}
			return d2;
		}

	}

	private void printNodeSet() {
		System.out.println("printing all node of the set:");
		for (WeightedNode n : node) {
			System.out.print(n + " ");
		}
		System.out.println();

	}

	ArrayList<WeightedNode> node=new ArrayList<WeightedNode>();

	private static void makeset(ArrayList<WeightedNode> nodelist) {
		for (WeightedNode node : nodelist) {
			DisjointSet set = new DisjointSet();
			set.getNode().add(node);
			node.setSet(set);
		}

	}

	public ArrayList<WeightedNode> getNode() {
		return node;
	}

	public void setNode(ArrayList<WeightedNode> node) {
		this.node = node;
	}

	public static DisjointSet findSet(WeightedNode node) {
		return node.getSet();
	}

}
