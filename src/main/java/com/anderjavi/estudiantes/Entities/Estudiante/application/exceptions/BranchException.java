package com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions;

public class BranchException extends RuntimeException{

    public BranchException(String mensaje) {
        super(mensaje);
    }
    public BranchException() {
        super("branch no esta bien seleccionado");
    }
}
