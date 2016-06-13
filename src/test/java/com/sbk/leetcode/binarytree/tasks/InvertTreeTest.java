package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;
import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvertTreeTest {
    Integer[] input;
    InvertTree invertTree = new InvertTree();

    @Test
    public void invertTree1() throws Exception {
        input = new Integer[]{4, 2, 7, 1, 3, 6, 9};
        TreeNode answer = invertTree.invertTree(TreeUtil.toTreeNode(input));
        assertEquals(answer.val, 4);
        assertEquals(answer.left.val, 7);
        assertEquals(answer.right.val, 2);
        assertEquals(answer.left.left.val, 9);
        assertEquals(answer.left.right.val, 6);
        assertEquals(answer.right.right.val, 1);
        assertEquals(answer.right.left.val, 3);
    }

    @Test
    public void invertTree2() throws Exception {
        input = new Integer[]{4, 2, 7};
        TreeNode answer = invertTree.invertTree(TreeUtil.toTreeNode(input));
        assertEquals(answer.val, 4);
        assertEquals(answer.left.val, 7);
        assertEquals(answer.right.val, 2);
    }

}