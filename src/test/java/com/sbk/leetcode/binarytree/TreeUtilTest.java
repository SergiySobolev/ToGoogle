package com.sbk.leetcode.binarytree;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class TreeUtilTest {
    @Test
    public void toTreeNode() throws Exception {
        TreeNode result1 = TreeUtil.toTreeNode(new Integer[]{1,2,3});
        assertThat(result1.val, equalTo(1));
        assertThat(result1.left.val, equalTo(2));
        assertThat(result1.right.val, equalTo(3));
        TreeNode result2 = TreeUtil.toTreeNode(new Integer[]{1,2,3,4});
        assertThat(result2.val, equalTo(1));
        assertThat(result2.left.val, equalTo(2));
        assertThat(result2.right.val, equalTo(3));
        assertThat(result2.left.left.val, equalTo(4));
        TreeNode result3 = TreeUtil.toTreeNode(new Integer[]{1,2,3,4,5});
        assertThat(result3.val, equalTo(1));
        assertThat(result3.left.val, equalTo(2));
        assertThat(result3.right.val, equalTo(3));
        assertThat(result3.left.left.val, equalTo(4));
        assertThat(result3.left.right.val, equalTo(5));
        TreeNode result4 = TreeUtil.toTreeNode(new Integer[]{1,2,3,4,null,6});
        assertThat(result4.val, equalTo(1));
        assertThat(result4.left.val, equalTo(2));
        assertThat(result4.right.val, equalTo(3));
        assertThat(result4.left.left.val, equalTo(4));
        assertThat(result4.left.right, equalTo(null));
        assertThat(result4.right.left.val, equalTo(6));
    }

}