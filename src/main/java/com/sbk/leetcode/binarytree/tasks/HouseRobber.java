package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

import static java.lang.Math.max;

public class HouseRobber {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return max(res[0], res[1]);

    }
    public int[] dfs(TreeNode root){
        if(root == null) return new int[2];
        int[] right =  dfs(root.right);
        int[] left =  dfs(root.left);
        int[] result = new int[2];
        result[0] = root.val + right[1] + left[1];
        result[1] = max(left[0], left[1]) + max(right[0], right[1]);
        return result;
    }
}
