package com.company;

import ru.ifmo.se.pokemon.Type;

public class Steelix extends Onix{
    public Steelix(String name, int level) {
        super(name, level);
        setStats(75, 85, 200, 55, 65, 30);
        setType(Type.STEEL, Type.GROUND);
        setMove(new Swagger(), new FlashCannon(), new RockThrow(), new FireFang());
    }
}