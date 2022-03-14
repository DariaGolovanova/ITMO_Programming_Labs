package daria_golovanova.ability.target;

public class Drop implements TargetAbility{
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж уронил объект " + target);
    }
}
