package daria_golovanova;

public class Fabric {
    public Hero create(CharacterEnum characterEnum) {
        if (characterEnum == characterEnum.SKUPERFIELD) {
            return new Hero("Скуперфильд");
        }
        else if(characterEnum == characterEnum.SPRUTS){
            return new Hero("Спрутс");
        }
        return new Hero("Крабс");
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
