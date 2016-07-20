package com.sbk.leetcode.binarytree.tasks;

import com.google.common.collect.Lists;
import com.sbk.leetcode.binarytree.TreeNode;

import java.util.*;

public class HouseRobber {
    public int rob(TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        List<Integer> levelsSum = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        int queueSizeOnCurrentLevel = queue.size();
        while(queue.size() > 0) {
            int currentSum = 0;
            for (int i = 0; i < queueSizeOnCurrentLevel; i++) {
                TreeNode currentNode = queue.poll();
                currentSum += currentNode.val;
                if(Objects.nonNull(currentNode.left)) queue.add(currentNode.left);
                if(Objects.nonNull(currentNode.right)) queue.add(currentNode.right);
            }
            System.out.println();
            queueSizeOnCurrentLevel = queue.size();
            levelsSum.add(currentSum);
        }
        return maxSubSequenceSum(levelsSum);
    }

    public int maxSubSequenceSum(List<Integer> levelsSum) {
        if(levelsSum.size() == 0){
            return 0;
        }
        if(levelsSum.size() == 1) {
            return levelsSum.get(0);
        }
        if(levelsSum.size() == 2) {
            return Math.max(levelsSum.get(0), levelsSum.get(1));
        }
        return Math.max(
                maxSubSequenceSum(levelsSum.subList(1, levelsSum.size())),
                levelsSum.get(0) + maxSubSequenceSum(levelsSum.subList(2, levelsSum.size()))
                );
    }
}
