package com.sbk.priorityqueue;


import com.sbk.priorityqueue.key.HasKey;

public interface PriorityQueue<E extends HasKey> {
    boolean isEmpty();
    E findMin();
    void insert(E e);
    E deleteMin();
}
