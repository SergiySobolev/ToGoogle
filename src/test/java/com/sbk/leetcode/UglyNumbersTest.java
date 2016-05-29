package com.sbk.leetcode;

import com.sbk.leetcode.dynamic.UglyNumbers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UglyNumbersTest extends  BaseTest {

    UglyNumbers sol;

    @Before
    public void setUp() {
        sol = new UglyNumbers();
    }

    @Test
    public void testSuperUgly() throws Exception {
        assertThat(sol.nthSuperUglyNumber(20, new int[]{2, 7, 11, 13, 19}), equalTo(64));
        assertThat(sol.nthSuperUglyNumber(77, new int[]{2, 7, 11, 13, 19}), equalTo(968));
        assertThat(sol.nthSuperUglyNumber(4400, new int[]{2, 7, 11, 13, 19}), equalTo(1805969152));
        assertThat(sol.nthSuperUglyNumber(4460, new int[]{2, 7, 11, 13, 19}), equalTo(1944889856));
        assertThat(sol.nthSuperUglyNumber(4490, new int[]{2, 7, 11, 13, 19}), equalTo(2015756288));
        assertThat(sol.nthSuperUglyNumber(4490, new int[]{2, 7, 11, 13, 19}), equalTo(2015756288));
        assertThat(sol.nthSuperUglyNumber(4510, new int[]{2, 7, 11, 13, 19}), equalTo(2060114368));
        assertThat(sol.nthSuperUglyNumber(4542, new int[]{2, 7, 11, 13, 19}), equalTo(2137096192));
        assertThat(sol.nthSuperUglyNumber(4543, new int[]{2, 7, 11, 13, 19}), equalTo(2142509369));
        assertThat(sol.nthSuperUglyNumber(100, new int[]{2,5,7,11,17,23,29,41,43,47,61,71,73,79,83,103,109,127,139,151,157,163,181,193,199,223,227,229,233,239}), equalTo(232));
    }

    @Test
    public void testIsUgly() throws Exception {
        assertThat(sol.nthUglyNumber(8), equalTo(9));
        assertThat(sol.nthUglyNumber(10), equalTo(12));
        assertThat(sol.nthUglyNumber(11), equalTo(15));
        assertThat(sol.nthUglyNumber(15), equalTo(24));
        assertThat(sol.nthUglyNumber(1366), equalTo(432000000));
    }

    @Test
    public void testIsUgly2() throws Exception {
        assertThat(sol.isUgly2(8), equalTo(true));
        assertThat(sol.isUgly2(10), equalTo(true));
        assertThat(sol.isUgly2(1641249143), equalTo(false));
        assertThat(sol.isUgly2(-2147483647), equalTo(false));
        assertThat(sol.isUgly2(-2147483648), equalTo(false));
        assertThat(sol.isUgly2(2144678529), equalTo(false));
    }

}