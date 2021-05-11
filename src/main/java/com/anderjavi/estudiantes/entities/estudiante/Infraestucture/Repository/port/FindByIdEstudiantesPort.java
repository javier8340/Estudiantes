package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.EstudianteNotFoundException;



public interface FindByIdEstudiantesPort {
   EstudianteOutputDto findById(String id) throws EstudianteNotFoundException;
}
