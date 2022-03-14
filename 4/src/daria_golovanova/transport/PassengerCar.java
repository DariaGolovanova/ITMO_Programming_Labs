package daria_golovanova.transport;

import daria_golovanova.ColourEnum;

public class PassengerCar extends Car {

    private static int SuperSpeed = 400;

    public PassengerCar(String name, ColourEnum colourEnum, int maxSpeed) {
        this.setName(name);
        this.setColourEnum(colourEnum);
        this.setMaxSpeed(maxSpeed);

    }

    class SuperEngine {
        public void start(){
            System.out.println("Машина с супердвигателем поехала.");
        }
        public void rev(){setMaxSpeed(SuperSpeed);
            System.out.println("Теперь у машины уникальная скорость.");}
        public void stop(){
            System.out.println("Машина с супердвигателем остановилась.");
        }
    }

    static class GetSuperSpeed {
        int getSuperSpeed() {
            return SuperSpeed;
        }
    }


    @Override
    public String beep() {
        return name + " издаёт тихий би-и-ип.";
    }

    @Override
    public String toString() {
        return "PassengerCar " + name;
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
