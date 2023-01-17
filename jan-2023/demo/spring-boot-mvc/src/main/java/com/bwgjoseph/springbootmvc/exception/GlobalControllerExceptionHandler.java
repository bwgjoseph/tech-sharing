package com.bwgjoseph.springbootmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ProfileException.class)
    public ErrorResponse handleProfileException(ProfileException ex, HttpServletRequest request) {
        return new ErrorResponse(ex.getMessage(), request.getServletPath());
    }

    @Getter
    class ErrorResponse {
        private final String message;
        private final String path;

        ErrorResponse(String message, String path) {
            this.message = message;
            this.path = path;
        }
    }
}
