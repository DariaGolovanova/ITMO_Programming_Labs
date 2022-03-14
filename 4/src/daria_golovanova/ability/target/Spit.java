package daria_golovanova.ability.target;

public class Spit implements TargetAbility<Object>{
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж плюёт в " + target);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
