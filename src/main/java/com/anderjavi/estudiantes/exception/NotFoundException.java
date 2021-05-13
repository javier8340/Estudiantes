package com.anderjavi.estudiantes.exception;



public class NotFoundException extends RuntimeException {

    public NotFoundException(String id) {
        super("No se pudo encontrar al estudiante con Id = " + id);
    }
    public NotFoundException() {
        super("No se pudo encontrar al estudiante");
    }
}
