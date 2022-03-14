package com.company;

import ru.ifmo.se.pokemon.*;

public class SoftBoiled extends StatusMove {
    public SoftBoiled() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        super.applySelfEffects(pokemon);

        double healHp = pokemon.getStat(Stat.HP);
        Effect healEffect = new Effect().stat(Stat.HP, (int) Math.round(healHp / 2));

        pokemon.addEffect(healEffect);
    }

    @Override
    protected String describe() {
        return "heals";
    }
}
