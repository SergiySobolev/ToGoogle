package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            boolean moreThanPAndQ = p.val < root.val && root.val > q.val;
            boolean lessThanPAndQ = p.val > root.val && root.val < q.val;
            if (moreThanPAndQ) {
                root = root.left;
            } else if (lessThanPAndQ) {
                root = root.right;
            } else return root;
        }
        return null;
    }

}
