package com.array;

import java.util.Stack;;
 

public class ReverseStack {
	
	
	public static void main(String ...str) {
		
		Stack<Integer> st=new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		System.out.println(st);
		ReverseStack rs=new ReverseStack();
		rs.reverseStack(st);
		System.out.println(st);
		
	}
	
	
	void reverseStack(Stack<Integer> stack) {
        // homework
		if(stack.size()>0) {
			Integer i=stack.peek();
			stack.pop(); // 5 ,4 ,3,2, 1 pop
			reverseStack(stack);
			insert(i,stack);
		}
		
		
    }
	
	static void insert(Integer i,Stack<Integer> stack) {
		if(stack.isEmpty()) {
			stack.push(i);
		}else {
			Integer j=stack.peek();
			stack.pop();
			insert(i,stack);
			stack.push(j);
			
		}
	}
	
	
}
