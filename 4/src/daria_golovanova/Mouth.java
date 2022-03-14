package daria_golovanova;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Mouth implements Storage {
    private final double space;
    private List<Storeable> items = new ArrayList<>();

    public Mouth() {
        this.space = 2;
    }

    public Mouth(double space) {
        this.space = space;
    }

    @Override
    public double getSpace() {
        return space;
    }

    @Override
    public double getFreeSpace() {
        double usedSpace = 0;
        for (Storeable s : items) {
            usedSpace += s.getValue();
        }

        return space - usedSpace;
    }

    @Override
    public void addItem(Storeable storeable) throws NoEnoughSpaceException{
        if (getFreeSpace() >= storeable.getValue()){
            items.add(storeable);
        } else throw new NoEnoughSpaceException("Хранилище заполнено");
    }

    @Override
    public void removeItem(Storeable storeable) {
        items.remove(storeable);
    }

    @Override
    public boolean contains(Storeable src) {
        return items.contains(src);
    }

    @Override
    public String toString() {
        return "Mouth " + items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mouth)) return false;
        Mouth mouth = (Mouth) o;
        return Double.compare(mouth.space, space) == 0 &&
                items.equals(mouth.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(space, items);
    }
}
