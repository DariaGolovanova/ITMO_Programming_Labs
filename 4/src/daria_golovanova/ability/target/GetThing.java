package daria_golovanova.ability.target;

public class GetThing implements TargetAbility{
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж получил объект " + target);
    }
}
