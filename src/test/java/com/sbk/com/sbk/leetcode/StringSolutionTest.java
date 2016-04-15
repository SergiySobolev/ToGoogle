package com.sbk.com.sbk.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class StringSolutionTest extends BaseTest {

    StringSolution sol;

    @Before
    public void setUp() {
        sol = new StringSolution();
    }

    @Test
    public void testMultiply() throws Exception {
        assertThat(sol.multiply("123", "123"), equalTo("15129"));
    }

    @Test
    public void testRemoveDuplicateLetters() throws Exception {
        assertThat(sol.removeDuplicateLetters("bcabc"), equalTo("abc"));
        assertThat(sol.removeDuplicateLetters("cbacdcbc"), equalTo("acdb"));
    }
}