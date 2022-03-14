package daria_golovanova.ability.target;

public class PutOnThing implements TargetAbility {
    @Override
    public void execute(Object target) {
        System.out.println("Персонаж кладёт предмет " + target + " на что-то");
    }
}
