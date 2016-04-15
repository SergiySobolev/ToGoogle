package com.sbk.com.sbk.leetcode;

public class DynamicProgrammingSolution {

    public int climbStairs(int n) {
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for(int i=3;i<n+1;i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    public int rob(int[] nums) {
        int size = nums.length;
        if(size == 0) {
            return 0;
        } else if(size == 1) {
            return nums[0];
        } else if(size == 2) {
            return Math.max(nums[0], nums[1]);
        }
        nums[2] += nums[0];
        for (int i = 3; i < size; i++) {
            nums[i] = Math.max(nums[i] + nums[i-3], nums[i] + nums[i-2]);
        }
        return Math.max(nums[size-1], nums[size-2]);
    }
    public int rob2(int[] nums) {
        int f = 0, f_prev = 0, g = 0, g_prev = 0;
        for(int i=0;i<nums.length;i++) {
            f = g_prev + nums[i];
            g = Math.max(g_prev, f_prev);
            f_prev = f;
            g_prev = g;
        }
        return Math.max(g,f);
    }
}

class NumArray {

    int[] nums;
    int numSize;
    int[] sums;

    public NumArray(int[] nums) {
        this.nums = nums;
        numSize = nums.length;
        sums = new int[numSize+1];
        sums[0] = 0;
        for(int i=1; i<numSize+1; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }

}