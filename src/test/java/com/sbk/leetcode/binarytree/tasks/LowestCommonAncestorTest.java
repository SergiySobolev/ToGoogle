package com.sbk.leetcode.binarytree.tasks;

import com.sbk.leetcode.binarytree.TreeNode;
import com.sbk.leetcode.binarytree.TreeUtil;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorTest {
    LowestCommonAncestor lca = new LowestCommonAncestor();

    @Test
    public void lowestCommonAncestorTest() {
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_5 = new TreeNode(5);
        TreeNode treeNode_2 = new TreeNode(2, treeNode_1, null);
        TreeNode root = new TreeNode(3, treeNode_2,  treeNode_5);
        TreeNode answer = lca.lowestCommonAncestor(root, treeNode_1, treeNode_5);
        assertThat(answer.val, equalTo(root.val));
    }

    @Test
    public void lowestCommonAncestorTest2() {
        TreeNode root = TreeUtil.toTreeNode(new Integer[]{5,3,6,2,4,null,null,1});
        TreeNode answer = lca.lowestCommonAncestor(root,root.left.left.left,root.left.right);
        assertThat(answer.val, equalTo(3));
        root = TreeUtil.toTreeNode(new Integer[]{2,1});
        answer = lca.lowestCommonAncestor(root, root, root.left);
        assertThat(answer.val, equalTo(2));
    }


    @Test
    public void lowestCommonAncestorTest4() {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        TreeNode answer = lca.lowestCommonAncestor(root, left, right);
        assertEquals(answer, root);
    }

}
