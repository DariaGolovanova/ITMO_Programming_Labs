package daria_golovanova;

import daria_golovanova.ability.complex.Put;
import daria_golovanova.ability.complex.Tie;
import daria_golovanova.ability.simple.Low;
import daria_golovanova.ability.simple.ShakeHand;
import daria_golovanova.ability.simple.ShakeHead;
import daria_golovanova.ability.simple.SimpleAbility;
import daria_golovanova.ability.target.*;
import daria_golovanova.ability.complex.Run;
import daria_golovanova.transport.Car;
import daria_golovanova.transport.PassengerCar;
import daria_golovanova.tree.Tree;
import daria_golovanova.tree.TreeKindEnum;

public class Main {
    public static void main(String[] args) throws NoEnoughSpaceException {

//        User user = new User.Builder("Sergey", "Kargopolov")
//                .secondaryEmail("agasgs@gmail2.com")
//                .city("Vancouver")
//                .email("agasgs@gmail.com")
//                .build();

        Fabric fabric = new Fabric();
        Hero krabs = fabric.create(CharacterEnum.KRABS);
        Run krabsRun = new Run();
        krabs.getComplexAbilities().add(krabsRun);
        Tree tree = new Tree(TreeKindEnum.PINE, 12.0, 15);
        krabs.runAbility(krabsRun, krabs, tree);
        Rope rope = new Rope();
        Tie tieSkuperfield = new Tie();
        krabs.getComplexAbilities().add(tieSkuperfield);
        Hero skuperfield = fabric.create(CharacterEnum.SKUPERFIELD);
        krabs.runAbility(tieSkuperfield, krabs, rope);
        Swearing swearing = new Swearing() {
            @Override
            public void execute(Object target) {
                System.out.println("Персонаж " + target + " грязно ругается");
            }
        };
        skuperfield.getTargetAbilities().add(swearing);
        skuperfield.runAbility(swearing, skuperfield);

        Hat hat = new Hat(ColourEnum.BLACK);
        PickUp pickUpHat = new PickUp();
        krabs.getTargetAbilities().add(pickUpHat);
        krabs.runAbility(pickUpHat, hat);
        PutOnThing putOnThing = new PutOnThing();
        krabs.getTargetAbilities().add(putOnThing);
        krabs.runAbility(putOnThing, hat);
        Cane skuperfieldsCane = new Cane(ColourEnum.BLACK);
        Drop dropCane = new Drop();
        skuperfield.getTargetAbilities().add(dropCane);
        skuperfield.runAbility(dropCane,skuperfieldsCane);
        krabs.runAbility(putOnThing, krabs);

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


        Regurgitate skuperfieldSpit = new Regurgitate();
        skuperfield.getTargetAbilities().add(skuperfieldSpit);
        krabs.runAbility(tieSkuperfield, skuperfield, napkin);
        skuperfield.getTargetAbilities().remove(skuperfieldSpit);

        Low skuperfieldLow = new Low();
        skuperfield.getSimpleAbilities().add(skuperfieldLow);

        ShakeHead skuperfieldShakeHead = new ShakeHead();
        skuperfield.getSimpleAbilities().add(skuperfieldShakeHead);

        skuperfield.getTargetAbilities().remove(spitToCrabs);

        ShakeHand krabsShakeHand = new ShakeHand();
        krabs.getSimpleAbilities().add(krabsShakeHand);
        krabs.runAbility(krabsShakeHand);

        Sit sit = new Sit();
        krabs.getTargetAbilities().add(sit);
        krabs.runAbility(sit, car);

        Ride rideACar = new Ride();
        krabs.getTargetAbilities().add(rideACar);
        krabs.runAbility(rideACar, car);

        Hotel hotel = new Hotel(5);
        Telegram telegram = new Telegram(500);

        See seeTelegram = new See();
        krabs.getTargetAbilities().add(seeTelegram);
        krabs.runAbility(seeTelegram, telegram);

    }
}
