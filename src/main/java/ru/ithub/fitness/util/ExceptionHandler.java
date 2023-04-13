package ru.ithub.fitness.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionHandler {
    private final Logger logger = LogManager.getLogger();

    @org.springframework.web.bind.annotation.ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(
            HttpServletRequest request, BadCredentialsException ex
    ) {
        logger.error(ex.getClass().getSimpleName() + " {}\n", request.getRequestURI(), ex);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(
            HttpServletRequest request, NotFoundException ex
    ) {
        logger.error(ex.getClass().getSimpleName() + " {}\n", request.getRequestURI(), ex);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> handleAuthenticationException(
            HttpServletRequest request, AuthenticationException ex
    ) {
        logger.error(ex.getClass().getSimpleName() + " {}\n", request.getRequestURI(), ex);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(
            HttpServletRequest request, RuntimeException ex
    ) {
        logger.error(ex.getClass().getSimpleName() + " {}\n", request.getRequestURI(), ex);

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}