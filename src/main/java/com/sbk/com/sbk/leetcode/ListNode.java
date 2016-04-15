package com.sbk.com.sbk.leetcode;

public class ListNode {
    int val;
    ListNode next;

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
