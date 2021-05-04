package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    @Autowired
    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public void deleteById(int estudianteId) {
        estudianteRepositoryJpa.deleteById(estudianteId);
    }
}
