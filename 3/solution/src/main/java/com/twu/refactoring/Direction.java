package com.twu.refactoring;

import java.util.Arrays;
import java.util.List;

public enum Direction {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private static final List<Direction> DIRECTIONS = Arrays.asList(values());
    private final char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public Direction turnRight() {
        return DIRECTIONS.get((DIRECTIONS.indexOf(this) + 1) % DIRECTIONS.size());
    }

    public Direction turnLeft() {
        return DIRECTIONS.get((DIRECTIONS.indexOf(this) + 3) % DIRECTIONS.size());
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
