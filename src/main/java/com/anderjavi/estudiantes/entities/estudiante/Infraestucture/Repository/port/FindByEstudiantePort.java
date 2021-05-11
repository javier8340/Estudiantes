package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteSearchInputDto;

import java.util.List;

public interface FindByEstudiantePort {
    public List<EstudianteOutputDto> findBy(EstudianteSearchInputDto estudianteSearchInputDto);
}
