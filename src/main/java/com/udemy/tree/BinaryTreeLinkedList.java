package com.udemy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLinkedList {
	BinaryNode root;

	BinaryTreeLinkedList() {
		this.root = null;
	}

	public static void main(String[] args) {
		//check deletelastnode
		BinaryTreeLinkedList tree = new BinaryTreeLinkedList();
		System.out.println("Inserting 10 nodes to tree");
		for (int i = 1; i <= 10; i++)
			tree.insert(i * 10);

		System.out.println("\nLevel-order of tree:");
		tree.levelOrder();
		System.out.println();

		System.out.println("\nPre-order of tree:");
		tree.preOrder(tree.root);
		System.out.println();

		System.out.println("\nPost-order of tree:");
		tree.postOrder(tree.root);
		System.out.println();

		System.out.println("\nIn-order of tree:");
		tree.inOrder(tree.root);
		System.out.println();

		System.out.println("\nSearching node 50 in the tree...");
		tree.search(50);

		System.out.println("\nSearching node 500 in the tree...");
		tree.search(500);

		System.out.println("\nDeleting node having value-5 in the tree...");
		tree.deleteNodeOfBinaryTree(5);

		System.out.println("\nDeleting node having value-50 in the tree...");
		tree.deleteNodeOfBinaryTree(50);
		tree.levelOrder();

		System.out.println("\n\nDeleting node having value-10 in the tree...");
		tree.deleteNodeOfBinaryTree(10);
		tree.levelOrder();

		System.out.println("\n\nDeleting node having value-80 in the tree...");
		tree.deleteNodeOfBinaryTree(80);
		tree.levelOrder();

		System.out.println("Deleting the entire Tree");
		tree.deleteTree();

	}

	private void deleteTree() {
		if (root != null)
			root = null;

	}

	private void deleteNodeOfBinaryTree(int value) {

		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (queue.isEmpty() == false) {
			BinaryNode present = queue.remove();
			if (present.getValue() == value) {
				//get last node replace it with deleted node
				present.setValue(getLastNode().getValue());
				DeleteLastNode();
				System.out.print("last node deleted");
				return;
			} else {
				if (present.getLeft() != null) {
					queue.add(present.getLeft());

				}
				if (present.getRight() != null) {
					queue.add(present.getRight());

				}
			}
		}

		System.out.println("did not find the node!!");

	}

	public BinaryNode getLastNode() {
		// travel level order reutnr last node
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode present = root;
		while (queue.isEmpty() == false) {
			present = queue.remove();
			if (present.getLeft() != null)
				queue.add(present.left);
			if (present.getRight() != null) {
				queue.add(present.getRight());
			}
		}
		return present;

	}

	public void DeleteLastNode() {
		// travel level order pick right most delete it
				// when last node parent has leftchild
		//it means right is null so delete left 
		// if it has right child means it has both child, previs node has left right value
		// delete right of previous as 
		//		10
		//	20		30
		//40	50
		//inorder is 10 20 30 40 50 , , prev is 20 , 30 left is null delete 20 right ie 50
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previous, present = null;
		while (!queue.isEmpty()) {
			previous = present;
			present = queue.remove();
			if (present.getLeft() == null) {
				previous.setRight(null);
				return;
			} else if (present.getRight() == null) {
				present.setLeft(null); 
				return;
			}
			queue.add(present.getLeft());
			queue.add(present.getRight());

		}

	}

	private void search(int value) {

		if (root.getValue() == value) {
			System.out.println("value found is" + value);
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getValue() == value) {
				System.out.println("Value-" + value + " is found in Tree !");
				return;
			} else {
				if (presentNode.getLeft() != null)
					queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		} // end of loop
		System.out.println("Value-" + value + " is not found in Tree !");

	}

	private void inOrder(BinaryNode root2) {
		// TODO Auto-generated method stub
		if (root2 == null)
			return;
		inOrder(root2.getLeft());
		System.out.print(root2.getValue() + " ");
		inOrder(root2.getRight());

	}

	private void postOrder(BinaryNode root2) {
		if (root2 == null)
			return;
		postOrder(root2.getLeft());
		postOrder(root2.getRight());
		System.out.print(root2.getValue() + " ");

	}

	private void preOrder(BinaryNode root2) {
		// TODO Auto-generated method stub

	}

	private void levelOrder() {
		// TODO Auto-generated method stub

		// make a queue for level order. Queue is Interface and LinkedList is class
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null) {
				queue.add(presentNode.getLeft());
			}
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
	}

	private void insert(int i) {
		BinaryNode node = new BinaryNode();
		node.setValue(i);

		if (root == null) {
			root = node;
			return;
		}
		// can't use recursion as it always insert at left
		// do level order traversal and insert
		// need queue
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (queue.isEmpty() == false) {
			BinaryNode preset = queue.remove();
			if (preset.getLeft() == null) {
				preset.setLeft(node);
				break;

			} else if (preset.getRight() == null) {
				preset.setRight(node);
				break;
			} else {
				queue.add(preset.left);
				queue.add(preset.right);
			}
		}

	}

}
