package com.sbk.priorityqueue.heap;

import com.sbk.binarytrees.CompleteTree;
import com.sbk.priorityqueue.PriorityQueue;
import com.sbk.priorityqueue.key.HasKey;

public class HeapPriorityQueue<E extends HasKey> implements PriorityQueue<E> {

    private CompleteTree tree = new CompleteTree();

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E findMin() {
        return null;
    }

    @Override
    public void insert(E e) {

    }

    @Override
    public E deleteMin() {
        return null;
    }
}
