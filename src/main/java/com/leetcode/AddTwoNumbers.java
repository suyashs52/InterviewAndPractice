package com.leetcode;

import pp.gu.linkedlist.ListNode;

public class AddTwoNumbers {

    public static void main(String... str) {

        //https://leetcode.com/problems/add-two-numbers-ii/

        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4, n3);
        ListNode n2 = new ListNode(2, n4);
        ListNode n7 = new ListNode(7, n2);

        ListNode n14 = new ListNode(4);
        ListNode n16 = new ListNode(6, n14);
        ListNode n15 = new ListNode(5, n16);

        System.out.println(addTwoNumbers(n7, n15));

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);



        int lcount = 0;
        ListNode fl1 = l1;
        ListNode sl2 = l2;
        while (l1 != null) {
            l1 = l1.next;
            lcount++;
        }
        int rcount = 0;
        while (l2 != null) {
            l2 = l2.next;
            rcount++;
        }
        l1 = fl1;
        l2 = sl2;

        if (lcount > rcount) {
            int diff = lcount - rcount;
            while (diff > 0) {
                l1 = l1.next;
                diff--;
            }
        }

        if (rcount > lcount) {
            int diff = rcount - lcount;
            while (diff > 0) {
                l2 = l2.next;
                diff--;
            }
        }

        ListNode node = dfs(dummyNode, l1, l2);
		l1 = fl1;
		l2 = sl2;
        if (lcount > rcount) {
			node=  dfs(l1, lcount - rcount);
        } else if (rcount > lcount) {

			node=  dfs(l2, rcount - lcount);

        }
		if(node.val >10) {
			dummyNode.next=node;
			dummyNode.val =1;
			node.val =node.val %10;
			return  dummyNode;
		}




        return node;
    }


    private static ListNode dfs(ListNode node, int count) {
        if (count == 0) return node;
        ListNode lnode = dfs(node.next, count - 1);
        int tval = node.val;
        if (lnode != null) {
            int value = lnode.val;
            if (value > 10) {
                node.val = tval + 1;
                lnode.val = node.next.val % 10;
            }
        }
		return  node;

    }

    private static ListNode dfs(ListNode dummyNode, ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode node = new ListNode(0);
        node.next = dfs(dummyNode, l1.next, l2.next);
        int tval = l1.val + l2.val;
        node.val = tval;
        if (node.next != null) {
            int value = node.next.val;
            if (value > 10) {
                node.val = tval + 1;
                node.next.val = node.next.val % 10;
            }
        }
        return node;

    }

}
