package com.sbk.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wall {
    private List<Point> bricks;
    public Wall(){
        bricks = new ArrayList<>();
    }
    public Wall(Point... points) {
        bricks = Arrays.asList(points);
    }
    public void addBrick(Point point) {
        bricks.add(point);
    }
    public boolean isAbut(Point p) {
        return bricks.contains(p);
    }
}
