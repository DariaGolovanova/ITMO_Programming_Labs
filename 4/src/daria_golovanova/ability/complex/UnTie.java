package daria_golovanova.ability.complex;

import daria_golovanova.Storeable;

public class UnTie implements ComplexAbility <Character, Object> {
    @Override
    public void execute(Character character, Object o) {
        System.out.println(character + " развязал персонажа, который был свзяан при помощи объеката '" + o + "'");
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
