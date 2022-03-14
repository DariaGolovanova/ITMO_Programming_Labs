package com.company;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Happiny extends Pokemon {
    public Happiny(String name, int level) {
        super(name, level);
        setStats(100, 5, 5, 15, 65, 30);
        setType(Type.NORMAL);
        setMove(new Flamethrower(), new Confide());
    }

}
