package daria_golovanova;

public class ItemNotFoundInStorageException extends RuntimeException {
    public ItemNotFoundInStorageException(String message) {
        super(message);
    }
}
