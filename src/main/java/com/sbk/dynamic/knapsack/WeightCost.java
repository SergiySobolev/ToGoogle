package com.sbk.dynamic.knapsack;

/**
 * Created by Jeronimo on 15.08.2015.
 */
public class WeightCost {
    private Integer weight;
    private Integer cost;

    public WeightCost(Integer weight, Integer cost) {
        this.weight = weight;
        this.cost = cost;
    }

    public WeightCost(String weight, String cost) {
        this.weight = Integer.parseInt(weight);
        this.cost = Integer.parseInt(cost);
    }

    public Integer getWeight() {
        return weight;
    }


    public Integer getCost() {
        return cost;
    }

}
