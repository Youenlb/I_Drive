package idrive.webapp.exception;

public class UserDontExistException extends RuntimeException
{
    public UserDontExistException(String message)
    {
        super(message);
    }
}
