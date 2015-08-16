package com.sbk.dynamic.knapsack;

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
            int iWeight = weightCosts.get(i - 1).getWeight();
            int iCost =  weightCosts.get(i - 1).getCost();
            for(int j=0; j<=capacity; j++){
                a[i][j] = a[i-1][j];
                if(j>= iWeight){
                    if(a[i-1][j-iWeight] + iCost > a[i][j]){
                        a[i][j] = a[i-1][j-iWeight] + iCost;
                    }
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
