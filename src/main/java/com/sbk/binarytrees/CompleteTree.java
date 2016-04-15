package com.sbk.binarytrees;


import static java.lang.String.format;

public class CompleteTree {

    int size;

    Node root;

    public CompleteTree() {
        root = null;
        size = 0;
    }

    public void insert(Node root, Node newNode) {
        int parent = (newNode.value - 1) / 2;
        if(parent == root.value){
            newNode.parent = root;
            if(root.left == null) {
                root.left = newNode;
            } else {
                root.right = newNode;
            }
            return;
        }
        Node childToInsert = parent % 2 == 1 ? root.left : root.right;
        insert(childToInsert, newNode);
    }

    public Node find(int num) {
        assert num > 0;
        assert size > 0;
        assert num <= size;
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

    class Node {

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
