package com.sbk;

import org.junit.Test;

import static com.sbk.stringdistance.LevenshteinDistance.findDistance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LevenshteinDistanceTest {

    @Test
    public void levenshteinDistanceTest(){
        assertThat(findDistance("abc", "abd"), equalTo(1l));
        assertThat(findDistance("abc", "abde"), equalTo(2l));
        assertThat(findDistance("abc", "abce"), equalTo(1l));
        assertThat(findDistance("kwa", "awk"), equalTo(2l));
        assertThat(findDistance("kwafk", "awkfl"), equalTo(3l));
    }
}
