package pp.gu.linkedlist;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode prev;
	public ListNode bottom;
	public ListNode random;
	public ListNode child;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}