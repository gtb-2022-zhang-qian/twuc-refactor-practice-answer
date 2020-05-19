package com.twu.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirectionTest {

    private Direction north;
    private Direction east;
    private Direction west;
    private Direction south;

    @BeforeEach
    public void setUp() throws Exception {
        north = Direction.NORTH;
        east = Direction.EAST;
        west = Direction.WEST;
        south = Direction.SOUTH;
    }

    @Test
    public void shouldTurnLeft() {
        assertThat(north.turnLeft(), is(Direction.WEST));
        assertThat(east.turnLeft(), is(Direction.NORTH));
        assertThat(south.turnLeft(), is(Direction.EAST));
        assertThat(west.turnLeft(), is(Direction.SOUTH));
    }

    @Test
    public void shouldTurnRight() {
        assertThat(north.turnRight(), is(Direction.EAST));
        assertThat(east.turnRight(), is(Direction.SOUTH));
        assertThat(south.turnRight(), is(Direction.WEST));
        assertThat(west.turnRight(), is(Direction.NORTH));
    }
}
