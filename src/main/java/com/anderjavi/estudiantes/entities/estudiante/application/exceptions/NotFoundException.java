package com.anderjavi.estudiantes.entities.estudiante.application.exceptions;



public class NotFoundException extends RuntimeException {

    public NotFoundException(String id) {
        super("No se pudo encontrar al estudiante con Id = " + id);
    }
    public NotFoundException() {
        super("No se pudo encontrar al estudiante");
    }
}
