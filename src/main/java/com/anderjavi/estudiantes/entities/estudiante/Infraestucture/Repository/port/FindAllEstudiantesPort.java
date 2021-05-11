package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port;


import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;

import java.util.List;

public interface FindAllEstudiantesPort {
    List<EstudianteOutputDto> findAll();
}
