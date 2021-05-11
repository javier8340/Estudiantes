package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;

import java.util.List;

public interface FindByEstudiantePort {
    public List<EstudianteOutputDto> findBy(EstudianteSearchInputDto estudianteSearchInputDto);
}
