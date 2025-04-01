package idrive.webapp.exception;

public class NoGamesPlayedForUserException extends RuntimeException {
    public NoGamesPlayedForUserException(String message) {
        super(message);
    }
}
