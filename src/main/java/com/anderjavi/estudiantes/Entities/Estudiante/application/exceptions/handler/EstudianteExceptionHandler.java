package com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.handler;

import com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.First;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class EstudianteExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(First.class)
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

}

