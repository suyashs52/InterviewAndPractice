package pp.m4.tree;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import pp.gu.linkedlist.ListNode;

public class FoldableBinaryTree {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/foldable-binary-tree/1,
		 
		System.out.println(6/-3);
		TreeNode t9 = new TreeNode(9);
		TreeNode t11 = new TreeNode(11);
		TreeNode t7 = new TreeNode(7, t11, null);
		TreeNode t15 = new TreeNode(15, t9, null);
		TreeNode t10 = new TreeNode(10, t7, t15);
		
		//
		System.out.println(IsFoldable(t10));

	}
	static  boolean IsFoldable(TreeNode node) 
		{ 
			// your code 
		//seems like mirror image of null key word
		 boolean is=false;
		 if(node==null) return true;
		 is= checknull(node.left,node.right,true);
		 
		 return is;
		}
	private static boolean checknull(TreeNode left, TreeNode right,boolean isfold) {
		if(isfold==false) return false; 
		
		if(left==null && right==null) {
			return true;
		}
		if(left==null || right==null) {
			return false;
		}
		
		return checknull(left.left, right.right, isfold) && checknull(left.right, right.left, isfold);
		
		
	} 

}
