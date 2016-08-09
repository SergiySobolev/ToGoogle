package com.sbk.heap;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KSmallestPairsTest {
    private KSmallestPairs ksp = new KSmallestPairs();
    @Test
    public void kSmallestPairs() throws Exception {
        List<int[]> expected = ksp.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        assertEquals(expected.get(0)[0], 1);
        assertEquals(expected.get(0)[1], 2);
        assertEquals(expected.get(1)[0], 1);
        assertEquals(expected.get(1)[1], 4);
        assertEquals(expected.get(2)[0], 1);
        assertEquals(expected.get(2)[1], 6);
        List<int[]> expected2  = ksp.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2);
        assertEquals(expected2.get(0)[0], 1);
        assertEquals(expected2.get(0)[1], 1);
        assertEquals(expected2.get(1)[0], 1);
        assertEquals(expected2.get(1)[1], 1);
        List<int[]> expected1 = ksp.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3);
        assertEquals(expected1.get(0)[0], 1);
        assertEquals(expected1.get(0)[1], 3);
        assertEquals(expected1.get(1)[0], 2);
        assertEquals(expected1.get(1)[1], 3);
    }

}