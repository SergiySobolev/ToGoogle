package com.sbk.leetcode.binarytree;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode step = root;
        TreeNode left = p.val < q.val ? p : q;
        TreeNode right = p.val >= q.val ? p : q;
        while(!(left.val <= step.val)&&(step.val <= right.val)) {
            step = step.val < left.val ? step.right : step.left;
        }
        return step;
    }
}
