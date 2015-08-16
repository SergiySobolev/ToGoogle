package com.sbk.dynamic.knapsack;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Jeronimo on 15.08.2015.
 */
public  class FileUtils {

    private static String enter = "\n";

    static Function<String, WeightCost> toWeightCostFunc = new Function<String, WeightCost>() {
        public WeightCost apply(String s) {
            String[] split = StringUtils.splitString(s," ");
            String weight = split[0];
            String cost = split[1];
            return new WeightCost(weight, cost);
        }
    };

    public static List<WeightCost> getWeightAndCosts(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Stream<String> lines = Files.lines(path);
        List<WeightCost> weightCosts = lines.map(toWeightCostFunc).collect(Collectors.<WeightCost>toList());
        return weightCosts;
    }

    public static int getCapacity(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Stream<String> lines = Files.lines(path);
        return (int)Long.parseLong(lines.findFirst().get());
    }

    public static void writeTableToFile(int[][] a, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        BufferedWriter writer = Files.newBufferedWriter(path);
        writer.write(arrayToString(a));
        writer.close();
    }

    public static void writeDecisionToFile(String decision, String cost, String weight, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        BufferedWriter writer = Files.newBufferedWriter(path);
        writer.write(decision);
        writer.write(enter);
        writer.write(String.format("Weight:%s", weight));
        writer.write(enter);
        writer.write(String.format("Cost:%s", cost));
        writer.write(enter);
        writer.close();
    }

    private static String arrayToString(int[][] a){
        StringBuilder arrayToString = new StringBuilder();
        for(int[] ar : a){
            arrayToString.append(Arrays.toString(ar)).append(enter);
        }
        return arrayToString.toString();
    }

}
