package com.sbk.heap;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthSmallestMatrixTest {
    private KthSmallestMatrix k = new KthSmallestMatrix();
    @Test
    public void kthSmallest() throws Exception {
        int[][] matrix = new int[][] {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        assertEquals(k.kthSmallest(matrix,1), 1);
        assertEquals(k.kthSmallest(matrix,2), 5);
        assertEquals(k.kthSmallest(matrix,8), 13);
    }

}