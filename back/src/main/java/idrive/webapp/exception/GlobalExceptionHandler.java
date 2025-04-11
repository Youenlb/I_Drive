package idrive.webapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{

    @ExceptionHandler(EmailAlreadyUseException.class)
    //Construct user error message
    public ResponseEntity<Map<String,String>> handleUserAlreadyExistsException(EmailAlreadyUseException ex)
    {
        //Construct body
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("type", "username");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserDontExistException.class)
    //Construct user error message
    public ResponseEntity<Map<String,String>> handleUserDontExistException(UserDontExistException ex)
    {
        //Construct body
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("type", "username");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserSuspendedException.class)
    //Construct user error message
    public ResponseEntity<Map<String,String>> handleUserSuspendedException(UserSuspendedException ex)
    {
        //Construct body
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("type", "username");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    //Construct user error message
    public ResponseEntity<Map<String,String>> handleInvalidPasswordException(InvalidPasswordException ex)
    {
        //Construct body
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("type", "password");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoGamesPlayedForUserException.class)
    //Construct user error message
    public ResponseEntity<Map<String,String>> handleNoGamesPlayedForUserException(NoGamesPlayedForUserException ex)
    {
        //Construct body
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("type", "game");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IdUserNotExistException.class)
    //Construct user error message
    public ResponseEntity<Map<String,String>> handleIdUserNotExistException(IdUserNotExistException ex)
    {
        //Construct body
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("type", "user");
        responseBody.put("message", ex.getMessage());

        return new ResponseEntity<>(responseBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
