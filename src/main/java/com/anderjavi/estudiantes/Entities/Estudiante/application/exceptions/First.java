package com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions;

public class First extends RuntimeException{

    public First(Long id) {
        super("Book id not found : " + id);
    }
}
