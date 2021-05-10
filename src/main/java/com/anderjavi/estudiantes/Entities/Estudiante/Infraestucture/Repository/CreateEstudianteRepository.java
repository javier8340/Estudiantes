package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteInputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Repository
public class CreateEstudianteRepository implements CreateEstudiantePort {

    private final EstudianteRepositoryJpa repository;

    @Override
    public EstudianteJpa create(EstudianteInputDto estudianteInputDto) throws Exception {
        EstudianteJpa estudianteJpa = new EstudianteJpa(estudianteInputDto);
        repository.save(estudianteJpa);
        return estudianteJpa;
    }
}
