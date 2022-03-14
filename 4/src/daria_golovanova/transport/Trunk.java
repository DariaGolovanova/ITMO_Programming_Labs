package daria_golovanova.transport;

import daria_golovanova.ColourEnum;

import java.util.Objects;

public class Trunk extends Car {

    public Trunk(String name, ColourEnum colourEnum, int maxSpeed) {
        setName(name);
        setColourEnum(colourEnum);
        setMaxSpeed(maxSpeed);

    }

    @Override
    public String beep() {
        return name + " издаёт громкий би-и-ип";
    }

    @Override
    public String toString() {
        return "Trunk "+ name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}