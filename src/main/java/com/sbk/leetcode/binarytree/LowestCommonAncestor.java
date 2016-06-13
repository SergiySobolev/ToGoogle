package com.sbk.leetcode.binarytree;

class LowestCommonAncestor {

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null){
            return null;
        }
        if(isDescendant(p,q)) {
            return p;
        }
        if(isDescendant(q,p)) {
            return q;
        }
        boolean onDifferentSides = (root.val < p.val && q.val < root.val) || (p.val < root.val && q.val > root.val);
        if (onDifferentSides)
            return root;

        boolean bothOnTheLeftSide = p.val < root.val && q.val < root.val;
        if (bothOnTheLeftSide)
            return lowestCommonAncestor(root.left, p, q);

        boolean bothOnTheRightSide = p.val > root.val && q.val > root.val;
        if (bothOnTheRightSide)
            return lowestCommonAncestor(root.right, p, q);

        return null;
    }

    private boolean isDescendant(TreeNode p, TreeNode q) {
        if (p == q)
            return true;
        boolean left = false;
        if (p.left != null)
            left = isDescendant(p.left, q);
        boolean right = false;
        if (p.right != null)
            right = isDescendant(p.right, q);
        return left || right;
    }
}
