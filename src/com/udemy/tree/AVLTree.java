package com.udemy.tree;

public class AVLTree {
	BinaryNode root;

	public BinaryNode getRoot() {
		return root;
	}

	AVLTree() {
		root = null;
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(30);

		tree.insert(10);
		tree.insert(5);
		tree.insert(3);
		tree.insert(4);
		tree.insert(50);
		tree.insert(65);
		tree.insert(1);
		tree.levelOrderTraversal();
		tree.printTreeGraphically();

		tree.deleteNodeOfBST(5);// LL Condition
		tree.printTreeGraphically();

		tree.insert(2);
		tree.printTreeGraphically();

		tree.deleteNodeOfBST(4);// LR Condition
		tree.printTreeGraphically();

		tree.insert(20);
		tree.deleteNodeOfBST(65);// RR Condition
		tree.printTreeGraphically();

		tree.insert(40);
		tree.deleteNodeOfBST(20);// RL Condition
		tree.printTreeGraphically();
	}

	private void deleteNodeOfBST(int i) {
		// TODO Auto-generated method stub

	}

	private void printTreeGraphically() {
		// TODO Auto-generated method stub

	}

	private void levelOrderTraversal() {
		// TODO Auto-generated method stub

	}

	private void insert(int value) {
		root = insert(root, value);
	}

	private BinaryNode insert(BinaryNode node, int value) {

		if (node == null) {
			node = new BinaryNode();
			node.setValue(value);
			node.setHeight(0);// node is always leaf node
			return node;
		} else if (value <= node.getValue()) {
			node.setLeft(insert(node.getLeft(), value));
		} else {
			node.setRight(insert(node.getRight(), value));
		}
		// avl property

		int balance = checkBalance(node.getLeft(), node.getRight());

		if (balance > 1) {

		}
	}

	private int checkBalance(BinaryNode left, BinaryNode right) {
		if (left == null && right == null) { // current node is leaf node
			return 0;
		} else if (left == null) {
			return -1 * (right.getHeight() + 1);
		} else if (right == null) {
			return left.getHeight() + 1;
		} else {
			return left.getHeight() - right.getHeight();
		}
		 
	}
}
