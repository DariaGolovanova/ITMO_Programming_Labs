package daria_golovanova.transport;

import daria_golovanova.ColourEnum;

public class PassengerCar extends Car {

    public PassengerCar(String name, ColourEnum colourEnum, int maxSpeed) {
        this.setName(name);
        this.setColourEnum(colourEnum);
        this.setMaxSpeed(maxSpeed);

    }


    @Override
    public String beep() {
        return name + " издаёт тихий би-и-ип.";
    }

    @Override
    public String toString() {
        return "PassengerCar{" +
                "name='" + name + '\'' +
                ", colourEnum=" + colourEnum +
                ", maxSpeed=" + maxSpeed +
                '}';
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
