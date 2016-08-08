package com.sbk.leetcode.binarytree;

import org.apache.commons.lang3.ArrayUtils;

public class TreeUtil {
    public static TreeNode toTreeNode(Integer[] vals) {
        return toTreeNode(vals, 0);
    }
    public static TreeNode toTreeNode(int... vals) {
        return toTreeNode(ArrayUtils.toObject(vals));
    }
    private static TreeNode toTreeNode (Integer[] vals, int start) {
        if(start >= vals.length || vals[start] == null) return  null;
        return new TreeNode(vals[start], toTreeNode(vals, start*2+1), toTreeNode(vals, start*2+2));
    }
}
