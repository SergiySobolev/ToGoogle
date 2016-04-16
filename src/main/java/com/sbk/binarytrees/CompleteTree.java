package com.sbk.binarytrees;


import com.google.common.base.Preconditions;

import static java.lang.String.format;

public class CompleteTree {

    int size;

    Node root;

    public CompleteTree() {
        root = null;
        size = 0;
    }

    public void insert(int... newElements) {
        for(int newElement: newElements) {
            insert(newElement);
        }
    }

    public void insert(int newElement) {
        insert(new Node(newElement));
    }

    public void insert(Node newNode) {
        if(size == 0){
            root = newNode;
            newNode.num = ++size;
            return;
        }
        newNode.num = ++size;
        Node parentNode = find(size / 2);
        if(isEven(newNode.num)) {
            parentNode.setLeft(newNode);
        } else {
            parentNode.setRight(newNode);
        }
    }

    public Node find(int num) {
        Preconditions.checkArgument(num >= 0, "You must search for element with positive number");
        Preconditions.checkArgument(size > 0, "Tree is empty");
        Preconditions.checkArgument(num <= size, "You try to find element with number more than size of tree");
        Node cur = root;
        String binary = toBinary(num);
        for(int i=1; i<binary.length();i++){
            cur = binary.charAt(i) == '1' ? cur.right : cur.left;
        }
        return cur;
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    public void preOrderTraversal(Node node) {
        if(node != null) {
            System.out.print(format("%s, ", node.value));
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public static String toBinary(int val) {
        StringBuilder res = new StringBuilder();
        while(val > 0) {
            res.append(val % 2);
            val /= 2;
        }
        return res.reverse().toString();
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    class Node {

        int num;
        int value;
        Node left;
        Node right;
        Node parent;

        public Node (int value) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }

        public Node (int value, Node parent) {
            this.value = value;
            left = null;
            right = null;
            this.parent = parent;
        }

        public void setLeft(Node n) {
            this.left = n;
            n.parent = this;
        }

        public void setRight(Node n) {
            this.right = n;
            n.parent = this;
        }
    }
}
