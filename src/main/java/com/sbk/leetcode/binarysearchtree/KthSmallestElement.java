package com.sbk.leetcode.binarysearchtree;

import com.sbk.leetcode.binarytree.TreeNode;

public class KthSmallestElement {
    public int kthSmallest(TreeNode r, int k) {
            if (r != null) {
                inorderRec(r.left, k);
                System.out.println(r.val);
                inorderRec(r.right, k);
            }
            return -1;
    }

    private void inorderRec(TreeNode left, int elementToFind) {

    }
}
