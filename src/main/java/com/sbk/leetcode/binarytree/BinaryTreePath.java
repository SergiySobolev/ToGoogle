package com.sbk.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.collect.Iterables.isEmpty;

class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<String> completedPaths = new ArrayList<>();
        String path = String.valueOf(root.val);
        if(root.left == null && root.right == null) {
            completedPaths.add(path);
        }
        if(root.left != null ) binaryTreePathsIterative(root.left, path, completedPaths);
        if(root.right != null ) binaryTreePathsIterative(root.right, path, completedPaths);
        return completedPaths;
    }

    private void binaryTreePathsIterative(TreeNode root, String prevPath, ArrayList<String> completedPaths) {
        if(root.left == null && root.right == null) {
            completedPaths.add(prevPath + "->" + String.valueOf(root.val));
        } else {
            String newPath = prevPath + "->" + String.valueOf(root.val);
            if(root.left != null ) binaryTreePathsIterative(root.left, newPath, completedPaths);
            if(root.right != null ) binaryTreePathsIterative(root.right, newPath, completedPaths);
        }
    }


    List<String> appendPathsToNode(TreeNode node, List<String> paths) {
        return isEmpty(paths) ? Collections.singletonList(String.valueOf(node.val)) :
             paths.stream() .map(p -> node.val + "->" + p).collect(Collectors.toList());
    }
}
