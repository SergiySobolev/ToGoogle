package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirrorEquals(root.left, root.right);
    }

    public boolean isSymmetricIteratively(TreeNode root) {
        if(root == null) return true;
        return isMirrorEquals(root.left, root.right);
    }

    private boolean isMirrorEquals(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == null && right == null;
        return left.val == right.val
                && isMirrorEquals(left.left, right.right)
                && isMirrorEquals(left.right, right.left);
    }
}
