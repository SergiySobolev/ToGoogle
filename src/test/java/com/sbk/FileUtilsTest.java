package com.sbk;

import com.sbk.dynamic.knapsack.FileUtils;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Jeronimo on 15.08.2015.
 */
public class FileUtilsTest {

    @Test
    public void testGetWeightAndCosts() throws IOException {
       // FileUtils.getWeightAndCosts("src\\main\\resources\\weightandcosts1.txt");
        assertThat(FileUtils.getCapacity("src\\main\\resources\\capacity.txt"), equalTo(20));
    }
}
