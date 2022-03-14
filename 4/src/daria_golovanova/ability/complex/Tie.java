package daria_golovanova.ability.complex;

import daria_golovanova.Hero;

public class Tie implements ComplexAbility<Hero, Object> {
    @Override
    public void execute(Hero hero, Object o) {
        System.out.println(hero + " связал кого-то при помощи предмета '" + o + "'");
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
