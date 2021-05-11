package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.estudiante.application.exceptions.EstudianteNotFoundException;

public interface FindByIdEstudiantesPort {
   EstudianteOutputDto findById(String id) throws EstudianteNotFoundException;
}
