package com.sbk.priorityqueue.heap;

import com.sbk.priorityqueue.PriorityQueue;
import com.sbk.priorityqueue.key.HasKey;

public class HeapPriorityQueue<E extends HasKey> implements PriorityQueue<E> {

    private Long size;

    private HeapElement element = new HeapElement();

    public HeapPriorityQueue(HasKey value) {
        this.element.data = value;
        this.size = 0L;
    }

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
