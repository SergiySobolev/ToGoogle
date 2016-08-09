package com.sbk.heap;

import java.util.PriorityQueue;

public class KthSmallestMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                pq.offer(anAMatrix);
            }
        }
        int res=0;
        for(int i=0; i<k; i++){
            res = pq.poll();
        }
        return res;
    }
}
