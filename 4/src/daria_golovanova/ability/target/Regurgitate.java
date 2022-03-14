package daria_golovanova.ability.target;

public class Regurgitate  implements  TargetAbility<Object>{
    @Override
    public void execute(Object object) {
        System.out.println("Персонаж выплёвывает " + object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
