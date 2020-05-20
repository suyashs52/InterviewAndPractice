package com.udemy.tree;

public class BinarySearchTreeLinked {

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
		
	}

	private void deleteNodeOfBST(int i) {
		// TODO Auto-generated method stub
		
	}

	private void searchForValue(int i) {
		// TODO Auto-generated method stub
		
	}

	private void printTreeGraphically() {
		// TODO Auto-generated method stub
		
	}

	private void insert(int i) {
		// TODO Auto-generated method stub
		
	}

}
