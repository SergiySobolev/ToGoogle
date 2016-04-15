package com.sbk.longarithmetics;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

@AxisRange(min = 0, max = 1)
@BenchmarkMethodChart(filePrefix = "multiply-school-recursive-karatsuba")
public class LongArithmeticsChartTest {

    public static final long LOOPS_COUNT = 1;

    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule();

    @Before
    public  void setUp(){
    }

    @Test
    public void multiplyKaratsuba8192() throws Exception {
        multiplyKaratsuba(8192);
    }

    @Test
    public void multiplyKaratsuba4096() throws Exception {
        multiplyKaratsuba(4096);
    }

    @Test
    public void multiplyKaratsuba2048() throws Exception {
        multiplyKaratsuba(2048);
    }

    @Test
    public void multiplyKaratsuba1024() throws Exception {
        multiplyKaratsuba(1024);
    }

    @Test
    public void multiply8192() throws Exception {
        multiply(8192);
    }

    @Test
    public void multiply4096() throws Exception {
        multiply(4096);
    }

    @Test
    public void multiply2048() throws Exception {
        multiply(2048);
    }

    @Test
    public void multiply1024() throws Exception {
        multiply(1024);
    }

    @Test
    public void multiplyRecursive8192() throws Exception {
        multiplyRecursive(8192);
    }

    @Test
    public void multiplyRecursive4096() throws Exception {
        multiplyRecursive(4096);
    }

    @Test
    public void multiplyRecursive2048() throws Exception {
        multiplyRecursive(2048);
    }

    @Test
    public void multiplyRecursive1024() throws Exception {
        multiplyRecursive(1024);
    }



    private void multiply(int digitNumber) {
        BigNumber multiplier1 = BigNumber.generateRandomNumber(digitNumber);
        BigNumber multiplier2 = BigNumber.generateRandomNumber(digitNumber);
        for(int i=0; i<LOOPS_COUNT; i++) {
            BigNumber result = multiplier1.multiply(multiplier2);
            assertNotNull(result.toString());
        }
    }

    private void multiplyRecursive(int digitNumber) {
        BigNumber multiplier1 = BigNumber.generateRandomNumber(digitNumber);
        BigNumber multiplier2 = BigNumber.generateRandomNumber(digitNumber);
        for(int i=0; i<LOOPS_COUNT; i++) {
            BigNumber result = multiplier1.multiplyRecursive(multiplier2);
            assertNotNull(result.toString());
        }
    }

    private void multiplyKaratsuba(int digitNumber) {
        BigNumber multiplier1 = BigNumber.generateRandomNumber(digitNumber);
        BigNumber multiplier2 = BigNumber.generateRandomNumber(digitNumber);
        for(int i=0; i<LOOPS_COUNT; i++) {
            BigNumber result = multiplier1.multiplyKaratsuba(multiplier2);
            assertNotNull(result.toString());
        }
    }
}