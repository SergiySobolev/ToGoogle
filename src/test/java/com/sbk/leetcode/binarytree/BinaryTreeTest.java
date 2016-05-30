package com.sbk.leetcode.binarytree;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

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

    }

    @Test
    public void appendPathsToNodeTest() {
        BinaryTreePath b = new BinaryTreePath();
        List<String> appendedPaths = b.appendPathsToNode(new TreeNode(1,null, null),
                asList("2", "3->4", "5->6"));
        String[] expected = {"1->2", "1->3->4", "1->5->6"};
        assertThat(appendedPaths, containsInAnyOrder(expected));
    }


}