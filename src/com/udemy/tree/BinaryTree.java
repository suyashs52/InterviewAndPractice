package com.udemy.tree;

public class BinaryTree {
	int[] arr;
	int lastUsedIndex;

	public BinaryTree(int i) {
		arr = new int[i + 1];
		lastUsedIndex = 0;
	}

	public static void main(String... ar) {
		BinaryTree tree = new BinaryTree(10);

		System.out.println("inserting 10 values in the tree");

		for (int i = 0; i < 10; i++) {
			tree.insert(i * 10);
		}

		System.out.println("level order traversal");
		tree.levelorder();

		System.out.println("\n pre order traversal");
		tree.preorder(1);

		System.out.println("\n post order");
		tree.postorder(1);

		System.out.println("\n in order");
		tree.inorder(1);

		System.out.println("\n search for 500 in tree");
		tree.search(500);

		System.out.println("\n search for 40");
		tree.search(40);

		System.out.println("\n deleting node 500 from the tree");
		tree.delete(500);

		System.out.println("\n deleting 40 from the tree");
		tree.delete(40);

		System.out.println("\n level order traversal");
		tree.levelorder();

		System.out.println("\n deleteing entire tree");

		tree.deleteTree();

	}

	private void deleteTree() {
		if (arr != null)
			arr = null;

	}

	private void delete(int val) {
		int loc = search(val);
		if (loc == -1) {
			System.out.println("not delete");
		} else {
			arr[loc] = arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("successfull deleted at loc" + loc);
		}

	}

	private int search(int val) {
		for (int i = 0; i < lastUsedIndex; i++) {
			if (arr[i] == val) {
				System.out.print("search value is" + val);
				return i;
			}
		}
		System.out.println("not search found for val " + val);
		return -1;

	}

	private void inorder(int i) {
		// left data right
		if (i > lastUsedIndex) {
			return;
		}
		inorder(i * 2);

		System.out.print(arr[i] + " ");
		inorder(i * 2 + 1);
	}

	private void postorder(int i) {
		// left right data;
		if (i > lastUsedIndex) {
			return;
		}
		postorder(i * 2);
		postorder(i * 2 + 1);
		System.out.print(arr[i] + " ");

	}

	private void preorder(int i) {
		// data left right
		if (i > lastUsedIndex) {
			return;
		}
		System.out.print(arr[i] + " ");
		preorder(i * 2);
		preorder(i * 2 + 1);

	}

	private void levelorder() {
		for (int i = 0; i < lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	private void insert(int i) {
		if (arr.length - 1 == lastUsedIndex) {

		} else {
			arr[lastUsedIndex++] = i;
		}

	}

}
