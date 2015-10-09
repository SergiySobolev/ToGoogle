package com.sbk.stringdistance;

import static com.sbk.util.MathUtils.min;

public class LevenshteinDistance {

    public static long findDistance(String s1, String s2) {
        return findDistance(s1, s1.length(), s2, s2.length());
    }

    private static long findDistance(String s1, int l1, String s2, int l2) {
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;
        int cost = s1.charAt(l1 - 1) == s2.charAt(l2 - 1) ? 0 : 1;
        return min( findDistance(s1, l1 - 1, s2, l2) + 1,
                    findDistance(s1, l1, s2, l2 - 1) + 1,
                    findDistance(s1, l1 - 1, s2, l2 - 1) + cost );
    }
}
