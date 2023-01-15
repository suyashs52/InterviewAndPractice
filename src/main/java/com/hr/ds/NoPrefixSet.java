package com.hr.ds;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoPrefixSet {

	static String[] contacts(String[] queries) {
		String[] str = new String[1];
		str[0] = "GOOD SET";
		NoPrefixSet tc = new NoPrefixSet();
		for (int i = 0; i < queries.length; i++) {
			if (!tc.add(queries[i])) {
				str = new String[2];
				str[0] = "BAD SET";
				str[1] = queries[i];
				break;
			}
		}

		return str;

	}

	NoPrefixSet() {
		pnode = new Node();
	}

	boolean add(String word) {
		Node cur = pnode;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			Node n = cur.node.get(ch);
			if (n == null) {
				n = new Node();

				cur.node.put(ch, n);
			}
			n.count++;
			if (n.isLastNode) {
				return false;
			}
			cur = n;

		}
		if (cur.node.size() > 0) {
			return false;
		}
		cur.isLastNode = true;
		return true;

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

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));// new BufferedWriter(new
																								// FileWriter(System.getenv("OUTPUT_PATH")));

		int queriesRows = Integer.parseInt(scanner.nextLine().trim());

		String[] queries = new String[queriesRows];

		for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {

			queries[queriesRowItr] = scanner.nextLine();

		}

		String[] result = contacts(queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			bufferedWriter.write("\n");

		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
