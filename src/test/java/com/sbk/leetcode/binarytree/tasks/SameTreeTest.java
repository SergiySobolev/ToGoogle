package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;
import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SameTreeTest {
    private SameTree st = new SameTree();

    @Test
    public void isSameTree() {
        TreeNode p = TreeUtil.toTreeNode(new Integer[]{1,2,2,3,4,4,3});
        TreeNode q = TreeUtil.toTreeNode(new Integer[]{1,2,2,3,4,4,3});
        assertTrue(st.isSameTree(p, q));
        assertFalse(st.isSameTree(p, new TreeNode(0)));
    }
}
