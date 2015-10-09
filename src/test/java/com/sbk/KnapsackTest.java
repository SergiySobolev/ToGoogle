package com.sbk;

import com.sbk.dynamic.knapsack.Knapsack;
import org.junit.Test;

import java.io.IOException;

public class KnapsackTest {
    @Test
    public void testKnapsack() throws IOException {
        Knapsack knapsack = new Knapsack("src\\main\\resources\\weightandcosts1.txt", "src\\main\\resources\\capacity.txt");
        knapsack.buildKnapsackTable();
        knapsack.writeTableToFile("src\\main\\resources\\table.txt");
        knapsack.buildDecision();
        knapsack.writeDecisionToFile("src\\main\\resources\\decision.txt");
    }
}
