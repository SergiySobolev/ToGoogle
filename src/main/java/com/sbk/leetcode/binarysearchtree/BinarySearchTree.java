package com.sbk.leetcode.binarysearchtree;

import com.sbk.leetcode.binarytree.TreeNode;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    public void insert(int... keys) {
        for(int key : keys){
            insert(key);
        }
    }

    void inorder()  {
        inorderRec(root);
    }

    public int height() {
        return height(root);
    }

    public int size() {
        return size(root);
    }

    public int kthSmallest(int k) {
        return kthSmallest(root, k);
    }

    private int kthSmallest(TreeNode root, int k) {
        return 0;
    }

    private TreeNode insertRec(TreeNode r, int key) {
        if(r == null) {
            r = new TreeNode(key);
            return r;
        }
        if(key < r.val) {
            r.left = insertRec(r.left, key);
        } else if (key > r.val) {
            r.right = insertRec(r.right, key);
        }
        return r;
    }

    private void inorderRec(TreeNode r) {
        if (r != null) {
            inorderRec(r.left);
            System.out.println(r.val);
            inorderRec(r.right);
        }
    }

    private int height(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }

    private int size(TreeNode root) {
        return root == null ? 0 : 1 + size(root.left) + size(root.right);
    }
}
