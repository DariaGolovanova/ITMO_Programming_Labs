package com.company;

import ru.ifmo.se.pokemon.*;

public class FlashCannon extends SpecialMove {
    public FlashCannon() {
        super(Type.STEEL, 80, 1.0);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);

        Effect lowSpecialDefence = new Effect().chance(0.1).turns(1).stat(Stat.SPECIAL_DEFENSE, -1);
        pokemon.addEffect(lowSpecialDefence);
    }

    @Override
    protected String describe() {
        return "attacks";
    }
}
