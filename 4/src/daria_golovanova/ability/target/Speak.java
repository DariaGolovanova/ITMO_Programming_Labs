package daria_golovanova.ability.target;

import daria_golovanova.ability.complex.ComplexAbility;
import daria_golovanova.Hero;

public class Speak implements TargetAbility<Hero>{
    @Override
    public void execute(Hero hero) {
        System.out.println("Персонаж говорит с " + hero);
    }

//    @Override
//    public void execute(Hero hero, String s) {
//        System.out.println("Говорит персонажу "
//                + hero
//                + " эти слова с переводом в UPPERCASE: "
//                + new TranslatorToUppercase().translate(s)
//                + ".");
//    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    class TranslatorToUppercase {
//        GoogleTranslator googleTranslator;
//
//        public String translate(String message){
//            return message.toUpperCase();
//        }
//
//        public String translateToEnglish(String message) {
//            return googleTranslator.translate(Lang.RU, Lang.EN, message);
//        }
//    }
}
