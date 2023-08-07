package com.leetcode.stack;

import pp.gu.linkedlist.ListNode;

import java.util.Stack;

public class Add2Number {
//https://leetcode.com/problems/add-two-numbers-ii/submissions/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //sum 2 list node , so put them in stack
        //can be solve using reverse a linked list
        Stack<ListNode> one=new Stack<>();
        Stack<ListNode> two=new Stack<>();

        while(l1!=null){
            one.push(l1);
            l1=l1.next;
        }

        while(l2!=null){
            two.push(l2);
            l2=l2.next;
        }
        ListNode finalNode=null; //last node
        int remain=0;
        while(one.isEmpty()==false || two.isEmpty()==false){
            //fetch last element
            int num=remain;
            if(one.isEmpty()==false) num+= one.pop().val;
            if(two.isEmpty()==false) num+= two.pop().val;

            int val=num%10; //it is value
            remain=num/10; //it is remainder that carry in next iteration
            ListNode newNode=new ListNode(val); //init
            newNode.next=finalNode;
            finalNode=newNode; //move pointer 1 move left side


        }

        if(remain>0){ //if still carries remaining
            ListNode node=new ListNode(remain);
            node.next=finalNode;
            finalNode=node;
        }

        return finalNode;
    }
}
