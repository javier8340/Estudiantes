package com.anderjavi.estudiantes.entities.estudiante.application.exceptions;



public class EstudianteNotFoundException extends RuntimeException {

    public EstudianteNotFoundException(String id) {
        super("No se pudo encontrar al estudiante con Id = " + id);
    }
    public EstudianteNotFoundException() {
        super("No se pudo encontrar al estudiante");
    }
}
