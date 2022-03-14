package com.company;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);

        Effect raiseEvasion = new Effect().turns(1).stat(Stat.EVASION, 2);
        pokemon.addEffect(raiseEvasion);
    }

    @Override
    protected String describe() {
        return "puts effect";
    }
}
