package com.sbk.maze;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class MazeTest {

    private Maze maze;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        maze = new Maze.MazeBuilder()
                .withRowCount(4)
                .withColCount(5)
                .withStart(new Point(0,0))
                .withExit(new Point(2, 4))
                .withWalls(new Walls(new Wall(new Point(0,2), new Point(1,2), new Point(1,3), new Point(2, 3)), new Wall(new Point(2,0), new Point(3,0))))
                .build();
    }
    @Test
    public void testCreateFieldGetFieldCorrect() throws Exception {
        Point point = maze.get(2, 3);
        assertThat(point.x, equalTo(2));
        assertThat(point.y, equalTo(3));
        point = maze.get(3, 4);
        assertThat(point.x, equalTo(3));
        assertThat(point.y, equalTo(4));
    }

    @Test(expected = java.lang.IndexOutOfBoundsException.class)
    public void testCreateFieldGetFieldWithException() {
        maze.get(4,5);
    }

    @Test
    public void testCreateFieldGetFieldWithException2() {
        exception.expect(IndexOutOfBoundsException.class);
        exception.expectMessage("-1");
        maze.get(0,-1);
    }

    @Test
    public void testWall(){

    }
}