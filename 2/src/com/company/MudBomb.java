package com.company;

import ru.ifmo.se.pokemon.*;

public class MudBomb extends SpecialMove {
    public MudBomb() {
        super(Type.GROUND, 65, 0.85);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);

        Effect lowAccuracy = new Effect().chance(0.3).turns(1).stat(Stat.ACCURACY, -1);
        pokemon.addEffect(lowAccuracy);
    }

    @Override
    protected String describe() {
        return "attacks";
    }
}
