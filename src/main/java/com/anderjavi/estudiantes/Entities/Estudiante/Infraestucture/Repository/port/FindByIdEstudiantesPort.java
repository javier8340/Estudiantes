package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;

import java.util.List;

public interface FindByIdEstudiantesPort {
    EstudianteJpa findById(int id) throws Exception;
}
