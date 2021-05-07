package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;

import java.util.List;

public interface FindByIdEstudiantesPort {
    EstudianteOutputDto findById(String id) throws Exception;
}
