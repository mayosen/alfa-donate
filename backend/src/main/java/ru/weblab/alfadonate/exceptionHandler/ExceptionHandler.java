package ru.weblab.alfadonate.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.weblab.alfadonate.exception.NotFoundException;
import ru.weblab.alfadonate.responseDto.ExceptionDTO;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
