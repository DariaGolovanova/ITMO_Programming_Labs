package daria_golovanova.ability.target;

public class See implements TargetAbility{
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж увидел " + target);
    }
}
