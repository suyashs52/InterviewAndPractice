package com.chef;

/* Read input from STDIN. Print your output to STDOUT*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CricketBatManf {
	public static void code() throws Exception {

		// Write code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp1 = br.readLine().split(" ");
		int t1 = Integer.parseInt(inp1[0]);
		int t2 = Integer.parseInt(inp1[1]);
		double[] id1 = new double[t1];
		double[] idd1 = new double[t1];
		double[] id2 = new double[t2];
		double[] idd2 = new double[t2];
		for (int i = 0; i < t1; i++) {
			inp1 = br.readLine().split(" ");
			id1[i] = Double.parseDouble(inp1[0]);
			idd1[i] = Double.parseDouble(inp1[1]);

		}
		Tree tr = new Tree();
		for (int i = 0; i < t2; i++) {
			inp1 = br.readLine().split(" ");
			id2[i] = Double.parseDouble(inp1[0]);
			idd2[i] = Double.parseDouble(inp1[1]);
			tr.insert(id2[i], idd2[i]);
		}
		int count = 0;
		for (int i = 0; i < t1; i++) {
			Node n = tr.search(tr.root, id1[i], idd1[i]);
			if (n == null) {

			} else {
				count++;
			}
		}
		System.out.println(count);

	}
}

class Node {
	double data1, data2;
	Node left, right;

	Node(double data1, double data2) {
		this.data1 = data1;
		this.data2 = data2;
		left = null;
		right = null;
	}
}

class Tree {

	Node root;

	Tree() {
		this.root = null;
	}

	void insert(double key1, double key2) {
		root = insert(root, key1, key2);
	}

	public Node insert(Node node, double data1, double data2) {
		if (node == null) {
			node = new Node(data1, data2);

			return node;
		}
		if (data1 < node.data1 && data2 < node.data2) {
			node.left = insert(node.left, data1, data2);
		} else {
			node.right = insert(node.right, data1, data2);
		}

		return node;
	}

	public Node search(Node root, double data1, double data2) {
		if (root == null || (root.data1 >= data1 && root.data2 <= data2)) {
			return root;
		}
		if (root.data1 > data1 && root.data2 > data2) {
			return search(root.left, data1, data2);
		}
		return search(root.right, data1, data2);
	}
}
