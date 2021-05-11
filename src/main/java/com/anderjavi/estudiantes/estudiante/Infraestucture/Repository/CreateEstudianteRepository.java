package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

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
