package com.sbk.util;

public class MathUtils {
    public static long min(long l1, long l2){
        return l1 > l2 ? l2 : l1;
    }
    public static long min(long l1, long l2, long l3){
        return min(l1, min(l2, l3));
    }
    public static long max(long l1, long l2){
        return l1 > l2 ? l1 : l2;
    }
    public static long max(long l1, long l2, long l3){
        return max(l1, max(l2, l3));
    }
    public static int max(int l1, int l2){
        return l1 > l2 ? l1 : l2;
    }
    public static int max(int l1, int l2, int l3){
        return max(l1, max(l2, l3));
    }


}
