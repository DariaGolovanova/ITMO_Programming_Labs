package com.company;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 0.85);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.confuse();
        Effect raiseAttack = new Effect().turns(2).stat(Stat.ATTACK, 2);
        pokemon.addEffect(raiseAttack);
    }

    @Override
    protected String describe() {
        return "puts effect";
    }
}