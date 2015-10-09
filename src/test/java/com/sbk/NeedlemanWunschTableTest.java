package com.sbk;

import com.sbk.stringdistance.NW;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NeedlemanWunschTableTest {

    @Test
    public void nwTest1(){
        NW nw = new NW("GAATTCAGTTA", "GGATCGA");
        String[] aligments = nw.findAligments();
        assertThat(aligments.length, equalTo(2));
        assertThat(aligments[0], equalTo("GAATTCAGTTA"));
        assertThat(aligments[1], equalTo("GGA-TC-G--A"));
    }

    @Test
    public void nwTest2(){
        NW nw = new NW("ATGA", "ATA");
        String[] aligments = nw.findAligments();
        assertThat(aligments.length, equalTo(2));
        assertThat(aligments[0], equalTo("ATGA"));
        assertThat(aligments[1], equalTo("AT-A"));
    }
}
