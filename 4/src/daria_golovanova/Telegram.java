package daria_golovanova;


import java.util.Objects;

public class Telegram {
    private int lengthInSymbols;
    boolean packed = true;

    public Telegram(int lengthInSymbols) {
        this.lengthInSymbols = lengthInSymbols;
    }

    public Telegram(int lengthInSymbols, boolean packed) {
        this.lengthInSymbols = lengthInSymbols;
        this.packed = packed;
    }

    public int getLengthInSymbols() {
        return lengthInSymbols;
    }

    public void setLengthInSymbols(int lengthInSymbols) {
        this.lengthInSymbols = lengthInSymbols;
    }


    public void setPacked(boolean packed) {
        this.packed = packed;
    }

    public void unPackTelegram() {
        setPacked(false);
        System.out.println("Персонаж открыл телеграмму");
    }

    @Override
    public String toString() {
        return "Telegram длинной в " + lengthInSymbols + "символов";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telegram)) return false;
        Telegram telegram = (Telegram) o;
        return lengthInSymbols == telegram.lengthInSymbols &&
                packed == telegram.packed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lengthInSymbols, packed);
    }
}
