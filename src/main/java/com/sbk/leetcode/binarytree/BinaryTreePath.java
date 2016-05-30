package com.sbk.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;


class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> completedPaths = new ArrayList<>();
        binaryTreePathsIterative(root, null, completedPaths);
        return completedPaths;
    }

    private void binaryTreePathsIterative(TreeNode root, String prevPath, ArrayList<String> completedPaths) {
        if(root == null) {
            if(prevPath != null) completedPaths.add(prevPath);
            return;
        }
        String newPath = (prevPath == null ? "" : prevPath + "->") + String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            completedPaths.add(newPath);
        } else {
            if (root.left != null) binaryTreePathsIterative(root.left, newPath, completedPaths);
            if (root.right != null) binaryTreePathsIterative(root.right, newPath, completedPaths);
        }
    }

}
