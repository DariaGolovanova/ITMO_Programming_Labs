package daria_golovanova.ability.target;

public class PickUp implements TargetAbility<Object> {
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж поднимает " + target);
    }
}
