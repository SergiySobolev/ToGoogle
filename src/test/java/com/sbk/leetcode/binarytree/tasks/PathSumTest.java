package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;
import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathSumTest {

    PathSum pathSum = new PathSum();

    @Test
    public void hasPathSum() throws Exception {
        TreeNode input = TreeUtil.toTreeNode(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1});
        assertTrue(pathSum.hasPathSum(input, 22));
    }

    @Test
    public void hasPathSum2() throws Exception {
        TreeNode input = TreeUtil.toTreeNode(new Integer[]{});
        assertFalse(pathSum.hasPathSum(input, 0));
    }

    @Test
    public void hasPathSum3() throws Exception {
        TreeNode input = TreeUtil.toTreeNode(new Integer[]{1,2});
        assertFalse(pathSum.hasPathSum(input, 1));
    }


}