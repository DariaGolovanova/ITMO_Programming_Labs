package com.company;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Rotom extends Pokemon {
    public Rotom(String name, int level) {
        super(name, level);
        setStats(50, 50, 77, 95,77,91);
        setType(Type.GHOST, Type.ELECTRIC);
        setMove(new Swagger(), new DoubleTeam(), new Rest(), new Facade());
    }
}
