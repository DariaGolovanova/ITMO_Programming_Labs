package com.company;

import ru.ifmo.se.pokemon.*;

public class FireFang extends PhysicalMove {
    public FireFang() {
        super(Type.FIRE, 65, 0.95);

    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);

        Effect burn = new Effect().chance(0.1).turns(3).condition(Status.BURN);
        pokemon.addEffect(burn);

        if (Math.random() <= 0.1) {
            Effect.flinch(pokemon);
        }

    }


    @Override
    protected String describe() {
        return "attacks";
    }
}
