package com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions;

public class EstudianteNotFoundException extends RuntimeException {
    public EstudianteNotFoundException(String id) {
        super("No se pudo encontrar al estudiante con Id = " + id);
    }
}
