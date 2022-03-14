package com.company;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);
        pokemon.setCondition(new Effect().condition(Status.SLEEP));
    }

    protected String describe() {
        return "sleeps";
    }
}
