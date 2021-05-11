package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.customError;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ResponseBody
public class EstudianteNotCreatedException extends RuntimeException{
    public EstudianteNotCreatedException(String message) {
        super(message);
    }
}
