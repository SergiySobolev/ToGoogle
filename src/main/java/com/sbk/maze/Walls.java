package com.sbk.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Walls {
    private List<Wall> walls;
    public Walls(){
        walls = new ArrayList<>();
    }
    public Walls(Wall... walls) {
        this.walls = Arrays.asList(walls);
    }
    public void addWall(Wall wall) {
        walls.add(wall);
    }
}
