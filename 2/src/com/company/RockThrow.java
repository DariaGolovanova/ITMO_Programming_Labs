package com.company;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class RockThrow extends PhysicalMove {
    public RockThrow() {
        super(Type.ROCK, 50, 0.9);
    }

    @Override
    protected String describe() {
        return "attacks";
    }
}