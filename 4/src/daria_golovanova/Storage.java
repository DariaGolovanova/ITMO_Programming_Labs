package daria_golovanova;

public interface Storage {
    double getSpace();

    double getFreeSpace();

    void addItem(Storeable storeable) throws NoEnoughSpaceException;

    void removeItem(Storeable storeable);

    default void printStorageSummary() {
        System.out.println(getFreeSpace() + " / " + getSpace());
    }
    boolean contains(Storeable src);
}
