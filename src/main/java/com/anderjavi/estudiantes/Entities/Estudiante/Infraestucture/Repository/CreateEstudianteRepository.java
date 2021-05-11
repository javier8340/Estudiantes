package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class CreateEstudianteRepository implements CreateEstudiantePort {

    private final EstudianteRepositoryJpa repository;

    @Override
    public EstudianteOutputDto create(EstudianteInputDto estudianteInputDto) {
        EstudianteJpa estudianteJpa = new EstudianteJpa(estudianteInputDto);
        repository.save(estudianteJpa);
        return new EstudianteOutputDto(estudianteJpa);
    }
}
