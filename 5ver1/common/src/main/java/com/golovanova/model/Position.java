package com.golovanova.model;

import java.util.Comparator;

/**
 * enum of Position
 */
public enum Position {
    LEAD_DEVELOPER(4),
    HEAD_OF_DIVISION(3),
    ENGINEER(2),
    BAKER(1),
    COOK(0);

    private int value;

    /**
     * @param value
     */
    Position(int value) {
        this.value = value;
    }

    /**
     * @return vlue
     */
    public int getValue() {
        return value;
    }

    /**
     * @return compared para
     */
    public static Comparator<Position> getComparator() {
        Comparator<Position> comparator = new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return Integer.compare(o1.getValue(), o2.getValue());
            }
        };

        return comparator;
    }
}
