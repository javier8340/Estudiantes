package com.anderjavi.estudiantes.estudiante.application.exceptions;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;

public class EstudianteNotFoundException extends RuntimeException {

    public EstudianteNotFoundException(String id) {
        super("No se pudo encontrar al estudiante con Id = " + id);
    }
    public EstudianteNotFoundException() {
        super("No se pudo encontrar al estudiante");
    }
}
