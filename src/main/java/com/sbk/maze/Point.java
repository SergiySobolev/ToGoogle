package com.sbk.maze;

import java.util.Objects;

public class Point {
    public int x;
    public int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point copy() {
        return new Point(x,y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point that = (Point)obj;
        return that.x == this.x && that.y == this.y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
