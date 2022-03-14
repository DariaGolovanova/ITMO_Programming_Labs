package com.company;

import ru.ifmo.se.pokemon.*;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon rotom = new Rotom("Вася", 4);
        Pokemon onix = new Onix("Игорь", 5);
        Pokemon steelix = new Steelix("Даша", 5);
        Pokemon happiny = new Happiny("Алёна", 4);
        Pokemon chansey = new Chansey("Лёша", 4);
        Pokemon blissey = new Blissey("Аня", 5);
        b.addAlly(rotom);
        b.addFoe(onix);
        b.addAlly(steelix);
        b.addFoe(happiny);
        b.addAlly(chansey);
        b.addFoe(blissey);
        b.go();
    }
}