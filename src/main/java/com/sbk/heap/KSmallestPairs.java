package com.sbk.heap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.min;

/**
 * @see <a href="https://leetcode.com/problems/find-k-pairs-with-smallest-sums/">Find K Pairs with Smallest Sums</a>
 */
public class KSmallestPairs {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length==0 || nums2.length == 0)  return new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<nums2.length;i++) {
            pq.offer(new Pair(0,i, nums1[0] + nums2[i]));
        }
        List<int[]> pairs = new ArrayList<>();
        for(int i = 0; i < Math.min(k, nums1.length*nums2.length); i++){
            Pair p = pq.poll();
            pairs.add(new int[]{nums1[p.i1], nums2[p.i2]});
            if(p.i1+1 < nums1.length) {
                pq.offer(new Pair(p.i1+1,
                        p.i2,
                        nums1[p.i1+1] + nums2[p.i2]));
            }
        }
        return pairs;
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


