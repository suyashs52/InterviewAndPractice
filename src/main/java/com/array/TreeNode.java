package com.array;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.NodeList;

import com.array.SingleLinkedList.ListNode;

public class   TreeNode<T> {
    public T val;
    public   TreeNode left;
    public   TreeNode right;
    TreeNode(T x) { val = x; }
    
    public static void main(String... str) {
    	TreeNode root = new TreeNode<Integer>(1);  
        root.left = new TreeNode(2);  
        root.right = new TreeNode(3);  
        root.left.left = new TreeNode(4);  
        root.left.right = new TreeNode(5);  
        root.right.left = new TreeNode(6);  
        root.right.right = new TreeNode(7);  
        root.left.left.left = new TreeNode(8);  
        root.right.right.left = new TreeNode(9);  
        root.left.left.left.right = new TreeNode(10);  
      
       System.out.println(root.getLeafNodes(root));  

		 
	}
    
    List<Integer> getLeafNodes(TreeNode<Integer> root) {
    	  
    	List<Integer> list= new ArrayList<>();
    	leafNodes(root,list);
    	return (List<Integer>) list;
    	  
    	  
    }
     void leafNodes(TreeNode root,List<Integer> list)  
    {  
        // If node is null, return  
        if (root == null) {
        	 return ;  
        }
           
      
        // If node is leaf node, print its data  
        if (root.left == null && root.right == null)  
        {  
             list.add((Integer) root.val);
             
        }  
      
        // If right child exists, check for leaf  
        // recursively  
        if (root.right != null)  
        	  leafNodes(root.right,list);  
      
        // If left child exists, check for leaf  
        // recursively  
        if (root.left != null)  
        	  leafNodes(root.left,list);
		 
		  
    }  
     
     
     boolean isSymmetrical(TreeNode root) {
    	 /* This allows adding null elements to the queue */
         LinkedList<TreeNode> q = new LinkedList<TreeNode>(); 
   
         /* Initially, add left and right nodes of root */
         q.add(root.left); 
         q.add(root.right); 
   
         while (!q.isEmpty()) 
         { 
             
             TreeNode tempLeft = q.remove(); 
             TreeNode tempRight = q.remove(); 
   
            
             if (tempLeft==null && tempRight==null) 
                 continue; 
   
             
             if ((tempLeft==null && tempRight!=null) || 
                 (tempLeft!=null && tempRight==null)) 
                 return false; 
   
            
             if (tempLeft.val != tempRight.val) 
                 return false; 
   
            
             q.add(tempLeft.left); 
             q.add(tempRight.right); 
             q.add(tempLeft.right); 
             q.add(tempRight.left); 
         } 
   
         /* if the flow reaches here, return true*/
         return true; 
         
         
    	   
     }
}
 
