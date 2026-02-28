package org.example.todopersistence.Exceptions;

import org.example.todopersistence.Dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorResponse> TaskNotFoundExceptionHandler(TaskNotFoundException ex){
        ErrorResponse error = ErrorResponse.builder()
                .message("No se encontró la tarea con esa ID")
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
