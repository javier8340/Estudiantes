package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteSearchInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;

import java.util.List;

public interface FindByEstudiantePort {
    public List<EstudianteOutputDto> findBy(EstudianteSearchInputDto estudianteSearchInputDto);
}
