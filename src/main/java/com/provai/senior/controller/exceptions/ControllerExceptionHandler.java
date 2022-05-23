package com.provai.senior.controller.exceptions;

import com.provai.senior.services.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 *
 * TODO: Implement handlerNotValidArgument(exception,headers,status,request)
 * TODO: Implement extractorValidatorMessage(exception)
 */

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound (EntityNotFoundException exception, HttpServletRequest httpServletRequest){
        StandardError error = new StandardError();
        error.setTime(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError(exception.getMessage());
        error.setPath(httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
