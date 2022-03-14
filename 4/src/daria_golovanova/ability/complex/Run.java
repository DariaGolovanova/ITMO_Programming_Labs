package daria_golovanova.ability.complex;

import daria_golovanova.Hero;
import daria_golovanova.ability.simple.SimpleAbility;
import daria_golovanova.ability.target.TargetAbility;

public class Run implements ComplexAbility<Hero, Object>{

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


    @Override
    public void execute(Hero hero, Object o) {
        System.out.println("Персонаж "+ hero + " бежит к " + o);
    }
}
