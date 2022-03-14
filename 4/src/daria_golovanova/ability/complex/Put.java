package daria_golovanova.ability.complex;

import daria_golovanova.NoEnoughSpaceException;
import daria_golovanova.Storage;
import daria_golovanova.Storeable;

public class Put implements ComplexAbility<Storeable, Storage> {
    @Override
    public void execute(Storeable storeable, Storage dist) {
        try {
            dist.addItem(storeable);
            System.out.println("Предмет " + storeable + " положили в хранилище " + dist);
        } catch (NoEnoughSpaceException e) {
            System.out.println("Не хватает места в " + dist);
        }
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
