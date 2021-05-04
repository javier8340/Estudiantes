package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public void deleteById(int estudianteId) {
        estudianteRepositoryJpa.deleteById(estudianteId);
    }
}
