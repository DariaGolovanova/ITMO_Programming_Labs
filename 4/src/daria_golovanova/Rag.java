package daria_golovanova;

import java.util.Objects;

public class Rag implements Storeable {
    private boolean isDirty = false;
    private ColourEnum colourEnum;
    private double value = 1.0d;

    public Rag(ColourEnum colourEnum) {
        this.colourEnum = colourEnum;
    }

    public String wash() {
        return "Тряпка протирает";
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rag цвета " + colourEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rag)) return false;
        Rag rag = (Rag) o;
        return isDirty == rag.isDirty &&
                Double.compare(rag.value, value) == 0 &&
                colourEnum == rag.colourEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isDirty, colourEnum, value);
    }
}
