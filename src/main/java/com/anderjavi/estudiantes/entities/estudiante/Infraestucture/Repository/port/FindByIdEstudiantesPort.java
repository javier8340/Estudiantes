package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.NotFoundException;



public interface FindByIdEstudiantesPort {
   EstudianteOutputDto findById(String id) throws NotFoundException;
}
