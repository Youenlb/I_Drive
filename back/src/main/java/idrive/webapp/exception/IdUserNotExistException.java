package idrive.webapp.exception;

public class IdUserNotExistException extends RuntimeException {
    public IdUserNotExistException(String message) {
        super(message);
    }
}
