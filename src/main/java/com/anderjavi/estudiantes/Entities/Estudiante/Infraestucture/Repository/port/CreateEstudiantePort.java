package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;

public interface CreateEstudiantePort {
    public EstudianteJpa create(Estudiante estudiante) throws Exception;
}
