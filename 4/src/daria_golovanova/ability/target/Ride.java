package daria_golovanova.ability.target;

import daria_golovanova.Rideable;

public class Ride implements TargetAbility<Rideable> {

    @Override
    public void execute(Rideable target) {
        System.out.println("Персонаж едет на объекте " + target);
    }
}
