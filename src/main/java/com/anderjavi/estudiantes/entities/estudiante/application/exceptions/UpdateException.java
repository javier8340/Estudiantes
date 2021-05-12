package com.anderjavi.estudiantes.entities.estudiante.application.exceptions;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;

public class UpdateException extends RuntimeException {

    public UpdateException(EstudianteInputDto estudianteInputDto, String id) {
        super("No se pudo actualizar estudiante -> " + id + "\n" + estudianteInputDto.toString());
    }

    public UpdateException() {
        super("No se pudo actualizar estudiante");
    }
}
