package daria_golovanova;

import java.util.Objects;

public class Rope implements Storeable {

    private double value = 2.0d;
    private double length = 5.0d;


    public void setValue(double value) {
        this.value = value;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rope)) return false;
        Rope rope = (Rope) o;
        return Double.compare(rope.value, value) == 0 &&
                Double.compare(rope.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, length);
    }

    @Override
    public String toString() {
        return "Rope длинны " + length;
    }
}
