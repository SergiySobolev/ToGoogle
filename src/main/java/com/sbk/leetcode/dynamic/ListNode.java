package com.sbk.leetcode.dynamic;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }


    public ListNode copy() {
        return new ListNode(this.val, this.next);
    }
}
