package daria_golovanova;

import daria_golovanova.ability.complex.ComplexAbility;
import daria_golovanova.ability.simple.SimpleAbility;
import daria_golovanova.ability.target.TargetAbility;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Character {
    private String name;
    private boolean isSpited = false;

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

    public Character(String name) {
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
        return "Character{" +
                "name='" + name + '\'' +
                '}';
    }

    private <A> boolean checkContainedAbility(List<A> abilities, A ability) {
        if (abilities.contains(ability)) {
            return true;
        } else {
            System.out.println("Нет такой способности! (" + ability + ")");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return isSpited == character.isSpited &&
                name.equals(character.name) &&
                mouth.equals(character.mouth) &&
                pocket.equals(character.pocket) &&
                complexAbilities.equals(character.complexAbilities) &&
                targetAbilities.equals(character.targetAbilities) &&
                simpleAbilities.equals(character.simpleAbilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isSpited, mouth, pocket, complexAbilities, targetAbilities, simpleAbilities);
    }
}
