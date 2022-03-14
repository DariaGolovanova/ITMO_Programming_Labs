package daria_golovanova;

import java.util.Objects;

public class Napkin implements Storeable {
    private boolean isDirty = false;
    private ColourEnum colourEnum;
    private double value = 2;

    public Napkin(ColourEnum colourEnum) {
        this.colourEnum = colourEnum;
    }

    public Napkin(ColourEnum colourEnum, boolean isDirty) {
        this.colourEnum = colourEnum;
        this.isDirty = isDirty;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Napkin цвета " + colourEnum;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Napkin)) return false;
        Napkin napkin = (Napkin) o;
        return isDirty == napkin.isDirty &&
                Double.compare(napkin.value, value) == 0 &&
                colourEnum == napkin.colourEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDirty, colourEnum, value);
    }
}
