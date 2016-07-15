package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class SymmetricTreeTest {
    private SymmetricTree st = new SymmetricTree();
    @Test
    public void isSymmetric() throws Exception {
        assertTrue(st.isSymmetric(TreeUtil.toTreeNode(new Integer[]{1,2,2,3,4,4,3})));
        assertFalse(st.isSymmetric(TreeUtil.toTreeNode(new Integer[]{1,2,2,null,3,null,3})));
    }

    @Test
    public void isSymmetricIteratively() throws Exception {
        assertTrue(st.isSymmetricIteratively(TreeUtil.toTreeNode(new Integer[]{1,2,2,3,4,4,3})));
        assertFalse(st.isSymmetricIteratively(TreeUtil.toTreeNode(new Integer[]{1,2,2,null,3,null,3})));
    }

}