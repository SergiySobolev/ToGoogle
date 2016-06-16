package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

class InvertTree {
    TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        boolean childrenAreNull = root.left == null && root.right == null;
        if(childrenAreNull) return root;
        TreeNode invertRight = invertTree(root.right);
        TreeNode invertLeft = invertTree(root.left);
        root.left = invertRight;
        root.right = invertLeft;
        return root;
    }
}
