package com.kingofus.error;

import com.kingofus.domain.ErrorResponse;
import com.kingofus.exceptions.InvalidCredentialsException;
import com.kingofus.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = {InvalidCredentialsException.class, UserNotFoundException.class})
    public ResponseEntity handleException(Exception e, HttpServletRequest request) {
        return createErrorResponseEntity(e, request);
    }

    private ResponseEntity<ErrorResponse> createErrorResponseEntity(Exception e, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),
                        e.getClass().getSimpleName(), LocalDateTime.now(), request.getRequestURI()));
    }

}
