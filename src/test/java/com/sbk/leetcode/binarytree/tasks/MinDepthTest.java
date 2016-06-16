package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class MinDepthTest {
    MinDepth mp = new MinDepth();
    @Test
    public void minDepth() throws Exception {
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{})), equalTo(0));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1})), equalTo(1));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1,2})), equalTo(2));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1,2,3})), equalTo(2));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1,2,3,4})), equalTo(2));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1,2,3,4,5})), equalTo(2));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1,2,3,4,5,6})), equalTo(3));
        assertThat(mp.minDepth(TreeUtil.toTreeNode(new Integer[]{1,2,3,4,5,6, 7})), equalTo(3));
    }

}