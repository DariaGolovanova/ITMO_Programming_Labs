package daria_golovanova;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pocket implements Storage {
    private final double space;
    private List<Storeable> items = new ArrayList<>();

    public Pocket() {
        this.space = 5;
    }

    public Pocket(double space) {
        this.space = space;
    }

    @Override
    public double getSpace() {
        return space;
    }

    @Override
    public double getFreeSpace() {
        double usedSpace = 0;
        for(Storeable s : items){
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
        return "Pocket " + items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pocket)) return false;
        Pocket pocket = (Pocket) o;
        return Double.compare(pocket.space, space) == 0 &&
                items.equals(pocket.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(space, items);
    }
}
