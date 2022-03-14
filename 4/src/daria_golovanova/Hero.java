package daria_golovanova;

import daria_golovanova.ability.complex.ComplexAbility;
import daria_golovanova.ability.simple.SimpleAbility;
import daria_golovanova.ability.target.TargetAbility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Hero {
    private String name;
    private boolean isSpited = false;
    private boolean isBind = false;

    private Mouth mouth = new Mouth();

    private Pocket pocket = new Pocket();
    private List<ComplexAbility> complexAbilities = new ArrayList<>();

    private List<TargetAbility> targetAbilities = new ArrayList<>();
    private List<SimpleAbility> simpleAbilities = new ArrayList<>();

    public List<ComplexAbility> getComplexAbilities() {
        return complexAbilities;
    }

    public List<TargetAbility> getTargetAbilities() {
        return targetAbilities;
    }

    public List<SimpleAbility> getSimpleAbilities() {
        return simpleAbilities;
    }

    public Hero(String name) {
        this.name = name;
    }

    public void setSpited(boolean spited) {
        this.isSpited = spited;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public Pocket getPocket() {
        return pocket;
    }

    public boolean isBind() {
        return isBind;
    }

    public void setBind(boolean bind) {
        isBind = bind;
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public void runAbility(SimpleAbility ability) {
        if (checkContainedAbility(simpleAbilities, ability)) {
            ability.execute();
        }
    }

    public <T> void runAbility(TargetAbility<T> ability, T target) {
        if (checkContainedAbility(targetAbilities, ability)) {
            ability.execute(target);
        }
    }

    public <T, R> void runAbility(ComplexAbility<T, R> ability, T t, R r) {
        if (checkContainedAbility(complexAbilities, ability)) {
            ability.execute(t, r);
        }
    }

    @Override
    public String toString() {
        return "Character по имени " + name;
    }

    private <A> boolean checkContainedAbility(List<A> abilities, A ability) {
        if (abilities.contains(ability)) {
            return true;
        } else {
            System.out.println("Нет такой способности! (" + ability + ")");
//            Builder b = new Builder();
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return isSpited == hero.isSpited &&
                name.equals(hero.name) &&
                mouth.equals(hero.mouth) &&
                pocket.equals(hero.pocket) &&
                complexAbilities.equals(hero.complexAbilities) &&
                targetAbilities.equals(hero.targetAbilities) &&
                simpleAbilities.equals(hero.simpleAbilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isSpited, mouth, pocket, complexAbilities, targetAbilities, simpleAbilities);
    }

//    public static class Builder {
//
//    }
}
