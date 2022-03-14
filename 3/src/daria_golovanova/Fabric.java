package daria_golovanova;

public class Fabric {
    public Character create(CharacterEnum characterEnum) {
            if (characterEnum == characterEnum.SKUPERFIELD) {
                return new Character("Скуперфильд");
            }
            return new Character("Крабс");
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
