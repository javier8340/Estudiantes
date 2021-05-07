package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public void deleteById(String estudianteId) {
        estudianteRepositoryJpa.deleteById(estudianteId);
    }
}
