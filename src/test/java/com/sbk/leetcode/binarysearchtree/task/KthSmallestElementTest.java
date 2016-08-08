package com.sbk.leetcode.binarysearchtree.task;

import com.sbk.leetcode.binarysearchtree.KthSmallestElement;
import org.junit.Test;

import static com.sbk.leetcode.binarytree.TreeUtil.toTreeNode;
import static org.junit.Assert.assertEquals;

public class KthSmallestElementTest {
    KthSmallestElement kSE = new KthSmallestElement();
    @Test
    public void KthSmallestElementTest() {
        assertEquals(kSE.kthSmallest(toTreeNode(2,1,3), 2), 2);
    }
}
