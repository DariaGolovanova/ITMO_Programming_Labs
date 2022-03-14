package daria_golovanova.ability.complex;

import daria_golovanova.Storage;
import daria_golovanova.Storeable;

public class Put implements ComplexAbility<Storeable, Storage> {
    @Override
    public void execute(Storeable storeable, Storage dist) {
        dist.addItem(storeable);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
