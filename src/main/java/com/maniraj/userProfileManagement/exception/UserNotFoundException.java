package com.maniraj.userProfileManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        this("User not found.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Long id) {
        this("User not found with ID: " + id);
    }

    @RestControllerAdvice
    public static class UserControllerAdvice extends ResponseEntityExceptionHandler {

        @ExceptionHandler(UserNotFoundException.class)
        public ProblemDetail handleUserNotFoundException(UserNotFoundException ex) {
            return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
