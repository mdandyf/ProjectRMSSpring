package controller;

import exception.ConnectionProblemException;
import exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> exceptionUserNotFound(UserNotFoundException exception) {
        return new ResponseEntity<Object>("User not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConnectionProblemException.class)
    public ResponseEntity<Object> exceptionConnectionProblem(ConnectionProblemException exception) {
        return new ResponseEntity<Object>("Cannot connect to service", HttpStatus.EXPECTATION_FAILED);
    }
}
