package daria_golovanova;

import java.util.Objects;

public class Cane {
    private boolean isDropped = false;
    private ColourEnum colourEnum;
    private double value = 5;

    public Cane(ColourEnum colourEnum) {
        this.colourEnum = colourEnum;
    }

    public Cane (ColourEnum colourEnum, boolean isDropped) {
        this.colourEnum = colourEnum;
        this.isDropped = isDropped;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cane)) return false;
        Cane cane = (Cane) o;
        return isDropped == cane.isDropped &&
                Double.compare(cane.value, value) == 0 &&
                colourEnum == cane.colourEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDropped, colourEnum, value);
    }

    @Override
    public String toString() {
        return "Cane " +
                "цвета " + colourEnum;
    }
}
