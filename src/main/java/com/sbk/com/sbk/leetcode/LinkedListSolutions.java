package com.sbk.com.sbk.leetcode;

public class LinkedListSolutions {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = new ListNode(0);
        ListNode tempEvenElement = evenHead;
        ListNode tempHead = head;
        ListNode prevTempHead = head;
        while (tempHead != null) {
            if (tempHead.next != null) {
                tempEvenElement.next = tempHead.next;
                tempEvenElement = tempEvenElement.next;
                tempHead.next = tempHead.next.next;
                prevTempHead = tempHead;
                tempHead = tempHead.next;
                tempEvenElement.next = null;
            } else {
                prevTempHead = tempHead;
                tempHead = null;
            }
        }
        prevTempHead.next = evenHead.next;
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = head;
        if (head != null && head.next != null) {
            fakeHead = head.next;
            head.next = swapPairs(fakeHead.next);
            fakeHead.next = head;
        }
        return fakeHead;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int listLength = findLength(head);
        if (k >= listLength) {
            k = k % listLength;
            if(k == 0){
                return head;
            }
        }
        int n = listLength - k;
        ListNode tail = new ListNode(0);
        ListNode nElement = new ListNode(0);
        int elementNum = 1;
        ListNode tempHead = head;
        while(tempHead != null) {
            if(elementNum == n) {
                nElement = tempHead;
            }
            if(tempHead.next == null) {
                tail = tempHead;
            }
            tempHead = tempHead.next;
            elementNum++;

        }
        tail.next = head;
        head = nElement.next;
        nElement.next = null;
        return head;
    }

    public ListNode findTail(ListNode head) {
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public ListNode findPrevTail(ListNode head) {
        ListNode tail = head;
        ListNode prevTail = head;
        while (tail.next != null) {
            prevTail = tail;
            tail = tail.next;
        }
        return prevTail;
    }

    public ListNode findNElement(ListNode head, int N) {
        ListNode nElement = head;
        for (int i = 2; i <= N; i++) {
            nElement = nElement.next;
        }
        return nElement;
    }

    public int findLength(ListNode head) {
        ListNode fakeHead = head;
        int length = 0;
        while (fakeHead != null) {
            fakeHead = fakeHead.next;
            length++;
        }
        return length;
    }

    public String toString(ListNode head) {
        StringBuilder res = new StringBuilder();
        ListNode copyHead = head.copy();
        while (copyHead != null) {
            res.append("(").append(copyHead.val).append(") -> ");
            copyHead = copyHead.next;
        }
        return res.toString();
    }
}
