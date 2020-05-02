package com.udemy;

import java.util.HashMap;
import java.util.Map;

public class Trie {
  
  public static void main(String ... args){
    System.out.println("test");
  }

	// has flag to show last char of word
	// root node
	// link to child
	// list to char and next node

	class Node {
		Node() {
			node = new HashMap<Character, Trie.Node>();
			isLastNode = false;
		}

		boolean isLastNode;

		Map<Character, Node> node;

	}

	Node pnode;

	Trie() {
		pnode = new Node();
	}

	public void insert(String word) {
		Node current = pnode;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			Node cnode = current.node.get(ch);
			if (cnode == null) {
				cnode = new Node();
				current.node.put(ch, cnode);
			}

			current = cnode;
		}
		current.isLastNode = true;
		System.out.println("inserted " + word + " in Trie !");
	}

	public boolean search(String word) {
		Node current = pnode;
		for (int i = 0; i < word.length(); i++) {
			Node n = current.node.get(word.charAt(i));
			if (n == null) {
				System.out.println(word + " not exists");
				return false;
			}
			current = n;
		}
		if (current.isLastNode == false) {
			System.out.println(word + " prefix exists");
		} else {
			System.out.println(word + " exists");
		}
		return current.isLastNode;
	}

	public void delete(String word) {
		if (search(word)) {
			delete(pnode, word, 0);
		}
	}

	private boolean delete(Node current, String word, int i) {
		// bcdf , bcef
		// if reach to c
		// so it has 2 dependency so go to next
		Node c = current.node.get(word.charAt(i));
		if (c.node.size() > 1) {
			delete(c, word, i + 1);
			return false;
		}

		if (i == word.length() - 1) {
			// bcde, bcdefg
			// we reach at e deleted word bcde
			if (c.node.size() > 0) {
				c.isLastNode = false;
				return false;
			} else {
				// there is no child node it means can be delted only bcde present
				System.out.println("removing char " + i + " from word: " + word);
				current.node.remove(word.charAt(i));
				return true;
			}

		}

		// want to delete bcde and reach to bc , bcde , bc
		if (c.isLastNode == true) { // has one child, length !word.length-1
			delete(c, word, i + 1);
			return false;
		}

		boolean canDeleteWord = delete(c, word, i + 1); //bcde char is d
		if(canDeleteWord) {
			current.node.remove(word.charAt(i));
			return true;
		}else {
			return false;
		}

	}
}
