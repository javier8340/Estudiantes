package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.entities.estudiante.application.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.security.InvalidParameterException;

@AllArgsConstructor
@Repository
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;
    FindByIdEstudiantesPort findByIdEstudiantesPort;

    @Override
    public void deleteById(String estudianteId) {
        checkDeleteable(estudianteId);
        estudianteRepositoryJpa.deleteById(estudianteId);
    }

    private void checkDeleteable(String estudianteId){
        try {
            findByIdEstudiantesPort.findById(estudianteId);
        }catch (Exception e){
            throw new NotFoundException(estudianteId);
        }
    }
}
