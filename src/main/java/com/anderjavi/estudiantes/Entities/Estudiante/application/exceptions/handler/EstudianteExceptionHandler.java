package com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.handler;

import com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.BranchException;
import com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.CustomErrorResponse;
import com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.EstudianteNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EstudianteExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({EstudianteNotFoundException.class })
    public ResponseEntity<CustomErrorResponse> NotFoundHandler(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler({BranchException.class })
    public ResponseEntity<CustomErrorResponse> internalServerErrorHandler(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler({DataIntegrityViolationException.class })
    public ResponseEntity<CustomErrorResponse> databaseExceptionHandler(DataIntegrityViolationException exception, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(exception.getMostSpecificCause().getMessage());
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

