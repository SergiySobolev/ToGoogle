package com.sbk.binarytrees;


import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Stream.concat;

public class CompleteTree<E> {

    int size;

    Node root;

    public CompleteTree() {
        root = null;
        size = 0;
    }

    public void insert(E... newElements) {
        for(E newElement: newElements) {
            insert(newElement);
        }
    }

    public void insert(E newElement) {
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

    public List<E> preOrderTraversal() {
        return preOrderTraversal(root);
    }

    public List<E> preOrderTraversal(Node node) {
        List<E> leftPreOrderTraversal = node.left == null
                ? Lists.newArrayList() : preOrderTraversal(node.left);
        List<E> rightPreOrderTraversal = node.right == null
                ? Lists.newArrayList() : preOrderTraversal(node.right);
        return concat( Stream.of(node.value), leftPreOrderTraversal.stream(), rightPreOrderTraversal.stream())
                .collect(Collectors.<E>toList());
    }

    public List<E> inOrderTraversal() {
        return inOrderTraversal(root);
    }

    public List<E> inOrderTraversal(Node node) {
        List<E> leftInOrderTraversal = node.left == null
                ? Lists.newArrayList() : inOrderTraversal(node.left);
        List<E> rightInOrderTraversal = node.right == null
                ? Lists.newArrayList() : inOrderTraversal(node.right);
        return concat(leftInOrderTraversal.stream(), Stream.of(node.value), rightInOrderTraversal.stream())
                .collect(Collectors.<E>toList());
    }

    private static<E> Stream<E> concat(Stream<E> s1, Stream<E> s2, Stream<E> s3) {
        return Stream.concat(Stream.concat(s1, s2), s3);
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
        E value;
        Node left;
        Node right;
        Node parent;

        public Node (E value) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }

        public Node (E value, Node parent) {
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
