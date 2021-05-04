package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.CreateEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

@AllArgsConstructor
public class CreateEstudianteRepository implements CreateEstudiantePort {

    JpaRepository repository;

    @Override
    public void create(Estudiante estudiante) throws Exception {
        EstudianteJpa estudianteJpa = new EstudianteJpa(estudiante);
        repository.save(estudianteJpa);
    }
}
