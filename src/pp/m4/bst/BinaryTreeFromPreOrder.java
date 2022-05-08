package pp.m4.bst;

import java.io.IOException;
import java.util.Stack;

public class BinaryTreeFromPreOrder {

	public static void main(String[] args) throws IOException {
		// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

		System.out.println(bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 }));

	}

	public static TreeNode bstFromPreorder(int[] preorder) {

		if (preorder.length == 0)
			return null;

		TreeNode node = null;

		// add next greater element
		Stack<Integer> st = new Stack<>();
		int[] nge = new int[preorder.length];

	 
st.push(0);
		for (int i = 1; i < preorder.length; i++) {
			if (preorder[i] < preorder[st.peek()]) {
				st.push(i);
			} else {
				while (st.isEmpty() == false && preorder[st.peek()] < preorder[i]) {
					nge[st.pop()] = i;
				}
				st.push(i);
			}
		}
		while (st.isEmpty() == false) { // no next larger value
			nge[st.pop()] = preorder.length;

		}
		
		
		node=bst(preorder,nge,0,preorder.length);

		return node;

	}
	

	private static TreeNode bst(int[] preorder, int[] nge,int index,int end) {
		 if(index==preorder.length) return null;
		 if(index>end) return null;
		TreeNode n=new TreeNode(preorder[index]);
		
		n.left=bst(preorder,nge,index+1,nge[index]-1); //5, 1, 7 in 8, 5, 1, 7, 10, 12 first time
		n.right=bst(preorder,nge,nge[index],end);
		
		return n;
	}

}
