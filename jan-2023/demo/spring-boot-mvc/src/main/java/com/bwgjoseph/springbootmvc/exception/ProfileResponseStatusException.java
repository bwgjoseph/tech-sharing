package com.bwgjoseph.springbootmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// control the http status, and message via @ResponseStatus
// this will be the default if no @ExceptionHandler is overriding it
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "profile response status exception")
public class ProfileResponseStatusException extends RuntimeException {
}
