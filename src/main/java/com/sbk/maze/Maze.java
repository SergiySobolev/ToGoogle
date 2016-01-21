package com.sbk.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private Field field;
    private Point start;
    private Point exit;
    private Walls walls;
    private List<Point> passedPlaces;


    public Point get(int rowNum, int colNum) {
        return  field.getPoint(rowNum, colNum);
    }

    public void buildPath(Path path){
        boolean isPathReachExit = path.head.equals(exit);
        if(isPathReachExit) {
            System.out.println(path);
            return;
        }
        if(canMoveUp(path)) {
            buildPath(moveUp(path));
        }
    }

    private boolean canMoveUp(Path path){
        return path.head.y != 0;
    }

    private Path moveUp(Path path){
        Path moveUpPath = path.copy();
        moveUpPath.addBrick(new Point(path.head.x, path.head.y-1));
        return moveUpPath;
    }

    public static class MazeBuilder {
        private int rowCount;
        private int colCount;
        private Point start;
        private Point exit;
        private Walls walls;

        public MazeBuilder withRowCount(int rowCount) {
            this.rowCount = rowCount;
            return this;
        }

        public MazeBuilder withColCount(int colCount) {
            this.colCount = colCount;
            return this;
        }

        public MazeBuilder withStart(Point start) {
            this.start = start;
            return this;
        }

        public MazeBuilder withExit(Point exit) {
            this.exit = exit;
            return this;
        }

        public MazeBuilder withWalls(Walls walls){
            this.walls = walls;
            return this;
        }

        public Maze build(){
            Maze maze = new Maze();
            maze.field = createField(this.rowCount, this.colCount);
            maze.start = this.start;
            maze.exit = this.exit;
            maze.walls = this.walls;
            maze.passedPlaces = new ArrayList<>();
            return maze;
        }

        private static Field createField(int rowCount, int colCount) {
            return new Field(rowCount, colCount);
        }
    }
}
