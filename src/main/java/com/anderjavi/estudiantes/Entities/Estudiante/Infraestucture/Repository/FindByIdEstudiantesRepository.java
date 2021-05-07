package com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.Entities.Estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindAllEstudiantesPort;
import com.anderjavi.estudiantes.Entities.Estudiante.Infraestucture.Repository.port.FindByIdEstudiantesPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class FindByIdEstudiantesRepository implements FindByIdEstudiantesPort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public EstudianteOutputDto findById(String id) throws Exception {
        return new EstudianteOutputDto(estudianteRepositoryJpa.findById(id).orElseThrow(Exception::new));
    }
}
