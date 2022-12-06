package member.project.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import member.project.entity.ErrorMessage;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleAuthorException(Exception ae) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage(
                "Exception: " + ae.getMessage(),
                ae.getClass().toString(),
                "Exception has occurred, Please check"), HttpStatus.BAD_REQUEST);
    }

}
