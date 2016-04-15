package com.sbk.com.sbk.leetcode;

import org.junit.Before;
import org.junit.Test;

import static java.util.Objects.isNull;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by ssobolev on 1/19/2016.
 */
public class LinkedListSolutionsTest {

    ListNode testNode1;
    ListNode testNode2;
    ListNode testNode3;
    LinkedListSolutions sol;

    @Before
    public void setUp() {
        sol = new LinkedListSolutions();
        testNode1 = new ListNode(1);
        testNode1.next = new ListNode(2);
        testNode1.next.next = new ListNode(3);
        testNode1.next.next.next = new ListNode(4);
        testNode1.next.next.next.next = new ListNode(5);
        testNode1.next.next.next.next.next = new ListNode(6);

        testNode2 = new ListNode(1);
        testNode2.next = new ListNode(2);
        testNode2.next.next = new ListNode(3);

        testNode3 = new ListNode(1);
        testNode3.next = new ListNode(2);
        testNode3.next.next = new ListNode(3);
        testNode3.next.next.next = new ListNode(4);
    }

    @Test
    public void testOddEvenList() throws Exception {
        ListNode resNode = sol.oddEvenList(testNode1);
        assertThat(resNode.next.val, equalTo(3));
        assertThat(resNode.next.next.val, equalTo(5));
        assertThat(resNode.next.next.next.val, equalTo(2));
        System.out.println(sol.toString(resNode));
    }

    @Test
    public void testOddEvenList2() throws Exception {
        ListNode resNode = sol.oddEvenList(testNode2);
        System.out.println(sol.toString(testNode2));
        assertThat(resNode.next.val, equalTo(3));
        assertThat(resNode.next.next.val, equalTo(2));
        assertThat(isNull(resNode.next.next.next), equalTo(true));
    }

    @Test
    public void testSwapPairs() throws Exception {
        ListNode resNode = sol.swapPairs(testNode3);
        assertThat(resNode.val, equalTo(2));
        assertThat(resNode.next.val, equalTo(1));
        assertThat(resNode.next.next.val, equalTo(4));
        assertThat(resNode.next.next.next.val, equalTo(3));
    }

    @Test
    public void testRotateRight() throws Exception {
        assertThat(sol.rotateRight(new ListNode(0, null), 0).val, equalTo(0));
        assertThat(sol.rotateRight(new ListNode(0, new ListNode(1)), 0).val, equalTo(0));
        assertThat(sol.rotateRight(testNode1, 2).val, equalTo(5));
        assertThat(sol.rotateRight(testNode2, 2).val, equalTo(2));

    }

    @Test
    public void testFindLength() throws Exception {
        assertThat(sol.findLength(testNode1), equalTo(6));
        assertThat(sol.findLength(testNode2), equalTo(3));
    }

    @Test
    public void testFindPrevTail() throws Exception {
        assertThat(sol.findPrevTail(testNode1).val, equalTo(5));
    }
}