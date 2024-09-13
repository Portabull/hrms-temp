package com.portabull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> handleThrowable(Throwable throwable) {
        Map<String, Object> response = new HashMap<>();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<?> handleUnAuthorized(UnAuthorizedException unAuthorized) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "FAILED");
        response.put("statusCode", 401);
        response.put("message", unAuthorized.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}
