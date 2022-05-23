package com.provai.senior.controller.exceptions;

import com.provai.senior.services.exceptions.EntityNotFoundException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

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

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request){
        return new ResponseEntity<>(new JSONObject().put("Invalid Input!",extractorValidatorMessage(exception)).toString(), HttpStatus.BAD_REQUEST);
    }

    private String extractorValidatorMessage(MethodArgumentNotValidException exception){
        String exceptionMessage = exception.getMessage();
        String[] parts = exceptionMessage.split(";");
        String finalMessages = parts[parts.length - 1];
        return finalMessages.trim().replaceAll("default message \\[|]]", "");
    }
}
