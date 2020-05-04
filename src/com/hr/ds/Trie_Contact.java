package com.hr.ds;

import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.events.Characters;

class Trie_Contact {
	static int[] contacts(String[][] queries) {
		int[] output = new int[queries.length];
		Trie_Contact tc = new Trie_Contact();
		int count = 0;
		for (String[] st : queries) {
			printval(st);
			switch (st[0]) {
			case "add":
				tc.add(st[1]);
				break;
			case "find":
				output[count++] = tc.find(st[1]);
				break;
			}
		}
		int[] out = new int[count];
		for (int i = 0; i < count; i++)
			out[i] = output[i];
		return out;

	}

	private int find(String str) {
		// TODO Auto-generated method stub

		Node curr = pnode;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			Node n = curr.node.get(ch);
			if (n == null) {
				return 0;
			}
			curr = n;
		}

		return curr.count;
	}

	Trie_Contact() {
		pnode = new Node();
	}

	void add(String word) {
		Node cur = pnode;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			Node n = cur.node.get(ch);
			if (n == null) {
				n = new Node();

				cur.node.put(ch, n);
			}
			n.count++;
			cur = n;
		}
		cur.isLastNode = true;

	}

	Node pnode;

	class Node {
		Map<Character, Node> node;
		int count;
		boolean isLastNode;

		Node() {
			node = new HashMap<Character, Node>();
			isLastNode = false;
		}
	}

	public static void main(String... str) {
		String[][] queries = new String[][] { { "add", "hack" }, { "add", "heck" }, { "add", "hackerrank" },
				{ "find", "hac" }, { "find", "hak" }, { "find", "hec" } };
		int[] out = contacts(queries);
		printval(out);

	}

	static void printval(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ",");
		System.out.println();
	}

	static void printval(Object[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ",");
		System.out.println();
	}
}
