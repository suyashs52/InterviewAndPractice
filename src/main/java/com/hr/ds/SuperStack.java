package com.hr.ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

public class SuperStack {

	static void superStack(String[] operations) {
		if (operations == null || operations.length == 0) {
			System.out.println("EMPTY");
			return;
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < operations.length; i++) {
			String current = operations[i];
			if (current.equals("pop")) {
				list.removeLast();
			} else {
				if (current.startsWith("push")) {
					list.addLast(Integer.parseInt(current.split(" ")[1]));
				} else {
					int e = Integer.parseInt(current.split(" ")[1]);
					int k = Integer.parseInt(current.split(" ")[2]);
					ListIterator<Integer> listIterator = list.listIterator();
					int j = 1;
					while (listIterator.hasNext()) {
						if (j > e)
							break;
						listIterator.set(listIterator.next() + k);
						j++;
					}
				}
			}
			if (list.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(list.getLast());
		}
	}

	static void PrintTop(LinkedList<Integer> stack) {
		if (stack.size() == 0) {
			System.out.println("EMPTY");
		} else {
			System.out.println(stack.getFirst());
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int operations_size = 0;
		operations_size = Integer.parseInt(in.nextLine().trim());

		String[] operations = new String[operations_size];
		for (int i = 0; i < operations_size; i++) {
			String operations_item;
			try {
				operations_item = in.nextLine();
			} catch (Exception e) {
				operations_item = null;
			}
			operations[i] = operations_item;
		}

		superStack(operations);
	}

	static class Node {
		Integer data;
		Node prev;
		Node next;
	}

	static class st {
		Integer size = 10;
		Integer[] str;
		Integer ptr = 0;
		Node root;
		Node rootl;

		st() {
			str = new Integer[size];
		}

		Integer peak() {
			if (rootl == null)
				return null;
//			if (ptr <= 0)
//				return null;
//			else
			return rootl.data;// str[ptr - 1];
		}

		Integer pop() {
			if (ptr == 0)
				return null;
			if (root == rootl) {
				root = null;
				rootl = null;
				return null;
			}
			--ptr;
			Integer t = rootl.data;// str[--ptr];

			rootl = rootl.prev;
			// str[ptr] = null;
			return t;
		}

		Integer push(Integer s) {

			if (root == null) {
				root = new Node();
				root.data = s;
				rootl = root;
			} else {
//				Node temp=root;
//				Node ptemp=root;
//				while(temp!=rootl) {
//					ptemp=temp;
//					temp=ptemp.next;
//				}

				Node n = new Node();
				n.data = s;
				n.prev = rootl;
				rootl.next = n;
				rootl = n;

			}
			ptr++;
			// str[ptr++] = s;
			return s;
		}

		Integer inc(Integer s, Integer j) {
			int t = ptr;
			Node temp = root;
			for (int i = 0; i < s; i++) {
				temp.data += j;
				temp = temp.next;
				// str[i] += j;
			}
			return peak();

		}

		private void increase() {
			// TODO Auto-generated method stub
			Integer ne = str.length * 2;
			str = Arrays.copyOf(str, ne);

		}

	}

}
