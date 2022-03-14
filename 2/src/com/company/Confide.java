package com.company;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0 ,0);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        super.applyOppEffects(pokemon);

        Effect lowerSpecialAttack = new Effect().stat(Stat.SPECIAL_ATTACK, -1);
        pokemon.addEffect(lowerSpecialAttack);
    }

    @Override
    protected String describe() {
        return "puts effect";
    }
}