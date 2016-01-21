package com.sbk.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {
    private List<Point> bricks;
    Point head;
    public Path(){
        bricks = new ArrayList<>();
    }
    public Path(Point... points) {
        bricks = Arrays.asList(points);
        head = points[points.length-1];
    }
    public void addBrick(Point point) {
        bricks.add(point);
        head = point;
    }
    public Path copy(){
        Path copyPath = new Path();
        for(Point brick : bricks){
            copyPath.addBrick(brick.copy());
        }
        copyPath.head = this.head.copy();
        return copyPath;
    }
    public String toString() {
        String pathString = "";
        pathString += "{\n";
        for(Point brick : bricks) {
            pathString += brick.toString();
        }
        pathString += "\n}";
        return pathString;
    }
}
