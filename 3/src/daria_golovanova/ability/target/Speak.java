package daria_golovanova.ability.target;

public class Speak implements TargetAbility<String> {
    @Override
    public void execute(String target) {
        System.out.println("Говорит с" + target);
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
