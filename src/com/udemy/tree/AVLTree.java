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
			node.setHeight(1);// node is always leaf node
			return node;
		} else if (value <= node.getValue()) {
			node.setLeft(insert(node.getLeft(), value));
		} else {
			node.setRight(insert(node.getRight(), value));
		}
		// avl property

		int balance = checkBalance(node.getLeft(), node.getRight());
		// there are at most 2 node of a node
		// disbalance due to right node right node LL rotation
		// right node left node rotate right last then rotate left all LR roation
		// check below function left node is smaller then node>right node so rotate as
		// left is top ,
		// right node is right of left now right right imblance so rotete left
		// disbalance due to Left subtree than rotate right, left left/ left right node
		// left left do RR rotation, left right do RL roation

		node.height = 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));

		if (balance > 1) {

			if (checkBalance(node.getLeft().getLeft(), node.getLeft().getRight()) > 0) {
				// LL condition
				node = rightRotate(node);
			} else {
				// LR rotation
				// right imblanace tree , left rotation
				node.setLeft(leftRotate(node.getLeft()));
				node = rightRotate(node);
			}

		} else if (balance < -1) {
			// right
			// rr
			if (checkBalance(node.getRight().getRight(), node.getRight().getLeft()) > 0) {
				node = leftRotate(node);
			} else {
				// rl
				node.setRight(rightRotate(node.getRight()));
				node = leftRotate(node);
			}
		}
		if (node.getLeft() != null) {
			node.getLeft().setHeight(calculateHeight(node.getLeft()));
		}
		if (node.getRight() != null) {
			node.getRight().setHeight(calculateHeight(node.getRight()));
		}
		node.setHeight(calculateHeight(node));
		return node;
	}

	private int calculateHeight(BinaryNode node) {
		if (node == null)
			return 0;
		else
			return node.height;
	}

	private BinaryNode leftRotate(BinaryNode node) { // right unbalance tree rotate left
		// -1 -10- +1=+2
		// null 15
		// 12 16
		// 10 right set to 12,15 left set to 10
		//
		// 15
		// 10 16
		// null 12
		BinaryNode root = node.getRight();
		node.setRight(node.getRight().getLeft());
		root.setLeft(node);
		node.setHeight(calculateHeight(node));
		root.setHeight(calculateHeight(root));
		return root;
	}

	private BinaryNode rightRotate(BinaryNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	private int checkBalance(BinaryNode left, BinaryNode right) {
		if (left == null && right == null) { // current node is leaf node
			return 0;
		} else if (left == null) { // only right node +1 due to blank node is -1;
			return -1 * (right.getHeight() + 1);
		} else if (right == null) {
			return left.getHeight() + 1;
		} else {
			return left.getHeight() - right.getHeight();
		}

	}
}
