package com.sbk.leetcode.binarytree;

import com.sbk.leetcode.binarytree.tasks.BinaryTreePath;
import com.sbk.leetcode.binarytree.tasks.LowestCommonAncestor;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.core.IsEqual.*;

public class BinaryTreeTest {

    @Test
    public void binaryTreePathsTest() {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, null));
        BinaryTreePath b = new BinaryTreePath();
        List<String> binaryTreePaths =  b.binaryTreePaths(root);
        String[] expected = {"1->2->5", "1->3"};
        assertThat(binaryTreePaths, containsInAnyOrder(expected));
        binaryTreePaths =  b.binaryTreePaths(null);
        expected = new String[]{};
        assertThat(binaryTreePaths, containsInAnyOrder(expected));
    }

    @Test
    public void lowestCommonAncestorTest() {
        TreeNode treeNode_1 = new TreeNode(1);
        TreeNode treeNode_5 = new TreeNode(5);
        TreeNode treeNode_2 = new TreeNode(2, treeNode_1, null);
        TreeNode root = new TreeNode(3, treeNode_2,  treeNode_5);
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode answer = l.lowestCommonAncestor(root, treeNode_1, treeNode_5);
        assertThat(answer.val, equalTo(root.val));
    }

    @Test
    public void lowestCommonAncestorTest2() {
        TreeNode root = TreeUtil.toTreeNode(new Integer[]{5,3,6,2,4,null,null,1});
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode answer = l.lowestCommonAncestor(root,root.left.left.left,root.left.right);
        assertThat(answer.val, equalTo(3));
        root = TreeUtil.toTreeNode(new Integer[]{2,1});
        answer = l.lowestCommonAncestor(root, root, root.left);
        assertThat(answer.val, equalTo(2));
    }

    @Test
    public void lowestCommonAncestorTest3() {
        TreeNode root = TreeUtil.toTreeNode(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode answer = l.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5));
        assertThat(answer.val, equalTo(4));
    }

}