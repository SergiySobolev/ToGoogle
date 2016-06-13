package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        boolean childrenAreNull = root.left == null && root.right == null;
        if(childrenAreNull) return root;
        TreeNode invertRight = invertTree(root.right);
        TreeNode invertLeft = invertTree(root.left);
        root.left = invertRight;
        root.right = invertLeft;
        return root;
    }
}
