package com.company;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Onix extends Pokemon {
    public Onix(String name, int level) {
        super(name, level);
        setStats(35, 45, 160, 30, 45, 70);
        setType(Type.GROUND, Type.ROCK);
        setMove(new Swagger(), new FlashCannon(), new RockThrow());
    }
}