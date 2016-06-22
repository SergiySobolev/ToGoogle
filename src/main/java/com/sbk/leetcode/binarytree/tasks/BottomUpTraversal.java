package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BottomUpTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelList = new ArrayList<>();
        Queue<TreeNode> level = new ArrayDeque<>();
        level.add(root);
        while (true) {
            level = addToList(level, levelList);
            if (level.isEmpty()) break;
        }
        return levelList;
    }

    private Queue<TreeNode> addToList(Queue<TreeNode> level, List<List<Integer>> levelList) {
        Queue<TreeNode> localLevel = new ArrayDeque<>();
        List<Integer> localLevelList = new ArrayList<>();
        for(TreeNode node : level) {
            if(node.left != null) localLevel.add(node.left);
            if(node.right != null) localLevel.add(node.right);
            localLevelList.add(node.val);
        }
        levelList.add(0, localLevelList);
        return localLevel;
    }
}
