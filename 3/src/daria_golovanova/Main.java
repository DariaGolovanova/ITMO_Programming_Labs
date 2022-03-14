package daria_golovanova;

import daria_golovanova.ability.complex.Put;
import daria_golovanova.ability.complex.Tie;
import daria_golovanova.ability.simple.Low;
import daria_golovanova.ability.simple.ShakeHead;
import daria_golovanova.ability.target.Crumple;
import daria_golovanova.ability.target.Regurgitate;
import daria_golovanova.ability.target.Spit;
import daria_golovanova.transport.Car;
import daria_golovanova.transport.PassengerCar;

public class Main {
    public static void main(String[] args) {
        Fabric fabric = new Fabric();
        Character skuperfield = fabric.create(CharacterEnum.SKUPERFIELD);
        Character krabs = fabric.create(CharacterEnum.KRABS);
        Car car = new PassengerCar("Автомашина", ColourEnum.BLACK, 120);

        Spit spitToCrabs = new Spit();
        skuperfield.getTargetAbilities().add(spitToCrabs);
        skuperfield.runAbility(spitToCrabs, krabs);

        Rag rag = new Rag(ColourEnum.BLACK);
        rag.setDirty(true);
        krabs.getPocket().addItem(rag);
        krabs.getPocket().removeItem(rag);
        Crumple crumpleTheRag = new Crumple();
        krabs.getTargetAbilities().add(crumpleTheRag);
        krabs.runAbility(crumpleTheRag, rag);

        Put putAbility = new Put();
        krabs.getComplexAbilities().add(putAbility);
        krabs.runAbility(putAbility, rag, skuperfield.getMouth());

        Napkin napkin = new Napkin(ColourEnum.BLACK);
        Tie tieSkuperfield = new Tie();
        krabs.getComplexAbilities().add(tieSkuperfield);

        Regurgitate skuperfieldSpit = new Regurgitate();
        skuperfield.getTargetAbilities().add(skuperfieldSpit);
        krabs.runAbility(tieSkuperfield, skuperfield, napkin);
        skuperfield.getTargetAbilities().remove(skuperfieldSpit);

        Low skuperfieldLow = new Low();
        skuperfield.getSimpleAbilities().add(skuperfieldLow);

        ShakeHead skuperfieldShakeHead = new ShakeHead();
        skuperfield.getSimpleAbilities().add(skuperfieldShakeHead);

        skuperfield.getTargetAbilities().remove(spitToCrabs);

    }
}
