package idrive.webapp.exception;

public class EmailAlreadyUseException extends RuntimeException
{
    public EmailAlreadyUseException(String message)
    {
        super(message);
    }
}
