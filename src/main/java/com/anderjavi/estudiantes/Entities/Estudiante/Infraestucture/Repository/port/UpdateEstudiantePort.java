package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;

public interface UpdateEstudiantePort {

     void update(String id, EstudianteInputDto estudianteInputDto) throws Exception;
}
