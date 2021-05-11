package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;

public interface UpdateEstudiantePort {

     void update(String id, EstudianteInputDto estudianteInputDto) throws Exception;
}
