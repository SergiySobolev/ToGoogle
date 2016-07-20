package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTest {
    private HouseRobber hb = new HouseRobber();

    @Test
    public void hbTest() {
        assertEquals(hb.rob(TreeUtil.toTreeNode(new Integer[]{3,2,2,null,3,null,1})), 7);
        assertEquals(hb.rob(TreeUtil.toTreeNode(new Integer[]{3,4,5,1,2,null,1})), 9);
        assertEquals(hb.rob(TreeUtil.toTreeNode(new Integer[]{4,1,null,2,null,null, null,3})), 7);
        assertEquals(hb.rob(TreeUtil.toTreeNode(new Integer[]{2,1,3,null,4})), 7);
    }
}
