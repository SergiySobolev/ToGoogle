package com.sbk;

import com.sbk.stringdistance.NeedlemanWunsch;
import com.sbk.stringdistance.Trace;
import org.junit.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class NeedlemanWunschTableTest {

    @Test
    public void nwTest1(){
        NeedlemanWunsch nw = new NeedlemanWunsch("GAATTCAGTTA", "GGATCGA");
        nw.findAligments();
        Set<Trace> decision = nw.getDecision();
        assertThat(decision.size(), equalTo(2));
        assertThat(decision, hasItem(new Trace("GGAT-C-G--A", "GAATTCAGTTA")));
        assertThat(decision, hasItem(new Trace("GGA-TC-G--A", "GAATTCAGTTA")));
    }

    @Test
    public void nwTest2(){
        NeedlemanWunsch nw = new NeedlemanWunsch("ATGA", "ATA");
        nw.findAligments();
        Set<Trace> decision = nw.getDecision();
        assertThat(decision.size(), equalTo(1));
        assertThat(decision, hasItem(new Trace("AT-A", "ATGA")));
    }

    @Test
    public void nwTest3(){
        NeedlemanWunsch nw = new NeedlemanWunsch("GCATGCU", "GATTACA");
        nw.findAligments();
        Set<Trace> decision = nw.getDecision();
        assertThat(decision.size(), equalTo(4));
        assertThat(decision, hasItem(new Trace("GATTACA", "GCATGCU")));
        assertThat(decision, hasItem(new Trace("G-ATTACA", "GCA-TGCU")));
        assertThat(decision, hasItem(new Trace("G-ATTACA", "GCATG-CU")));
        assertThat(decision, hasItem(new Trace("G-ATTACA", "GCAT-GCU")));
    }
}
