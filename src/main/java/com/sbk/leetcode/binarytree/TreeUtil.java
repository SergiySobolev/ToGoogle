package com.sbk.leetcode.binarytree;

public class TreeUtil {
    public static TreeNode toTreeNode(Integer[] vals) {
        return toTreeNode(vals, 0);
    }
    private static TreeNode toTreeNode (Integer[] vals, int start) {
        if(start >= vals.length || vals[start] == null) return  null;
        return new TreeNode(vals[start], toTreeNode(vals, start*2+1), toTreeNode(vals, start*2+2));
    }
}
