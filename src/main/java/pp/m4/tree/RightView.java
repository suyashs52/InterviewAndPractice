package pp.m4.tree;

// Recursive Java program to reverse
// a linked list
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import pp.gu.linkedlist.ListNode;

public class RightView {

	public static void main(String[] args) throws IOException {
		// https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

		TreeNode t9 = new TreeNode(9);
		TreeNode t11 = new TreeNode(11);
		TreeNode t7 = new TreeNode(7, t11, null);
		TreeNode t15 = new TreeNode(15, t9, null);
		TreeNode t10 = new TreeNode(10, t7, t15);

		//
		System.out.println(rightView(t10));

	}

	static ArrayList<Integer> rightView(TreeNode node) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		max=0;
		if(node==null) return list;
		max=1;
		rightd(node,1, list);
		
		return list;
		
	}
	static int max=0;
	static void rightd(TreeNode node,int level,ArrayList<Integer> list){
		if(node==null) return;
		max=Math.max(level, max);
		if(level==max) { //list.size()<=level so ll add right node after that level ll be equal 
			list.add(node.val); //don't need max param in this case
			max++;
		}
		
		max=Math.max(level, max);
		
		rightd(node.right,level+1,list);
		rightd(node.left,level+1,list);
		
		
	}

}
