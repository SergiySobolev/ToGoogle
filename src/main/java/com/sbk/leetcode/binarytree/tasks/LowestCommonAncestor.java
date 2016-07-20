package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(canBeReached(root.left, p) && canBeReached(root.left, q))
            return lowestCommonAncestor(root.left, p, q);
        if(canBeReached(root.right, p) && canBeReached(root.right, q))
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public boolean canBeReached(TreeNode from, TreeNode to){
        if(from == null) return false;
        if(from == to) return true;
        return canBeReached(from.left, to) || canBeReached(from.right, to);
    }

}
