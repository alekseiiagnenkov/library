package ru.development.library.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.development.library.enumiration.LibraryError;
import ru.development.library.exception.LibraryException;

import javax.validation.ValidationException;

/**
 * Централизированное управление ошибками.<br>
 * Все ошибки летят сюда.
 */
@Slf4j
@RestControllerAdvice
class CustomControllerAdvice {

    @ExceptionHandler(LibraryException.class)
    public ResponseEntity<String> handleLibraryExceptions(LibraryException e) {
        log.error(e.getClass().toString());
        log.error(e.getMessage());
        for (StackTraceElement element : e.getStackTrace())
            log.error(element.toString());
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.valueOf(400)
        );
    }

    @ExceptionHandler({ValidationException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<String> handleJsonExceptions(Exception e) {
        log.error(e.getClass().toString());
        log.error(e.getMessage());
        for (StackTraceElement element : e.getStackTrace())
            log.error(element.toString());
        return new ResponseEntity<>(
                LibraryError.VALIDATION_ERROR.getMessage(),
                HttpStatus.valueOf(400)
        );
    }

    @ExceptionHandler
    public ResponseEntity<String> handleOtherExceptions(Exception e) {
        log.error(e.getClass().toString());
        log.error(e.getMessage());
        for (StackTraceElement element : e.getStackTrace())
            log.error(element.toString());
        return new ResponseEntity<>(
                LibraryError.TECHNICAL_ERROR.getMessage(),
                HttpStatus.valueOf(400)
        );
    }
}
