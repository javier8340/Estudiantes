package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.application.exceptions.EstudianteNotFoundException;

import java.util.List;
import java.util.Optional;

public interface FindByIdEstudiantesPort {
   EstudianteOutputDto findById(String id) throws EstudianteNotFoundException;
}
