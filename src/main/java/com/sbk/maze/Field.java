package com.sbk.maze;

import java.util.ArrayList;
import java.util.List;

public class Field {
    public int colCount;
    public int rowCount;
    private List<Point> field;

    public Field(int rowCount, int colCount){
        this.rowCount = rowCount;
        this.colCount = colCount;
        field = fillField(this.rowCount, this.colCount);
    }

    private List<Point> fillField(int rowCount, int colCount) {
         List<Point> localField = new ArrayList<Point>();
         int pointCount = rowCount * colCount;
         for(int i = 0; i<pointCount; i++){
             int  pointX = i / colCount;
             int  pointY = i - (colCount * pointX);
             localField.add(i, new Point(pointX, pointY));
         }
         return localField;
    }

    public Point getPoint(int rowNum, int colNum) {
        return field.get(rowNum*this.colCount + colNum);
    }
}
