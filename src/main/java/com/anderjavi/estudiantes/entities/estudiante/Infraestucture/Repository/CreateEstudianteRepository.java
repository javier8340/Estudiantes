package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository;


import com.anderjavi.estudiantes.entities.estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.entities.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class CreateEstudianteRepository implements CreateEstudiantePort {

    private final EstudianteRepositoryJpa repository;

    @Override
    public EstudianteOutputDto create(EstudianteInputDto estudianteInputDto) {
        log.debug("Crear Usuario");
        EstudianteJpa estudianteJpa = new EstudianteJpa(estudianteInputDto);
        repository.save(estudianteJpa);
        return new EstudianteOutputDto(estudianteJpa);
    }
}
