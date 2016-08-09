package com.sbk.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs with Smallest Sums</a>
 */
public class KSmallestPairs {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length*nums2.length];
        for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums2.length;j++){
                int curnum = i*nums2.length + j;
                pairs[curnum] = new Pair(i, j, nums1[i] + nums2[j]);
            }
        }
        Arrays.sort(pairs);
        return Stream.of(pairs)
                .limit(Math.min(k, pairs.length))
                .map(pair -> new int[]{nums1[pair.i1], nums2[pair.i2]})
                .collect(Collectors.toList());
    }

    static class Pair implements Comparable<Pair>{
        int i1;
        int i2;
        int sum;
        Pair(int i1, int i2, int sum) {
            this.i1 = i1;
            this.i2 = i2;
            this.sum = sum;
        }

        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }
}


