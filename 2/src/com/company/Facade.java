package com.company;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 1.0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);

        if(pokemon.getCondition() == Status.BURN || pokemon.getCondition() == Status.PARALYZE || pokemon.getCondition() == Status.POISON) {
            power *= 2;
        }
    }

    @Override
    protected String describe() {
        return "powers up";
    }
}