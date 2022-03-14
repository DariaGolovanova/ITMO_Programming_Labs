package com.company;

import ru.ifmo.se.pokemon.*;

public class Flamethrower extends SpecialMove {
    public Flamethrower() {
        super(Type.FIRE, 90, 1.0);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);

        Effect burn = new Effect().chance(0.1).turns(3).condition(Status.BURN);
        pokemon.addEffect(burn);
    }

    @Override
    protected String describe() {
        return "attacks";
    }
}
