package com.sbk.leetcode.different;

import com.sbk.leetcode.dynamic.DynamicProgrammingSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by ssobolev on 1/21/2016.
 */
public class DynamicProgrammingSolutionTest extends BaseTest {

    DynamicProgrammingSolution sol;
   // NumArray solNumArray;

    @Before
    public void setUp() throws Exception {
        sol = new DynamicProgrammingSolution();
        int[] nums = new int[]{1,2,3};
       // solNumArray = new NumArray(nums);
    }

    @Test
    public void testRob() throws Exception {
        assertThat(sol.rob(new int[]{3,2,1,5,9,3,2,8 }), equalTo(21));
    }

    @Test
    public void testSumRange() {
       // assertThat(solNumArray.sumRange(0,2), equalTo(6));
      //  assertThat(solNumArray.sumRange(1,2), equalTo(5));
    }
}