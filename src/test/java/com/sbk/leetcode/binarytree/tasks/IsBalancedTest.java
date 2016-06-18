package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class IsBalancedTest {
    IsBalanced ib = new IsBalanced();
    @Test
    public void isBalanced() throws Exception {
        assertTrue(ib.isBalanced(TreeUtil.toTreeNode(new Integer[]{})));
        assertTrue(ib.isBalanced(TreeUtil.toTreeNode(new Integer[]{1})));
        assertTrue(ib.isBalanced(TreeUtil.toTreeNode(new Integer[]{1,2})));
        assertTrue(ib.isBalanced(TreeUtil.toTreeNode(new Integer[]{1,2,3})));
        assertTrue(ib.isBalanced(TreeUtil.toTreeNode(new Integer[]{1,2,3,4})));
        assertFalse(ib.isBalanced(TreeUtil.toTreeNode(new Integer[]{1,2,null,4})));
    }

}