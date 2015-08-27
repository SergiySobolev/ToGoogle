package com.sbk.dynamic.knapsack;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.sbk.dynamic.knapsack.FileUtils.*;

/**
 * Created by Jeronimo on 15.08.2015.
 */
public class Knapsack {

    private List<WeightCost> weightCosts;
    private int capacity;
    private int weightCostSize;
    private int[][] a;
    private List<Integer> decision = newArrayList();

    final static Logger log = LoggerFactory.getLogger(Knapsack.class);

    public Knapsack(String weightCostsFile, String capacityFile) throws IOException {
        weightCosts = getWeightAndCosts(weightCostsFile);
        capacity = getCapacity(capacityFile);
        weightCostSize = weightCosts.size();
        a = new int[weightCostSize+1][capacity+1];
    }

    public void buildKnapsackTable(){
        for(int i=0;i<=capacity;i++){
            a[0][i] = 0;
        }
        for(int i=1;i<=weightCostSize;i++){
            log.info("------Knapsack with first {} items-------", i);
            int iWeight = weightCosts.get(i - 1).getWeight();
            int iCost =  weightCosts.get(i - 1).getCost();
            for(int j=0; j<=capacity; j++){
                int prevCost = a[i-1][j];
                int capacityWithoutCurrentItem = j-iWeight;
                boolean canContain = (capacityWithoutCurrentItem >= 0);
                if(canContain){
                    int prevCostWithoutCurrent = a[i-1][capacityWithoutCurrentItem];
                    int currentCost = a[i - 1][capacityWithoutCurrentItem] + iCost;
                    if(prevCostWithoutCurrent + iCost > prevCost){
                        a[i][j] = currentCost;
                        log.info("Item {}(Weight:{}, Cost:{}) putted to knapsack ({},{}). Previous cost({},{}):{}, current cost:{}", i-1, iWeight, iCost, i-1, j, i-1, capacityWithoutCurrentItem, prevCostWithoutCurrent, currentCost);
                    } else {
                        a[i][j] = prevCost;
                        int prevCostWithSuchCapacity = a[i-1][j];
                        log.info("Item {}(Weight:{}, Cost:{}) NOT putted to knapsack ({},{}). Previous cost with such capacity:{}, current cost:{}", i-1, iWeight, iCost, i-1, j, prevCostWithSuchCapacity, currentCost);
                    }
                } else {
                    a[i][j] = prevCost;
                }
            }
        }
    }

    public void buildDecision(){
        buildDecision(weightCostSize, capacity);
    }

    private void buildDecision(int s, int n){
        if(a[s][n] == 0){
            return;
        }
        if(a[s-1][n] == a[s][n]){
            buildDecision(s-1,n);
        } else {
            decision.add(s-1);
            buildDecision(s - 1, n - weightCosts.get(s - 1).getWeight());
        }
    }

    public void writeTableToFile(String tableFile) throws IOException {
        FileUtils.writeTableToFile(a, tableFile);
    }

    public void writeDecisionToFile(String s) throws IOException {
        Integer cost = 0;
        Integer weight = 0;
        for(Integer i : decision){
            cost += weightCosts.get(i).getCost();
            weight += weightCosts.get(i).getWeight();
        }
        FileUtils.writeDecisionToFile(decision.toString(), cost.toString(), weight.toString(), s);
    }
}
