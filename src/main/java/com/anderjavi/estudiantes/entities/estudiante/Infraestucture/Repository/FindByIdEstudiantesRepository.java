package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.EstudianteNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class FindByIdEstudiantesRepository implements FindByIdEstudiantesPort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public EstudianteOutputDto findById(String id) throws EstudianteNotFoundException {
        return new EstudianteOutputDto(estudianteRepositoryJpa.findById(id).orElseThrow(() -> new EstudianteNotFoundException(id)));
    }
}
