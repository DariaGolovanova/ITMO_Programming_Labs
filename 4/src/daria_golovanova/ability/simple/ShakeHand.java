package daria_golovanova.ability.simple;

public class ShakeHand implements SimpleAbility {
    @Override
    public void execute() {
        System.out.println("Персонаж машет рукой");
    }
}
