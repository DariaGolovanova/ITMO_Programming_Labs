package com.golovanova.model;


import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Coordinates {
    private static Double maxX = 721d; // - можно доставать из файлов .properties
    private Double x; //Максимальное значение поля: 721, Поле не может быть null
    private Float y; //Поле не может быть null

    /**
     * @param x should not be null
     * @param y should not be null
     */
    public Coordinates(@NotNull Double x, @NotNull Float y) {
        this.x = Math.min(x, maxX);
        this.y = y;
    }

    /**
     * @return y
     */
    public Float getY() {
        return y;
    }

    /**
     * @return x
     */
    public Double getX() {
        return x;
    }

    /**
     * @param o
     * @return equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }
}
