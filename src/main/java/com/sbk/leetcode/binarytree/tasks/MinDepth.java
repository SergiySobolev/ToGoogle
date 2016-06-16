package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        return Math.min(rightDepth, leftDepth) + 1;
    }

}
