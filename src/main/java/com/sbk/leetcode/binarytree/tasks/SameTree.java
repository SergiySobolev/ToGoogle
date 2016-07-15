package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

import java.util.Objects;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return Objects.equals(p.val, q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
