package com.sbk.leetcode.binarytree;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.*;

public class BinaryTreeTest {

    @Test
    public void binaryTreePathsTest() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, null));
        BinaryTreePath b = new BinaryTreePath();
        List<String> binaryTreePaths =  b.binaryTreePaths(root);
        String[] expected = {"1->2->5", "1->3"};
        assertThat(binaryTreePaths, containsInAnyOrder(expected));
        binaryTreePaths =  b.binaryTreePaths(null);
        expected = new String[]{};
        assertThat(binaryTreePaths, containsInAnyOrder(expected));
    }

    @Test
    public void lowestCommonAncestorTest() {
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_5 = new TreeNode(5);
        TreeNode treeNode_2 = new TreeNode(2, treeNode_1, null);
        TreeNode root = new TreeNode(3, treeNode_2,  treeNode_5);
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode answer = l.lowestCommonAncestor(root, treeNode_1, treeNode_5);
        assertThat(answer.val, equalTo(root.val));
    }

}