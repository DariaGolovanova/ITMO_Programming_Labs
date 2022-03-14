package daria_golovanova.ability.complex;

import daria_golovanova.Character;

public class Tie implements ComplexAbility<Character, Object> {

    @Override
    public void execute(Character character, Object o) {
        System.out.println(character + " связал кого-то при помощи предмета '" + o + "'");
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
