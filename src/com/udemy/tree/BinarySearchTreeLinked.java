package com.udemy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeLinked {
	BinaryNode root;

	BinarySearchTreeLinked() {
		root = null;
	}

	public static void main(String... str) {
		BinarySearchTreeLinked tree = new BinarySearchTreeLinked();

		System.out.println("insert 10 nodes in Tree");
		tree.insert(100);
		tree.insert(80);
		tree.insert(70);
		tree.insert(90);
		tree.insert(50);

		tree.printTreeGraphically();
		System.out.println("\n\nSearching for value on BST...");
		tree.searchForValue(80);
		System.out.println("\nSearching for value on BST...");
		tree.searchForValue(60);

		tree.deleteNodeOfBST(80); // Node does not exists
		tree.printTreeGraphically();
		tree.deleteNodeOfBST(60);
		tree.printTreeGraphically();
		tree.deleteNodeOfBST(50); // Node is having 2 Child
		tree.printTreeGraphically();
		// Deleting entire Tree
		tree.deleteTree();

		// Traversing Tree
		tree.levelOrderTraversal();
	}

	private void levelOrderTraversal() {
		// TODO Auto-generated method stub

	}

	private void deleteTree() {
		// TODO Auto-generated method stub
		System.out.println("Deleting entire Tree...");
		root = null;

	}

	private void deleteNodeOfBST(int value) {

		System.out.println("\n\nDeleting " + value + " from BST...");
		deleteNodeOfBST(root, value);

	}

	private BinaryNode deleteNodeOfBST(BinaryNode node, int value) {

		if (node == null) {
			System.out.println(value + " not found");
			return null;
		}
		if (value < node.value) {
			deleteNodeOfBST(node.getLeft(), value);
		} else if (value > node.value) {
			deleteNodeOfBST(node.getRight(), value);
		} else {
			if (node.getLeft() != null && node.getRight() != null) {
				BinaryNode temp = node;
				temp = findMinNodeRight(temp.getRight());
				node.setValue(temp.getValue());
				node.setRight(deleteNodeOfBST(node.getRight(), temp.getValue()));

			} else if (node.getLeft() != null) {
				node = node.getLeft();
			} else if (node.getRight() != null) {
				node = node.getRight();
			} else {
				node = null;
			}
		}
		return node;
	}

	private BinaryNode findMinNodeRight(BinaryNode node) {
		// TODO Auto-generated method stub
		if (node.getLeft() == null)
			return node;
		else {
			return findMinNodeRight(node.getLeft());
		}

	}

	private void searchForValue(int value) {
		// TODO Auto-generated method stub
		searchForValue(root, value);

	}

	private BinaryNode searchForValue(BinaryNode node, int value) {
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println(value + " not found");
			return null;
		} else if (node.getValue() == value) {
			System.out.println(value + " found");
			return node;
		} else if (node.getValue() > value) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}

	}

	private void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		int cl = 1;
		queue.add(root);
		// print level wise , null will not print
		level.add(1);
		while (queue.isEmpty() == false) {
			if (cl == level.peek()) {
				if (queue.peek() != null) {
					queue.add(queue.peek().getLeft());
					queue.add(queue.peek().getRight());
					level.add(cl + 1);
					level.add(cl + 1);
				}
				System.out.print(queue.remove() + " ");
				level.remove();

			} else {
				System.out.println("\n");
				cl++;

			}

		}

	}

	private void insert(int i) {
		// TODO Auto-generated method stub
		if (root == null) {
			BinaryNode node = new BinaryNode();
			node.setValue(i);
			root = node;
			return;
		}
		insert(root, i);

	}

	private BinaryNode insert(BinaryNode node, int value) {
		if (node == null) {
			BinaryNode n = new BinaryNode();
			n.setValue(value);
			return n;
		} else if (node.getValue() < value) {
			node.setRight(insert(node.getRight(), value));
		} else {
			node.setLeft(insert(node.getLeft(), value));
		}
		return node;
	}

}
