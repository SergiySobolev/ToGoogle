package com.sbk.longarithmetics;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LongArithmeticsBenchmarkTest extends AbstractBenchmark {

    public static final long LOOPS_COUNT = 10000000;

    BigNumber number;

    @Before
    public  void setUp() {
        number = new BigNumber(1, 2, 3, 4);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 30, warmupRounds = 0, callgc = false)
    public void testMultiply()  {
        BigNumber multiplier = new BigNumber(4,3,2,1);
        BigNumber result = number.multiply(multiplier);
        assertThat(result.toString(), equalTo("5332114"));
    }

}
