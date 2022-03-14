package daria_golovanova.ability.target;

import daria_golovanova.Storeable;

public class Crumple implements TargetAbility<Storeable> {
    @Override
    public void execute(Storeable object) {
        System.out.println("Персонаж мнёт " + object);
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
