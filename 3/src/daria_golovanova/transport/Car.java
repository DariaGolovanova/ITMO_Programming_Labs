package daria_golovanova.transport;

import daria_golovanova.ColourEnum;

import java.util.Objects;

public abstract class Car {
    protected String name;
    protected ColourEnum colourEnum;
    protected int maxSpeed;

    public abstract String beep();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ColourEnum getColourEnum() {
        return colourEnum;
    }

    public void setColourEnum(ColourEnum colourEnum) {
        this.colourEnum = colourEnum;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", colourEnum=" + colourEnum +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return maxSpeed == car.maxSpeed &&
                name.equals(car.name) &&
                colourEnum == car.colourEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, colourEnum, maxSpeed);
    }
}
