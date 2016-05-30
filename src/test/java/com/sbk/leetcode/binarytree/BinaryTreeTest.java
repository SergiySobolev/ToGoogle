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
        binaryTreePaths =  b.binaryTreePaths(null);
        expected = new String[]{};
        assertThat(binaryTreePaths, containsInAnyOrder(expected));
    }

}