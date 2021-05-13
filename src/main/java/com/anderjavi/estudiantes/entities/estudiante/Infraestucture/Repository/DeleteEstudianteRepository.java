package com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.DeleteEstudiantePort;
import com.anderjavi.estudiantes.entities.estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import com.anderjavi.estudiantes.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@AllArgsConstructor
@Repository
public class DeleteEstudianteRepository implements DeleteEstudiantePort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;
    FindByIdEstudiantesPort findByIdEstudiantesPort;

    @Override
    public void deleteById(String estudianteId) {
        log.debug("borrando estudiante " + estudianteId);
        checkDeleteable(estudianteId);
        estudianteRepositoryJpa.deleteById(estudianteId);
    }

    private void checkDeleteable(String estudianteId){
        try {
            findByIdEstudiantesPort.findById(estudianteId);
        }catch (Exception e){
            log.debug("No se puede borrar porque no existe");
            throw new NotFoundException(estudianteId);
        }
    }
}
