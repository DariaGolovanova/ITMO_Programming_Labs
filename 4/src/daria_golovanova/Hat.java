package daria_golovanova;

import java.util.Objects;

public class Hat implements Storeable {
    private boolean isDirty = false;
    private ColourEnum colourEnum;
    private double value = 5;

    public Hat(ColourEnum colourEnum) {
        this.colourEnum = colourEnum;
    }

    public Hat(ColourEnum colourEnum, boolean isDirty) {
        this.colourEnum = colourEnum;
        this.isDirty = isDirty;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hat)) return false;
        Hat hat = (Hat) o;
        return isDirty == hat.isDirty &&
                Double.compare(hat.value, value) == 0 &&
                colourEnum == hat.colourEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDirty, colourEnum, value);
    }

    @Override
    public String toString() {
        return "Hat " +
                "цвета " + colourEnum;
    }
}
