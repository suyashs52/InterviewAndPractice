package com.udemy.tree;

import java.util.LinkedList;
import java.util.Queue;

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
		//bst level delteion 
		//avl related rotation
		

	}

	private void printTreeGraphically() {
		// TODO Auto-generated method stub

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
		balance = balance(node);

		if (balance > 1) {
			// left has more length so do right rotation
			if (value < node.getLeft().value) { //inserted value is 15
				// value inserted must be left of left of node so rr rotation RR
				//				 50
				//			 25		 null	
				//		 15		35	 
				////////rotate 25 to top , 25 right is 50, 25 right is 50 left
				//			   25
				//			15		50
				//				 35		null
				//		
				return rightRotate(node);
				 

			}else {
				//inserted value is 35 LR CASE
				// value inserted must be right of left of node so left right case rotation
				//rotate last to left then total to right
				//				 50						50			35
				//			 25		 null	--->      35	-->   25	50
				//				35					25
				//	 put left of node to right rotate then right rotate
					node.left=leftRotate(node.left);
				 	return rightRotate(node);
				
			}
		}else if(balance<-1){ //right tree is bigger
			//	inserted value is left/right of right node
			//	if on right
			//	50							60
			//		60			----> 	50		70
			//			70
			if(value>node.getRight().value) {
				//rotate left to balance
				return leftRotate(node);
			}else {
				//if on left ,right of left rl condition
			//	50				rotate left 50						55
			//		60		----> 			   55		-----> 50		60
			//	  55								60
				// put node right to right rotate -- rotate left node
				node.right=rightRotate(node.right);
				return leftRotate(node);
			}
				
			
		}
			   
		return node;
	}

	private int calculateHeight(BinaryNode node) {
		if (node == null)
			return 0;
		else
			return node.height;
	}

	private BinaryNode leftRotate(BinaryNode node) { // right unbalance tree rotate left
	// 20									30
//			 30			----> 		20				40
//		n/25	40					   n/25
		 
		BinaryNode right=node.right;
		BinaryNode temp=right.left;
		right.left=node;
		node.right=temp;
		
		right.height=Math.max(calculateHeight(right.left),calculateHeight(right.right))+1;
		node.height=Math.max(calculateHeight(node.left),calculateHeight(node.right))+1;
		
		return right;
		
		
	}

	private BinaryNode rightRotate(BinaryNode node) {
		// 			20								10
		//		  10			----> 		5				20
		//		5	15					   				15
		BinaryNode left=node.left;
		BinaryNode temp=left.right;
		left.right=node;
		node.left=temp;
		left.height=Math.max(calculateHeight(left.left),calculateHeight(left.right))+1;
		node.height=Math.max(calculateHeight(node.left),calculateHeight(node.right))+1;
		
		return left;
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

	int balance(BinaryNode node) {
		if (node == null)
			return 0;
		else
			return calculateHeight(node.left) - calculateHeight(node.right);

	}
}
