package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;

public interface CreateEstudiantePort {
    public EstudianteOutputDto create(EstudianteInputDto estudianteInputDto);
}
