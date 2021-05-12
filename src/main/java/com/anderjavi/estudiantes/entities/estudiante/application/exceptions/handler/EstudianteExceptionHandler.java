package com.anderjavi.estudiantes.entities.estudiante.application.exceptions.handler;

import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.BranchException;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.CustomErrorResponse;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EstudianteExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({NotFoundException.class })
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


}

