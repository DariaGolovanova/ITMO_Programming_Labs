package com.company;

import ru.ifmo.se.pokemon.Type;

public class Blissey extends Chansey{
    public Blissey(String name, int level) {
        super(name, level);
        setStats(255, 10, 10, 75, 135, 55);
        setType(Type.NORMAL);
        setMove(new Flamethrower(), new Confide(), new MudBomb(), new SoftBoiled());
    }
}