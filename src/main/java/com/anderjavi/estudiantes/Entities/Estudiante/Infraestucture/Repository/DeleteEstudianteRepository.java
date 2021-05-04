package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.Estudiante;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositorJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    @Autowired
    EstudianteRepositorJpa estudianteRepositorJpa;

    @Override
    public void deleteById(int estudianteId) {
        estudianteRepositorJpa.deleteById(estudianteId);
    }
}
