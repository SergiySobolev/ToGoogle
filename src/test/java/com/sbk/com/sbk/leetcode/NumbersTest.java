package com.sbk.com.sbk.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class NumbersTest extends BaseTest {

    Numbers sol;

    @Before
    public void setUp() throws Exception {
        sol = new Numbers();
    }

    @Test
    public void testIsPowerOfTwo() throws Exception {
        assertThat(sol.isPowerOfTwo(4), equalTo(true));
        assertThat(sol.isPowerOfTwo(6), equalTo(false));
        assertThat(sol.isPowerOfTwo(8), equalTo(true));
        assertThat(sol.isPowerOfTwo(127), equalTo(false));
        assertThat(sol.isPowerOfTwo(128), equalTo(true));
    }

    @Test
    public void testConvertToTitle() throws Exception {
        assertThat(sol.convertToTitle(1), equalTo("A"));
        assertThat(sol.convertToTitle(27), equalTo("AA"));
        assertThat(sol.convertToTitle(26), equalTo("Z"));
        assertThat(sol.convertToTitle(28), equalTo("AB"));
        assertThat(sol.convertToTitle(52), equalTo("AZ"));
    }

    @Test
    public void testTitleToNumber() throws Exception {
        assertThat(sol.titleToNumber("ABC"), equalTo(731));
        assertThat(sol.titleToNumber("A"), equalTo(1));
        assertThat(sol.titleToNumber("AA"), equalTo(27));
        assertThat(sol.titleToNumber("Y"), equalTo(25));
        assertThat(sol.titleToNumber("AAA"), equalTo(703));
    }

    @Test
    public void testNumSquares() throws Exception {
        assertThat(sol.numSquares(12), equalTo(3));
    }

    @Test
    public void testCoinChange() throws Exception {
        assertThat(sol.coinChange(new int[]{474,83,404,3}, 264),equalTo(8));
        assertThat(sol.coinChange(new int[]{2}, 3),equalTo(-1));
        assertThat(sol.coinChange(new int[]{1, 2, 5}, 11),equalTo(3));
    }
}