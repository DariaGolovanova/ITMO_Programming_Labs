package com.company;

import ru.ifmo.se.pokemon.Type;

public class Chansey extends Happiny {
    public Chansey(String name, int level) {
        super(name, level);
        setStats(250, 5 ,5, 35, 105, 50);
        setType(Type.NORMAL);
        setMove(new Flamethrower(), new Confide(), new MudBomb());
    }
}