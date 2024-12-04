package com.scoyle.users.exception;

import com.scoyle.users.utils.DateConversion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<GenericErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        GenericErrorResponse errorDetails =
                new GenericErrorResponse(DateConversion.formatDateToAppFormat(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
