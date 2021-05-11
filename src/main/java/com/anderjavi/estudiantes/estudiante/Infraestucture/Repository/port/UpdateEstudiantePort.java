package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteInputDto;

public interface UpdateEstudiantePort {

     void update(String id, EstudianteInputDto estudianteInputDto) throws Exception;
}
