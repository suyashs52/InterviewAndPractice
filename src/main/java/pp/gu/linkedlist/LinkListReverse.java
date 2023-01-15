package pp.gu.linkedlist;
// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class LinkListReverse {
	
	/* Link list node */
	static class Node {
		public int data;
		public Node next;

		public Node(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class LinkedList {
		public Node head;

		public LinkedList() {
			this.head = null;
		}

		public void insertNode(int nodeData) {
			Node node = new Node(nodeData);

			if (this.head != null) {
				node.next = head;
			}
			this.head = node;
		}
	}

	/* Function to print linked list */
	public static void printSinglyLinkedList(Node node,
						String sep) throws IOException {
		while (node != null) {
			System.out.print(String.valueOf(node.data) + sep);
			node = node.next;
		}
	}

	// Complete the reverse function below.
	static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}

		// last node or only one node
		 

		Node newHeadNode = reverse(head.next); //it ll point to last node
		//we are not changing newhead once we received 
		//in stack all old node ll call after this

		// change references for middle chain
		head.next.next = head;
		head.next = null;

		// send back new head node in every recursion
		return newHeadNode;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
			LinkedList llist = new LinkedList();
		
			llist.insertNode(20);
			llist.insertNode(4);
			llist.insertNode(15);
			llist.insertNode(85);
			
			System.out.println("Given linked list:");
			printSinglyLinkedList(llist.head, " ");
			
			System.out.println();
			System.out.println("Reversed Linked list:");
			Node llist1 = reverse(llist.head);
			printSinglyLinkedList(llist1, " ");

		scanner.close();
	}
}
