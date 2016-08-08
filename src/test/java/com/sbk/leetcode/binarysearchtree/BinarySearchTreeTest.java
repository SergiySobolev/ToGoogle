package com.sbk.leetcode.binarysearchtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void insert() throws Exception {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3,5,7,2,8,1);
        bst.inorder();
    }

}