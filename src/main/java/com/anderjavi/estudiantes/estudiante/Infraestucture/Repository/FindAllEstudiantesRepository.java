package com.anderjavi.estudiantes.estudiante.Infraestucture.Repository;

import com.anderjavi.estudiantes.estudiante.Domain.EstudianteJpa;
import com.anderjavi.estudiantes.estudiante.Domain.dto.EstudianteOutputDto;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.jpa.EstudianteRepositoryJpa;
import com.anderjavi.estudiantes.estudiante.Infraestucture.Repository.port.FindAllEstudiantesPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class FindAllEstudiantesRepository implements FindAllEstudiantesPort {

    EstudianteRepositoryJpa estudianteRepositoryJpa;

    @Override
    public List<EstudianteOutputDto> findAll() {

        List<EstudianteOutputDto> listOut = new ArrayList<EstudianteOutputDto>();
        List<EstudianteJpa> listIn = estudianteRepositoryJpa.findAll();

        for(EstudianteJpa estudianteJpa : listIn) {
            listOut.add(new EstudianteOutputDto(estudianteJpa));
        }
        return listOut;
    }
}
