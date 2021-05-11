package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;

public interface CreateEstudiantePort {
    public EstudianteOutputDto create(EstudianteInputDto estudianteInputDto);
}
