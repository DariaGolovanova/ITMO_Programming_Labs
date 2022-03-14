package daria_golovanova.ability.target;

public class Sit implements TargetAbility{
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж садится в " + target);
    }
}
