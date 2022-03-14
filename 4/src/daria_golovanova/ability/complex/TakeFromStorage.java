package daria_golovanova.ability.complex;

import daria_golovanova.ItemNotFoundInStorageException;
import daria_golovanova.Storage;
import daria_golovanova.Storeable;

public class TakeFromStorage implements ComplexAbility<Storeable, Storage> {
    @Override
    public void execute(Storeable storeable, Storage src) {
//        if(src.getItems().contain(storeable))
        if(src.contains(storeable)) {
            src.removeItem(storeable);
            System.out.println("Предмет " + storeable + " убрали из хранилища " + src);
        } else {
            throw new ItemNotFoundInStorageException("Такого предмета нет в хранилище");
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
